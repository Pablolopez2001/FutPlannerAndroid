package com.futplanner.futplannerandroid.models;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Team {
    private int id;

    @JsonProperty("team_name")
    private String teamName;

    @JsonProperty("shield_url")
    private String shieldUrl;

    @JsonProperty("sub_category_id")
    private int subCategoryId;

    @JsonProperty("players")
    private ArrayList<Player>  players;

    @JsonProperty("club")
    private Club  club;


    @JsonProperty("club_id")
    private int clubId;


    public int getId() {
        return id;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getShieldUrl() {
        return shieldUrl;
    }

    public void setShieldUrl(String shieldUrl) {
        this.shieldUrl = shieldUrl;
    }

    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
