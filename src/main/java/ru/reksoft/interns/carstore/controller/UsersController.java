package ru.reksoft.interns.carstore.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.reksoft.interns.carstore.dto.UsersDto;
import ru.reksoft.interns.carstore.exceptions.NotValidException;
import ru.reksoft.interns.carstore.service.UsersService;

import javax.validation.Valid;
import java.security.Security;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UsersService usersService;

    @GetMapping("/mine")
    public UsersDto getDictCarcass() {
        return usersService.getUsers();
    }


    @PostMapping("")
    public UsersDto create(@RequestBody @Valid UsersDto newUser , BindingResult bindingResult) throws NotValidException {
        bindingResult.getAllErrors();
        if (bindingResult.hasErrors()) {
            throw new NotValidException(bindingResult);
        }
        else {
            return usersService.createUser(newUser);
        }
    }

    @PutMapping(value = "/{id}")
    public UsersDto update(@PathVariable Integer id, @RequestBody @Valid UsersDto usersDto,
                          BindingResult bindingResult) throws NotValidException {
        bindingResult.getAllErrors();
        if (bindingResult.hasErrors()) {
            throw new NotValidException(bindingResult);
        }
        else {
           return usersService.update(id, usersDto);
        }
    }
}