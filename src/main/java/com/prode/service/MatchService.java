package com.prode.service;

import com.prode.entity.Match;
import com.prode.enums.TeamEnum;

import java.util.List;

public interface MatchService {

    public void saveMatch(Integer round, TeamEnum teamHome, TeamEnum teamAway, String date) throws Exception;

    public List<Match> findAllByRound(Integer round);

    public void updateMatch(Long matchId, TeamEnum teamHome, TeamEnum teamAway, Integer goalHome, Integer goalAway, Integer goalPenaltyHome, Integer goalPenaltyAway) throws Exception;

}
