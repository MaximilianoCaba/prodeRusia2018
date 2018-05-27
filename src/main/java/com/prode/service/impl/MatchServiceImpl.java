package com.prode.service.impl;

import com.prode.Utils.DateUtility;
import com.prode.entity.Match;
import com.prode.entity.Team;
import com.prode.enums.TeamEnum;
import com.prode.repository.MatchRepository;
import com.prode.repository.MatchStateRepository;
import com.prode.repository.TeamRepository;
import com.prode.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchStateRepository matchStateRepository;


    @Override
    public void saveMatch(Integer round, TeamEnum teamHomeRequest, TeamEnum teamAwayRequest, String date) throws Exception {

        if (teamHomeRequest.equals(teamAwayRequest))
            throw new Exception("los equipos ingreados son iguales");

        Team teamHome = teamRepository.findOne(teamHomeRequest.getSqlId());
        Team teamAway = teamRepository.findOne(teamAwayRequest.getSqlId());

        Match match = matchRepository.findByRoundAndTeamHomeAndTeamAway(round, teamHome, teamAway);

        if (match == null) {
            match = new Match();
            match.setRound(round);
            match.setTeamHome(teamHome);
            match.setTeamAway(teamAway);
            match.setDate(DateUtility.stringToTimestamp(date));
            match.setMatchState(matchStateRepository.findOne(1L));
            try{
                matchRepository.save(match);
            }catch (Exception e){
                throw new Exception("no se a podido guardar el resultado en la db");
            }
        } else
            throw new Exception("el partido que desea ingresar ya esta en la db");
    }
}
