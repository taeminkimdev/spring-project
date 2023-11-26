package com.project.demo.service;

import com.project.demo.domain.User;
import com.project.demo.exceptions.LoginFail;

public interface IAuthService {
    public User login(String username, String password) throws LoginFail;
}
