package com.emmanuel.springsecurityclient.event;

import org.springframework.context.ApplicationEvent;

import com.emmanuel.springsecurityclient.entity.User;

import lombok.Getter;
import lombok.Setter;

// This is the registration complete now that will be published
@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {

    private User user;
    private String applicationUrl; // this is the url we have to create for the user to click on it

    public RegistrationCompleteEvent(User user, String applicationUrl) {
        super(user);
        this.user = user;
        this.applicationUrl = applicationUrl;
    }

}
