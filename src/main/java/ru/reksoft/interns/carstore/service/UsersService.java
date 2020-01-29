package ru.reksoft.interns.carstore.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.reksoft.interns.carstore.mapper.UsersMapper;
import ru.reksoft.interns.carstore.dao.UsersRepository;
import ru.reksoft.interns.carstore.dto.UsersDto;
import ru.reksoft.interns.carstore.entity.Users;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersMapper usersMapper;

    public UsersDto getUsers() {
        return usersMapper.toDto(usersRepository.getByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));
    }

    public List<UsersDto> findUsersAll() {
        return usersRepository.findAll().stream().map(usersMapper::toDto).collect(Collectors.toList());
    }
    public UsersDto createUser(UsersDto newUser) {
        Integer id=newUser.getId();
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        newUser.setRule("user");
        Users users= usersRepository.saveAndFlush(usersMapper.toEntity(newUser));
        UsersDto usersDto=usersMapper.toDto(users);
        return usersDto;
    }

    public UsersDto createAdmin(UsersDto newUser) {
        Integer id=newUser.getId();
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        newUser.setRule("admin");
        Users users= usersRepository.saveAndFlush(usersMapper.toEntity(newUser));
        UsersDto usersDto=usersMapper.toDto(users);
        return usersDto;
    }


    public UsersDto update(Integer id, UsersDto usersDto) {

        Users users= usersRepository.getById(id);
        usersMapper.updateUser(usersDto,users);
        return usersDto;
    }
}
