package com.prode.request;

import java.util.List;

public class UserFixtureRound {

    private int round;

    private List<PronosticResult> pronosticResults;

    public UserFixtureRound() {
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public List<PronosticResult> getPronosticResults() {
        return pronosticResults;
    }

    public void setPronosticResults(List<PronosticResult> pronosticResults) {
        this.pronosticResults = pronosticResults;
    }
}
