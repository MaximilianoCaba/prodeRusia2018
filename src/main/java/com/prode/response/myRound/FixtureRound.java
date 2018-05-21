package com.prode.response.myRound;

import java.util.ArrayList;
import java.util.List;

public class FixtureRound {

    private List<Round> rounds;

    public FixtureRound() {
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    public void setRound(Round round) {
        List<Round> rounds = this.getRounds();
        if (rounds == null)
            rounds = new ArrayList<>();
        rounds.add(round);
        this.setRounds(rounds);
    }
}
