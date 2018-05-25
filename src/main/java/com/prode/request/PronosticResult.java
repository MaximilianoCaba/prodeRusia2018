package com.prode.request;

public class PronosticResult {

    private Long matchId;

    private Long userId;

    private Integer goalHome;

    private Integer goalAway;

    private Integer goalPenaltyHome;

    private Integer goalPenaltyAway;

    public PronosticResult() {
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getGoalHome() {
        return goalHome;
    }

    public void setGoalHome(Integer goalHome) {
        this.goalHome = goalHome;
    }

    public Integer getGoalAway() {
        return goalAway;
    }

    public void setGoalAway(Integer goalAway) {
        this.goalAway = goalAway;
    }

    public Integer getGoalPenaltyHome() {
        return goalPenaltyHome;
    }

    public void setGoalPenaltyHome(Integer goalPenaltyHome) {
        this.goalPenaltyHome = goalPenaltyHome;
    }

    public Integer getGoalPenaltyAway() {
        return goalPenaltyAway;
    }

    public void setGoalPenaltyAway(Integer goalPenaltyAway) {
        this.goalPenaltyAway = goalPenaltyAway;
    }
}
