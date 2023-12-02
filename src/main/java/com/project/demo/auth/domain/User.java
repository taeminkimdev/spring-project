package com.project.demo.auth.domain;

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
        return this.password.equals(password);
    }

    public int getId() { return this.id; }
    public String getUsername() { return this.username; }
    public String getName() { return this.name; }
}
