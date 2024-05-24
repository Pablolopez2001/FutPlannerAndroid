package com.futplanner.futplannerandroid.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Match {

    private int id;

    @JsonProperty("match_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime matchDate;

    @JsonProperty("map_coords")
    private String mapCoords;

    @JsonProperty("place_name")
    private String placeName;

    @JsonProperty("home_team_id")
    private int homeTeamId;

    @JsonProperty("home_team_name")
    private String homeTeamName;

    @JsonProperty("away_team_id")
    private Integer awayTeamId;

    @JsonProperty("away_team_name")
    private String awayTeamName;

    @JsonProperty("sub_category_id")
    private int subCategoryId;

    private int evaluated;

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDateTime matchDate) {
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

    public int getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(int homeTeamId) {
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

    public int getEvaluated() {
        return evaluated;
    }

    public void setEvaluated(int evaluated) {
        this.evaluated = evaluated;
    }
}