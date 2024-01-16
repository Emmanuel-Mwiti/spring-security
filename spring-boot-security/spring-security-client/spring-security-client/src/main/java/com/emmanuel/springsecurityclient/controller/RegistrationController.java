package com.emmanuel.springsecurityclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emmanuel.springsecurityclient.entity.User;
import com.emmanuel.springsecurityclient.event.RegistrationCompleteEvent;
import com.emmanuel.springsecurityclient.model.UserModel;
import com.emmanuel.springsecurityclient.service.UserServiceI;

@RestController
public class RegistrationController {

    @Autowired
    UserServiceI userService;

    //? This is an even to use when you click- object of the event
    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel) {
        User user = userService.registerUser(userModel);
        // Once the user has registered is when now we want to create publish the event
        publisher.publishEvent(new RegistrationCompleteEvent(user, "url"));
        return "success";

    }

}
