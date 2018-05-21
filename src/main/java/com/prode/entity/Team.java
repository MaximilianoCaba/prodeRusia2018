package com.prode.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private Long id;

    @Column(name ="NAME")
    private String name;

    @Column(name = "FIFA_CODE")
    private String fifaCode;

    @Column(name = "FLAG")
    private String flag;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teamHome")
    @JsonIgnore
    private Set<Match> matchHome;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teamAway")
    @JsonIgnore
    private Set<Match> matchAway;

    public Team() {
    }

    public Team(String name, String fifaCode, String flag) {
        this.name = name;
        this.fifaCode = fifaCode;
        this.flag = flag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFifaCode() {
        return fifaCode;
    }

    public void setFifaCode(String fifaCode) {
        this.fifaCode = fifaCode;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Set<Match> getMatchHome() {
        return matchHome;
    }

    public void setMatchHome(Set<Match> matchHome) {
        this.matchHome = matchHome;
    }

    public Set<Match> getMatchAway() {
        return matchAway;
    }

    public void setMatchAway(Set<Match> matchAway) {
        this.matchAway = matchAway;
    }


}
