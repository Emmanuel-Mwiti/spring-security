package com.emmanuel.springsecurityclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emmanuel.springsecurityclient.entity.User;
import com.emmanuel.springsecurityclient.event.RegistrationCompleteEvent;
import com.emmanuel.springsecurityclient.model.UserModel;
import com.emmanuel.springsecurityclient.service.UserServiceI;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class RegistrationController {

    @Autowired
    UserServiceI userService;

    // ? This is an even to use when you click- object of the event
    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping("/hello")
    public String getHello(){
        return "Hello Manu";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest request) {
        User user = userService.registerUser(userModel);
        // Once the user has registered is when now we want to create publish the event
        // Are you using events to have
        publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(request)));
        return "success";

    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

}
