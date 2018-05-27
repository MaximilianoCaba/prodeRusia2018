package com.prode.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private Long id;

    @Column(name ="ROUND")
    private Integer round;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_TEAM_HOME")
    private Team teamHome;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_TEAM_AWAY")
    private Team teamAway;

    @Column(name = "GOAL_HOME")
    private Integer goalHome;

    @Column(name = "GOAL_AWAY")
    private Integer goalAway;

    @Column(name = "PENALTY_GOAL_HOME")
    private Integer penaltyGoalHome;

    @Column(name = "PENALTY_GOAL_AWAY")
    private Integer penaltyGoalAway;

    @Column(name = "DATE")
    private Timestamp date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_STATE")
    private MatchState matchState;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "match")
    @JsonIgnore
    private Set<MatchUser> matches;

    public Match() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer name) {
        this.round = name;
    }

    public Team getTeamHome() {
        return teamHome;
    }

    public void setTeamHome(Team teamHome) {
        this.teamHome = teamHome;
    }

    public Team getTeamAway() {
        return teamAway;
    }

    public void setTeamAway(Team teamAway) {
        this.teamAway = teamAway;
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

    public Set<MatchUser> getMatches() {
        return matches;
    }

    public void setMatches(Set<MatchUser> matches) {
        this.matches = matches;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public MatchState getMatchState() {
        return matchState;
    }

    public void setMatchState(MatchState matchState) {
        this.matchState = matchState;
    }
}
