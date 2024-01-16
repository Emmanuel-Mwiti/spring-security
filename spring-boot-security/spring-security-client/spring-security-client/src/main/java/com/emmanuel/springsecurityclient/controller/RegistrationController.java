package com.emmanuel.springsecurityclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emmanuel.springsecurityclient.entity.User;
import com.emmanuel.springsecurityclient.model.UserModel;
import com.emmanuel.springsecurityclient.service.UserServiceI;

@RestController
public class RegistrationController {

    @Autowired
    UserServiceI userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel) {
        User user = userService.registerUser(userModel);
        return "success";

    }

}
