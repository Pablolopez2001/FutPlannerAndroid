package com.futplanner.futplannerandroid.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Report implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private int id;

    @JsonProperty("player_id")
    private int playerId;

    @JsonProperty("match_id")
    private int matchId;

    @JsonProperty("general_performance")
    private int generalPerformance;

    @JsonProperty("tactical_performance")
    private int tacticalPerformance;

    @JsonProperty("passes_quality")
    private int passesQuality;

    @JsonProperty("ball_control")
    private int ballControl;

    @JsonProperty("game_vision")
    private int gameVision;

    @JsonProperty("played_time")
    private int playedTime;

    @JsonProperty("goals")
    private int goals;

    @JsonProperty("red_cards")
    private int redCards;

    @JsonProperty("yellow_cards")
    private int yellowCards;

    @JsonProperty("match")
    private Match match;

    public int getGeneralPerformance() {
        return generalPerformance;
    }

    public int getTacticalPerformance() {
        return tacticalPerformance;
    }

    public int getPassesQuality() {
        return passesQuality;
    }

    public int getBallControl() {
        return ballControl;
    }

    public int getId() {
        return id;
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getMatchId() {
        return matchId;
    }

    public int getGameVision() {
        return gameVision;
    }

    public int getPlayedTime() {
        return playedTime;
    }

    public int getGoals() {
        return goals;
    }

    public int getRedCards() {
        return redCards;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public Match getMatch() {
        return match;
    }
}