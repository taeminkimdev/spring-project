package com.project.demo.auth.service;

import com.project.demo.auth.domain.User;
import com.project.demo.auth.exceptions.LoginFail;

public interface IAuthService {
    public User login(String username, String password) throws LoginFail;
}
