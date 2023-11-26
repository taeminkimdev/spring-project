package com.project.demo.domain;

public class User {
    private int id;
    private String username;
    private String password;
    private String name;

    public User(int id, String username, String password, String name){
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
    }
    
    public boolean comparePassword(String password){
        return this.password == password;
    }
}
