package com.futplanner.futplannerandroid.models;

public class LogInModel {
    private String username;
    private String password;

    public LogInModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
