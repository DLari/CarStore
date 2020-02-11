package ru.reksoft.interns.carstore.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.reksoft.interns.carstore.dao.UsersRepository;
import ru.reksoft.interns.carstore.dto.UsersDto;
import ru.reksoft.interns.carstore.entity.Role;
import ru.reksoft.interns.carstore.entity.Users;

import java.util.Objects;

@Component
public class UsersMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UsersRepository usersRepository;

    public Users toEntity(UsersDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Users.class);
    }

//    public Users toEntity2(UsersDto dto) {
//        Role role;
//       if (dto.getRole() == "admin")
//          role = Role.admin;
//       else role = Role.user;
//        return new Users(
//                dto.getFio(),
//                dto.getDateOfBirth(),
//                dto.getLogin(),
//                dto.getPassword(),
//                dto.getPhoneNumber(),
//                dto.getAddress(),
//               role
//        );
//    }

    public UsersDto toDto(Users entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, UsersDto.class);
    }

    public Users updateUser(UsersDto usersDto, Users users) {
        users.setFio(usersDto.getFio());
        users.setLogin(usersDto.getLogin());
        users.setDateOfBirth(usersDto.getDateOfBirth());
        users.setPassword(usersDto.getPassword());
        if (usersDto.getRole() == "admin")
            users.setRole(Role.admin);
        else users.setRole(Role.user);
        usersRepository.saveAndFlush(users);
        return users;
    }

}
