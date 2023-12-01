package com.project.demo.auth.service;

import com.project.demo.auth.domain.User;

public interface UserRepository {
    public User findUserById(int id);
    public User findUserByUsername(String username);
}
