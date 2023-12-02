package com.project.demo.auth.service;
import org.springframework.stereotype.Component;

import com.project.demo.auth.domain.User;
import com.project.demo.auth.exceptions.LoginFail;
import com.project.demo.auth.infra.UserMapper;
import com.project.demo.auth.service.IAuthService;

@Component
public class AuthServiceImp implements IAuthService{
    private UserMapper userMapper;

    public AuthServiceImp(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User login(String username, String password) throws LoginFail{
        User user = this.userMapper.findUserByUsername(username);
        if(!user.comparePassword(password)){ throw new LoginFail(); }

        return user;
    }
}
