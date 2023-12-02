package com.project.demo.auth.dto;

public class ResponseUser {
    private String name;

    public ResponseUser(String name) {
        this.name = name;
    }

    public String getName() { return this.name; }
}
