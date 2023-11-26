package com.project.demo.dao;

import org.springframework.stereotype.Component;

import com.project.demo.domain.User;
import com.project.demo.exceptions.NotExistUser;


@Component
public class UserDao {    
    public User findUser(String username) throws NotExistUser{
        User user;

        try{
            // DB 유저 데이터 불러오기
            user = new User(1, "username1234", "hashedPassword", "김태민");
        } catch(Exception e){ // not found
            throw new NotExistUser();
        }

        return user;
    }
}
