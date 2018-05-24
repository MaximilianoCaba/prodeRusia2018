package com.prode.response.myRound;

import com.prode.entity.Match;
import com.prode.entity.MatchUser;

public class OneMatch {

    private Match match;
    private MatchUser matchUser;

    public OneMatch(Match match, MatchUser matchUser) {
        this.match = match;
        this.matchUser = matchUser;
    }

    public OneMatch() {
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public MatchUser getMatchUser() {
        return matchUser;
    }

    public void setMatchUser(MatchUser matchUser) {
        this.matchUser = matchUser;
    }
}
