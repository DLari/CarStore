package ru.reksoft.interns.carstore.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.reksoft.interns.carstore.dto.UsersDto;
import ru.reksoft.interns.carstore.service.UsersService;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
public class UsersControllerAdmin {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UsersService usersService;

    @GetMapping("")
    public List<UsersDto> read(){
        return usersService.findUsersAll();
    }

}
