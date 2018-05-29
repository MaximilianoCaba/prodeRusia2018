package com.prode.service.impl;

import com.prode.Utils.MatchUtility;
import com.prode.entity.Match;
import com.prode.entity.MatchUser;
import com.prode.entity.User;
import com.prode.repository.MatchRepository;
import com.prode.repository.MatchUserRepository;
import com.prode.repository.UserRepository;
import com.prode.response.myRound.FixtureRound;
import com.prode.response.home.Result;
import com.prode.response.myRound.OneMatch;
import com.prode.response.myRound.Round;
import com.prode.response.home.UserResult;
import com.prode.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private MatchUserRepository matchUserRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private UserRepository userRepository;

    private static Integer roundsWorldCup = 8;

    @Override
    public Result getResultRound() {

        List<MatchUser> matchUsers = matchUserRepository.findAll();

        Map<String, Integer> resultAllRound = new HashMap<>();


        Result result = new Result();

        for (int round = 1; round < roundsWorldCup; ++round) {

            int finalRound = round;

            List<MatchUser> matchesRoundUser = matchUsers
                    .stream()
                    .filter(userMatch -> userMatch.getMatch().getRound() == finalRound).collect(Collectors.toList());

            Map<String, Integer> resultRound = this.getResultRound(matchesRoundUser);

            resultAllRound = this.getResultAllRound(resultAllRound, resultRound);

            Map<Integer, List<UserResult>> generalRoundResult = result.getRoundResult();


            generalRoundResult.put(round, this.mapToUserResult(resultRound));

            result.setRoundResult(generalRoundResult);

        }

        result.setGeneralResult(this.mapToUserResult(resultAllRound));

        return result;
    }

    private Map<String, Integer> getResultRound(List<MatchUser> matchUsers) {

        Map<String, Integer> resultados = new HashMap<>();
        for (MatchUser matchUser : matchUsers) {

            Boolean ifGoalHome = matchUser.getMatch().getGoalHome() != null;
            Boolean ifGoalAway = matchUser.getMatch().getGoalAway() != null;

            if (ifGoalHome && ifGoalAway) {

                Integer points = resultados.get(matchUser.getUser().getName());

                if (points == null)
                    points = 0;

                points = points + MatchUtility.generatePointMatch(matchUser);

                resultados.put(matchUser.getUser().getName(), points);
            } else
                resultados.put(matchUser.getUser().getName(), 0);
        }
        return resultados;

    }

    private Map<String, Integer> getResultAllRound(Map<String, Integer> allRounds, Map<String, Integer> round) {

        round.forEach((user, generalPoints) -> {
            Integer points = allRounds.get(user);
            if (points == null)
                points = 0;
            points = points + generalPoints;
            allRounds.put(user, points);

        });

        return allRounds;
    }

    private List<UserResult> mapToUserResult(Map<String, Integer> resultRound) {

        Map<String, User> userMap = userRepository.findAll()
                .stream()
                .collect(Collectors.toMap(User::getName, Function.identity()));

        List<UserResult> userResultList = new ArrayList<>();

        userMap.forEach((key, user) -> {

            Integer point = resultRound.get(key);
            UserResult userResult = new UserResult();

            if(point == null)
                userResult.setResult(0);
            else
                userResult.setResult(point);

            userResult.setUserName(user.getName());
            userResult.setUserAvatar(user.getAvatar());

            userResultList.add(userResult);

        });

        userResultList
                .sort(Comparator.comparing(UserResult::getResult).reversed());

        return userResultList;

    }

    @Override
    public FixtureRound getFixture(User user) {

        List<Match> allMatches = matchRepository.findAll();
        List<MatchUser> allMatchesListUser = matchUserRepository.findAllByUser(user);
        FixtureRound fixtureRound = new FixtureRound();

        for (int round = 1; round < roundsWorldCup; ++round) {

            int finalRound = round;
            List<OneMatch> oneMatchList = new ArrayList<>();


            List<Match> roundMatches = allMatches.stream()
                    .filter(match -> match.getRound() == finalRound)
                    .collect(Collectors.toList());

            List<MatchUser> roundMatchUsers = allMatchesListUser.stream()
                    .filter(match -> match.getMatch().getRound() == finalRound)
                    .collect(Collectors.toList());

            roundMatches.forEach(oneMatch -> {

                MatchUser matchesUser = roundMatchUsers.stream()
                        .filter(match -> match.getMatch().getId().equals(oneMatch.getId()))
                        .findFirst()
                        .orElse(null);

                OneMatch oneMatchResult = new OneMatch();
                oneMatchResult.setMatch(oneMatch);
                if (matchesUser == null){
                    matchesUser = new MatchUser();
                    Long userMatchId = Long.valueOf(String.valueOf(user.getId()).concat(String.valueOf(oneMatch.getId())));
                    matchesUser.setId(userMatchId);
                    matchesUser.setMatch(oneMatch);
                    matchesUser.setUser(user);
                }
                oneMatchResult.setMatchUser(matchesUser);
                oneMatchList.add(oneMatchResult);


                oneMatchResult.setMatchUser(matchesUser);

            });

            Round newRound = new Round();
            newRound.setMatches(oneMatchList);
            newRound.setRound(round);
            fixtureRound.setRound(newRound);
        }

        return fixtureRound;
    }

}
