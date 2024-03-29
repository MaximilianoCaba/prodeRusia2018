package com.prode.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;

@Entity
@Table(name = "match_user")
public class MatchUser {

    @Id
    @Column(name = "ID")
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_MATCH")
    private Match match;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_USER")
    private User user;

    @Column(name = "GOAL_HOME")
    private Integer goalHome;

    @Column(name = "GOAL_AWAY")
    private Integer goalAway;

    @Column(name = "PENALTY_GOAL_HOME")
    private Integer penaltyGoalHome;

    @Column(name = "PENALTY_GOAL_AWAY")
    private Integer penaltyGoalAway;

    public MatchUser() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Integer getPenaltyGoalHome() {
        return penaltyGoalHome;
    }

    public void setPenaltyGoalHome(Integer penaltyGoalHome) {
        this.penaltyGoalHome = penaltyGoalHome;
    }

    public Integer getPenaltyGoalAway() {
        return penaltyGoalAway;
    }

    public void setPenaltyGoalAway(Integer penaltyGoalAway) {
        this.penaltyGoalAway = penaltyGoalAway;
    }


    @Override
    public String toString() {

        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "";
        }
    }
}
