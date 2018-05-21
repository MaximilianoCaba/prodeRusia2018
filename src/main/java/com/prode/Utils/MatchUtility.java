package com.prode.Utils;

import com.prode.entity.UserMatch;

public class MatchUtility {

    private final static Integer ACIERTO_RESULTADO_TOTAL = 2;
    private final static Integer ACIERTO_RESULTADO_PARCIAL = 1;
    private final static Integer ACIERTO_PENALES_TOTAL = 2;
    private final static Integer ACIERTO_PENALES_PARCIAL = 1;

    private final static String WIN_HOME = "HOME";
    private final static String WIN_AWAY = "AWAY";
    private final static String DRAW = "DRAW";

    public static Integer generatePointMatch(UserMatch userMatch) {
        Integer points = 0;

        Integer myGoalhome = userMatch.getGoalHome();
        Integer myGoalAway = userMatch.getGoalAway();
        Integer goalHome = userMatch.getMatch().getGoalHome();
        Integer goalAway = userMatch.getMatch().getGoalAway();
        Integer goalHomePenalty = userMatch.getPenaltyGoalHome();
        Integer goalAwayPenalty = userMatch.getPenaltyGoalAway();
        Integer myGoalHomePenalty = userMatch.getMatch().getPenaltyGoalHome();
        Integer myGoalAwayPenalty = userMatch.getMatch().getPenaltyGoalAway();


        if (goalHomePenalty != null && goalAwayPenalty != null) {
            if (goalHomePenalty.equals(myGoalHomePenalty) && goalAwayPenalty.equals(myGoalAwayPenalty))
                points += ACIERTO_PENALES_TOTAL;
            else if (howWin(goalHomePenalty, goalAwayPenalty).equals(howWin(myGoalHomePenalty, myGoalAwayPenalty)))
                points += ACIERTO_PENALES_PARCIAL;
        }

        if (goalHome.equals(myGoalhome) && goalAway.equals(myGoalAway))
            points += ACIERTO_RESULTADO_TOTAL;
        else if (howWin(goalHome, goalAway).equals(howWin(myGoalhome, myGoalAway)))
            points += ACIERTO_RESULTADO_PARCIAL;

        return points;
    }


    private static String howWin(Integer goalHome, Integer goalAway) {
        if (goalAway.equals(goalHome)) {
            return DRAW;
        } else {
            if (goalHome > goalAway) {
                return WIN_HOME;
            } else
                return WIN_AWAY;
        }
    }
}
