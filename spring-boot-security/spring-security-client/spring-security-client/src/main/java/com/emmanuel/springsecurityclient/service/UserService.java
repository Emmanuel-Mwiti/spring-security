package com.emmanuel.springsecurityclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import com.emmanuel.springsecurityclient.entity.User;
import com.emmanuel.springsecurityclient.entity.VerificationToken;
import com.emmanuel.springsecurityclient.model.UserModel;
import com.emmanuel.springsecurityclient.repository.UserRepositoryI;
import com.emmanuel.springsecurityclient.repository.VerificationTokenRepository;

@Service
public class UserService implements UserServiceI {

    @Autowired
    UserRepositoryI userRepository;

    @Autowired
    // VerificationTokenRepository verificationTokenRepository;
    VerificationTokenRepository verificationTokenRepository;

    // @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(UserModel userModel) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));

        userRepository.save(user);

        return user;
    }

    @Override
    public void saveVerificationForUser(String token, User user) {
        VerificationToken verificationToken = new VerificationToken(user, token);
        verificationTokenRepository.save(verificationToken);
    }
}
