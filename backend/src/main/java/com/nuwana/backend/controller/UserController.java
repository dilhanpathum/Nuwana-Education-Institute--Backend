package com.nuwana.backend.controller;


import com.nuwana.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1/admin")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
}
