package com.project.demo.auth.infra;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.project.demo.auth.domain.User;

@Mapper
public interface UserMapper {
    @Select("SELECT id, username, password, name FROM user WHERE id = #{id}")
    User findUserById(@Param("id") int id);
    
    @Select("SELECT id, username, password, name FROM user WHERE username = #{username}")
    User findUserByUsername(@Param("username") String username);
}
