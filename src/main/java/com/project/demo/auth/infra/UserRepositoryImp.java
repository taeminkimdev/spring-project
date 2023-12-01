package com.project.demo.auth.infra;

import org.springframework.stereotype.Component;

import com.project.demo.auth.domain.User;
import com.project.demo.auth.infra.dataSource.UserMapper;
import com.project.demo.auth.service.UserRepository;

@Component
public class UserRepositoryImp implements UserRepository{
    private UserMapper userMapper;

    public UserRepositoryImp(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public User findUserById(int id){
        return this.userMapper.findUserById(id);
    }
    public User findUserByUsername(String username){
        return this.userMapper.findUserByUsername(username);
    }
}
