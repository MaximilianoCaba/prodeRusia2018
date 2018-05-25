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
            Match match = matches.get(pronosticResult.getMatchId());
            if (match.getMatchState().getId() == 1) {
                if (pronosticResult.getGoalAway() != null && pronosticResult.getGoalHome() != null) {
                    MatchUser matchUser = new MatchUser();
                    Long matchUserId = Long.valueOf(String.valueOf(match.getId()).concat(String.valueOf(user.getId())));
                    matchUser.setId(matchUserId);
                    matchUser.setMatch(match);
                    matchUser.setUser(user);
                    matchUser.setGoalAway(pronosticResult.getGoalAway());
                    matchUser.setGoalHome(pronosticResult.getGoalHome());
                    if (match.getRound() > 3) {
                        if (pronosticResult.getGoalPenaltyAway() != null && pronosticResult.getGoalPenaltyHome() != null) {
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
