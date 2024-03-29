package com.emmanuel.springsecurityclient.listener;

import java.util.UUID;
// @Slf4j

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import com.emmanuel.springsecurityclient.entity.User;
import com.emmanuel.springsecurityclient.event.RegistrationCompleteEvent;
import com.emmanuel.springsecurityclient.service.UserServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
    private final Logger LOGGER = LoggerFactory.getLogger(RegistrationCompleteEventListener.class);

    @Autowired
    private UserServiceI userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // create verification token for the user. It will be attached to the link.
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationForUser(token, user);
        // Then, send mail to user
        String url = event.getApplicationUrl() + "verify registration?token=" + token;
        //sendVerificationEmail()
        LOGGER.info("Click the link to verify your account: {}", url);

    }

}
