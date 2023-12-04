package com.project.demo.auth.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.auth.domain.User;
import com.project.demo.auth.dto.RequestLogin;
import com.project.demo.auth.dto.ResponseUser;
import com.project.demo.exceptions.LoginFail;
import com.project.demo.exceptions.NotAllowedUser;
import com.project.demo.auth.service.IAuthService;
import com.project.demo.auth.service.AuthServiceImp;

@RestController
public class AuthController {
    private IAuthService authService;

    public AuthController(IAuthService authService){
        this.authService = authService;
    }

    @PostMapping("login")
    public void login(HttpSession session, HttpServletResponse response, @RequestBody RequestLogin req) throws LoginFail{
        User user = authService.login(req.getUsername(), req.getPassword());
        session.setAttribute("user", user);


        Cookie cookie = new Cookie("SameSite", "None");
        response.addCookie(cookie);
    }

    @DeleteMapping("logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }

    @GetMapping("me")
    public ResponseUser me(HttpSession session) throws NotAllowedUser{
        User user = (User)session.getAttribute("user");
        if(user == null) {
            throw new NotAllowedUser();    
        }
        return new ResponseUser(user.getName());
    }
}
