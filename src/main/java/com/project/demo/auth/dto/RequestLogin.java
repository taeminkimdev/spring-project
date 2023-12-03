package com.project.demo.auth.dto;

public class RequestLogin {
    private String username;
    private String password;

    public RequestLogin() {}

    public RequestLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return this.username; }
    public String getPassword() { return this.password; }
}
