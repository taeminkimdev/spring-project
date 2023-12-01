package com.project.demo.auth.service;
import org.springframework.stereotype.Component;

import com.project.demo.auth.domain.User;
import com.project.demo.auth.service.IAuthService;
import com.project.demo.exceptions.LoginFail;

@Component
public class AuthServiceImp implements IAuthService{
    private UserRepository userRepository;

    public AuthServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String username, String password) throws LoginFail{
        User user;
        user = this.userRepository.findUserByUsername(username);
        if(!user.comparePassword(password)){ throw new LoginFail(); }

        return user;
    }
}
