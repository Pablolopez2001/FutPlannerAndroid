package com.futplanner.futplannerandroid.models;

public class ReportRequest {
    private int user_id;
    private String token;
    private int player_user_id;

    public ReportRequest(int id, String token, int player_user_id) {
        this.user_id = id;
        this.token = token;
        this.player_user_id = player_user_id;
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

    public int getPlayer_user_id() {
        return player_user_id;
    }

    public void setPlayer_user_id(int player_user_id) {
        this.player_user_id = player_user_id;
    }
}