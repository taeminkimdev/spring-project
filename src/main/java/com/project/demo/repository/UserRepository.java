package com.project.demo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.project.demo.domain.User;

@Component
@Mapper
public interface UserRepository {
    @Select("SELECT id, username, password, name FROM user WHERE id == #{id}")
    User findUserById(@Param("id") int id);
    
    @Select("SELECT id, username, password, name FROM user WHERE username == #{username}")
    User findUserByUsername(@Param("username") String username);
}
