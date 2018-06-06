package com.prode.Utils;

import com.prode.entity.Match;
import com.prode.entity.MatchUser;
import com.prode.entity.User;
import com.prode.response.home.Result;

import java.util.List;

public class MessengerUtility {

    private final static String JUMP_LINE = "\\r\\n";

    public static String generateMatchEmailMessage(Match match, List<MatchUser> matchUserList) {
        final String[] message = {""};
        String matchString = match.toString();
        message[0] = message[0]
                .concat(matchString);

        matchUserList.forEach(matchUser -> message[0] = message[0].concat(matchUser.toString()));
        return message[0];
    }

    public static String generateMatchEmailTitle(Match match) {
        return "[round]".concat(String.valueOf(match.getRound())).concat("[match]").concat(String.valueOf(match.getId()));
    }

    public static String generateRankingWorkPlace(Result resultRound){
        return "".concat("Los snoopies que vienen ganando en el dia son: ")
                .concat(generategeneralRound(resultRound));
    }

    public static String generateUserRegisterWorkPlace(User user){
        return "".concat(user.getName()).concat(" ya se registro y esta participando! Vos que estas esperando?");
    }


    public static String finalMatchResult(Result resultRound, Match match){

        String message = "Termino ";

        if(match.getPenaltyGoalAway() != null && match.getPenaltyGoalHome() != null){
            message = message.concat(match.getTeamHome().getName())
                    .concat(" (").concat(String.valueOf(match.getTeamHome())).concat(") ")
                    .concat(" (").concat(String.valueOf(match.getPenaltyGoalHome())).concat(") ")
                    .concat("vs")
                    .concat(" (").concat(String.valueOf(match.getPenaltyGoalAway())).concat(") ")
                    .concat(" (").concat(String.valueOf(match.getGoalAway())).concat(") ")
                    .concat(match.getTeamAway().getName());
        }else{
            message = message.concat(match.getTeamHome().getName())
                    .concat(" (").concat(String.valueOf(match.getTeamHome())).concat(") ")
                    .concat("vs")
                    .concat(" (").concat(String.valueOf(match.getGoalAway())).concat(") ")
                    .concat(match.getTeamAway().getName());
        }

        return message.concat(". Los snoopies Ganadores por ahora son: ")
                .concat(generateResultRound(resultRound, match.getRound()))
                .concat(generategeneralRound(resultRound));

    }

    public static String generateResultRound(Result result, Integer round){

        if(result.getRoundResult().get(round).size() >= 3){
            return "".concat("De la ronda: ")
                    .concat(String.valueOf(round))
                    .concat(result.getRoundResult().get(round).get(0).getUserName())
                    .concat("( ")
                    .concat(String.valueOf(result.getRoundResult().get(round).get(0).getResult()))
                    .concat(") ")
                    .concat(result.getRoundResult().get(round).get(1).getUserName())
                    .concat("( ")
                    .concat(String.valueOf(result.getRoundResult().get(round).get(1).getResult()))
                    .concat(") ")
                    .concat(result.getRoundResult().get(round).get(2).getUserName())
                    .concat("( ")
                    .concat(String.valueOf(result.getRoundResult().get(round).get(2).getResult()))
                    .concat(") ");

        }else
            return "";

    }

    public static String generategeneralRound(Result result){

        if(result.getGeneralResult().size() >= 3){
            return "".concat("En la tabla general: ")
                    .concat(result.getGeneralResult().get(0).getUserName())
                    .concat("( ")
                    .concat(String.valueOf(result.getGeneralResult().get(0).getResult()))
                    .concat(") ")
                    .concat(result.getGeneralResult().get(1).getUserName())
                    .concat("( ")
                    .concat(String.valueOf(result.getGeneralResult().get(1).getResult()))
                    .concat(") ")
                    .concat(result.getGeneralResult().get(2).getUserName())
                    .concat("( ")
                    .concat(String.valueOf(result.getGeneralResult().get(2).getResult()))
                    .concat(") ");

        }else
            return "";

    }
}
