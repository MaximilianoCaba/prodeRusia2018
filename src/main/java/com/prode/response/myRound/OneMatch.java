package com.prode.response.myRound;

import com.prode.entity.Match;
import com.prode.entity.UserMatch;

public class OneMatch {

    private Match match;
    private UserMatch userMatch;

    public OneMatch(Match match, UserMatch userMatch) {
        this.match = match;
        this.userMatch = userMatch;
    }

    public OneMatch() {
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public UserMatch getUserMatch() {
        return userMatch;
    }

    public void setUserMatch(UserMatch userMatch) {
        this.userMatch = userMatch;
    }
}
