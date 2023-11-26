package com.project.demo.service;
import com.project.demo.repository.UserRepository;

import org.springframework.stereotype.Component;

import com.project.demo.domain.User;
import com.project.demo.exceptions.LoginFail;
import com.project.demo.exceptions.NotExistUser;
import com.project.demo.service.IAuthService;

@Component
public class AuthServiceImp implements IAuthService{
    private UserRepository userRepository;

    public AuthServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String username, String password) throws LoginFail{
        User user;

        try{
            user = this.userRepository.findUser(username);
        } catch (NotExistUser e){
            throw new LoginFail();
        }

        if(!user.comparePassword(password)){ throw new LoginFail(); }
            return user;
    }
}
