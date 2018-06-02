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

    public static String generateMatchInProgressWorkPlace(Match match) {
        String teamHome = match.getTeamHome().getName();
        String teamAway = match.getTeamAway().getName();
        return ""
                .concat("El partido ")
                .concat(teamHome)
                .concat("-")
                .concat(teamAway)
                .concat(" por la ronda")
                .concat(String.valueOf(match.getRound()))
                .concat(" esta por empezar! segui los resultados del prode desde esta url!");
    }

    public static String generateRankingWorkPlace(Result resultRound){

        String message = "";

        if(resultRound.getGeneralResult().size() >= 2){
            message = message.concat(resultRound.getGeneralResult().get(0).getUserName())
                    .concat("viene ganando con ")
                    .concat(String.valueOf(resultRound.getGeneralResult().get(0).getResult()))
                    .concat(JUMP_LINE)
                    .concat("atras lo sigue")

                    .concat(resultRound.getGeneralResult().get(1).getUserName())
                    .concat("con ")
                    .concat(String.valueOf(resultRound.getGeneralResult().get(1).getResult()))
                    .concat(JUMP_LINE)
                    .concat("para enterarte de mas entra a la app del prode!");
        }


        return message;
    }

    public static String generateUserRegisterWorkPlace(User user){
        return "".concat(user.getName()).concat(" acaba de registrarse al prode! vos que estas esperando?");


    }
}
