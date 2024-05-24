package com.futplanner.futplannerandroid.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NewMatch {

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("token")
    private String token;

    @JsonProperty("match_date")
    private long matchDate;

    @JsonProperty("map_coords")
    private String mapCoords;

    @JsonProperty("place_name")
    private String placeName;

    @JsonProperty("home_team_id")
    private Integer homeTeamId;

    @JsonProperty("home_team_name")
    private String homeTeamName;

    @JsonProperty("away_team_id")
    private Integer awayTeamId;

    @JsonProperty("away_team_name")
    private String awayTeamName;

    @JsonProperty("sub_category_id")
    private int subCategoryId;

    // Getters y Setters

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(long matchDate) {
        this.matchDate = matchDate;
    }

    public String getMapCoords() {
        return mapCoords;
    }

    public void setMapCoords(String mapCoords) {
        this.mapCoords = mapCoords;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Integer getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(Integer homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public Integer getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(Integer awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }
}