package com.prode.service.impl;

import com.prode.entity.Match;
import com.prode.entity.MatchUser;
import com.prode.entity.User;
import com.prode.repository.MatchRepository;
import com.prode.repository.MatchUserRepository;
import com.prode.request.PronosticResult;
import com.prode.service.UserMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserMatchServiceImpl implements UserMatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchUserRepository matchUserRepository;

    @Override
    public String savePronosticResult(List<PronosticResult> pronosticResultList, User user) {

        pronosticResultList = pronosticResultList
                .stream()
                .filter(pronosticResult -> pronosticResult.getUserId().equals(user.getId()))
                .collect(Collectors.toList());

        Map<Long, Match> matches = matchRepository.findAll()
                .stream()
                .collect(Collectors.toMap(Match::getId, Function.identity()));

        List<MatchUser> matchUserList = new ArrayList<>();

        pronosticResultList.forEach(pronosticResult -> {

            boolean validgoalHome = pronosticResult.getGoalHome() != null && pronosticResult.getGoalHome() >= 0;
            boolean validgoalAway = pronosticResult.getGoalAway() != null && pronosticResult.getGoalAway() >= 0;
            boolean validgoalPenaltyHome = pronosticResult.getGoalPenaltyHome() != null && pronosticResult.getGoalPenaltyHome() >= 0;
            boolean validgoalPenaltyAway = pronosticResult.getGoalPenaltyAway() != null && pronosticResult.getGoalPenaltyAway() >= 0;

            Match match = matches.get(pronosticResult.getMatchId());
            if (match.getMatchState().getId() == 1) {
                if (validgoalHome && validgoalAway) {
                    MatchUser matchUser = new MatchUser();
                    String matchUserId = String.valueOf(user.getId()).concat("_").concat(String.valueOf(match.getId()));
                    matchUser.setId(matchUserId);
                    matchUser.setMatch(match);
                    matchUser.setUser(user);
                    matchUser.setGoalAway(pronosticResult.getGoalAway());
                    matchUser.setGoalHome(pronosticResult.getGoalHome());
                    if (match.getRound() > 3) {
                        if (validgoalPenaltyHome && validgoalPenaltyAway) {
                            matchUser.setPenaltyGoalAway(pronosticResult.getGoalPenaltyAway());
                            matchUser.setPenaltyGoalHome(pronosticResult.getGoalPenaltyHome());
                            matchUserList.add(matchUser);
                        }
                    } else matchUserList.add(matchUser);
                }
            }
        });

        try {
            matchUserRepository.save(matchUserList);
            return "OK";
        } catch (Exception e) {
            return "Error interno de la app, por favor contacte con el administrador";
        }
    }
}
