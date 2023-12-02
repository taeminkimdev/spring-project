package com.project.demo.auth.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.auth.domain.User;
import com.project.demo.auth.dto.ResponseUser;
import com.project.demo.auth.service.IAuthService;
import com.project.demo.auth.service.AuthServiceImp;

import com.project.demo.exceptions.LoginFail;

@RestController
public class AuthController {
    private IAuthService authService;

    public AuthController(IAuthService authService){
        this.authService = authService;
    }

    @PostMapping("login")
    public void login(HttpSession session, String username, String password) throws LoginFail{
        User user = authService.login(username, password);
        session.setAttribute("user", user);
    }

    @DeleteMapping("logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }

    @GetMapping("me")
    public ResponseUser me(HttpSession session) {
        User user = (User)session.getAttribute("user");
        return new ResponseUser(user.getName());
    }
}
