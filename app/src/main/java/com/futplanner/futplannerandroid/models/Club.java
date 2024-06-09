package com.futplanner.futplannerandroid.models;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Club {

    private int id;

    @JsonProperty("club_name")
    private String clubName;

    @JsonProperty("shield_url")
    private String shieldUrl;

    @JsonProperty("owner_id")
    private int ownerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getShieldUrl() {
        return shieldUrl;
    }

    public void setShieldUrl(String shieldUrl) {
        this.shieldUrl = shieldUrl;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
