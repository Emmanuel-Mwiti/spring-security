package com.emmanuel.springsecurityclient.service;

import com.emmanuel.springsecurityclient.entity.User;
import com.emmanuel.springsecurityclient.model.UserModel;

public interface UserServiceI {

    User registerUser(UserModel userModel);

    void saveVerificationForUser(String token, User user);
    
}
