package com.project.demo.util;

public class IdGenerator {
    public static int createId() {
        return (int)System.currentTimeMillis() / 1000;
    }
}
