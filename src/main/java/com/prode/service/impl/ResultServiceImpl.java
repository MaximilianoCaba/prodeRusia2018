package com.prode.service.impl;

import com.prode.Utils.MatchUtility;
import com.prode.entity.Match;
import com.prode.entity.User;
import com.prode.entity.UserMatch;
import com.prode.repository.MatchRepository;
import com.prode.repository.UserMatchRepository;
import com.prode.response.myRound.FixtureRound;
import com.prode.response.home.Result;
import com.prode.response.myRound.OneMatch;
import com.prode.response.myRound.Round;
import com.prode.response.home.UserResult;
import com.prode.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private UserMatchRepository userMatchRepository;

    @Autowired
    private MatchRepository matchRepository;

    private static Integer roundsWorldCup = 8;

    @Override
    public Result getResultRound() {

        List<UserMatch> userMatches = userMatchRepository.findAll();

        Map<String, Integer> resultAllRound = new HashMap<>();


        Result result = new Result();

        for (int round = 1; round < roundsWorldCup; ++round) {

            int finalRound = round;

            List<UserMatch> userMatchesRound = userMatches
                    .stream()
                    .filter(userMatch -> userMatch.getMatch().getRound() == finalRound).collect(Collectors.toList());

            Map<String, Integer> resultRound = this.getResultRound(userMatchesRound);

            resultAllRound = this.getResultAllRound(resultAllRound, resultRound);

            Map<Integer, List<UserResult>> generalRoundResult = result.getRoundResult();


            generalRoundResult.put(round, this.mapToUserResult(resultRound));

            result.setRoundResult(generalRoundResult);

        }

        result.setGeneralResult(this.mapToUserResult(resultAllRound));

        return result;
    }

    private Map<String, Integer> getResultRound(List<UserMatch> userMatches) {

        Map<String, Integer> resultados = new HashMap<>();
        for (UserMatch userMatch : userMatches) {

            Boolean ifGoalHome = userMatch.getMatch().getGoalHome() != null;
            Boolean ifGoalAway = userMatch.getMatch().getGoalAway() != null;

            if (ifGoalHome && ifGoalAway) {

                Integer points = resultados.get(userMatch.getUser().getName());

                if (points == null)
                    points = 0;

                points = points + MatchUtility.generatePointMatch(userMatch);

                resultados.put(userMatch.getUser().getName(), points);
            } else
                resultados.put(userMatch.getUser().getName(), 0);
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

        List<UserResult> userResultList = new ArrayList<>();

        resultRound.forEach((key, value) -> {
            UserResult userResult = new UserResult();
            userResult.setUserName(key);
            userResult.setResult(value);

            userResultList.add(userResult);

        });

        userResultList
                .sort(Comparator.comparing(UserResult::getResult).reversed());

        return userResultList;

    }

    @Override
    public FixtureRound getFixture(User user) {

        List<Match> allMatches = matchRepository.findAll();
        List<UserMatch> allUserMatchesList = userMatchRepository.findAllByUser(user);
        FixtureRound fixtureRound = new FixtureRound();

        for (int round = 1; round < roundsWorldCup; ++round) {

            int finalRound = round;
            List<OneMatch> oneMatchList = new ArrayList<>();


            List<Match> roundMatches = allMatches.stream()
                    .filter(match -> match.getRound() == finalRound)
                    .collect(Collectors.toList());

            List<UserMatch> roundUserMatches = allUserMatchesList.stream()
                    .filter(match -> match.getMatch().getRound() == finalRound)
                    .collect(Collectors.toList());

            roundMatches.forEach(oneMatch -> {

                UserMatch userMatches = roundUserMatches.stream()
                        .filter(match -> match.getMatch().getId().equals(oneMatch.getId()))
                        .findFirst()
                        .orElse(null);

                OneMatch oneMatchResult = new OneMatch();
                oneMatchResult.setMatch(oneMatch);
                if (userMatches == null){
                    userMatches = new UserMatch();
                    Long userMatchId = Long.valueOf(String.valueOf(user.getId()).concat(String.valueOf(oneMatch.getId())));
                    userMatches.setId(userMatchId);
                    userMatches.setMatch(oneMatch);
                    userMatches.setUser(user);
                }
                oneMatchResult.setUserMatch(userMatches);
                oneMatchList.add(oneMatchResult);


                oneMatchResult.setUserMatch(userMatches);

            });

            Round newRound = new Round();
            newRound.setMatches(oneMatchList);
            newRound.setRound(round);
            fixtureRound.setRound(newRound);
        }

        return fixtureRound;
    }

}
