package com.secure.advance.controller;

import com.secure.advance.model.User;
import com.secure.advance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/users")
    public List<User> findAllUser() {
        return service.findAll();
    }
}
