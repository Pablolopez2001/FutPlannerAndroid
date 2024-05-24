package com.futplanner.futplannerandroid.models;

public class TokenRequest {
    private int user_id;
    private String token;

    public TokenRequest(int id, String token) {
        this.user_id = id;
        this.token = token;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}