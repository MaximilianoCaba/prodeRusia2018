package com.prode.response.myRound;

import java.util.List;

public class Round {

    private Integer round;
    private List<OneMatch> matches;

    public Round() {
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public List<OneMatch> getMatches() {
        return matches;
    }

    public void setMatches(List<OneMatch> matches) {
        this.matches = matches;
    }
}
