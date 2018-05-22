package com.prode.request;

public class PronosticResult {

    private int matchId;

    private int userId;

    private int goalHome;

    private int goalAway;

    private int goalPenaltyHome;

    private int goalPenaltyAway;

    public PronosticResult() {
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGoalHome() {
        return goalHome;
    }

    public void setGoalHome(int goalHome) {
        this.goalHome = goalHome;
    }

    public int getGoalAway() {
        return goalAway;
    }

    public void setGoalAway(int goalAway) {
        this.goalAway = goalAway;
    }

    public int getGoalPenaltyHome() {
        return goalPenaltyHome;
    }

    public void setGoalPenaltyHome(int goalPenaltyHome) {
        this.goalPenaltyHome = goalPenaltyHome;
    }

    public int getGoalPenaltyAway() {
        return goalPenaltyAway;
    }

    public void setGoalPenaltyAway(int goalPenaltyAway) {
        this.goalPenaltyAway = goalPenaltyAway;
    }
}
