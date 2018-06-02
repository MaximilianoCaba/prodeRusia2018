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

import java.util.List;

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
            try {
                matchRepository.save(match);
            } catch (Exception e) {
                throw new Exception("no se a podido guardar el resultado en la db");
            }
        } else
            throw new Exception("el partido que desea ingresar ya esta en la db");
    }

    @Override
    public List<Match> findAllByRound(Integer round) {
        return matchRepository.findAllByRound(round);
    }


    @Override
    public void updateMatch(Long matchId, TeamEnum teamHomeRequest, TeamEnum teamAwayRequest, Integer goalHome, Integer goalAway, Integer goalPenaltyHome, Integer goalPenaltyAway) throws Exception {
        Team teamHome = teamRepository.findOne(teamHomeRequest.getSqlId());
        Team teamAway = teamRepository.findOne(teamAwayRequest.getSqlId());

        Match match = matchRepository.findOne(matchId);

        if (match == null)
            throw new Exception("El match id es incorrecto");

        if (match.getTeamHome().getId().equals(teamHome.getId()) && match.getTeamAway().getId().equals(teamAway.getId())) {

            boolean validgoalHome = goalHome != null && goalHome > 0;
            boolean validgoalAway = goalAway != null && goalAway > 0;

            if(validgoalHome && validgoalAway){
                match.setGoalHome(goalHome);
                match.setGoalAway(goalAway);

                boolean isDrawMatch = goalHome.equals(goalAway);
                boolean validgoalPenaltyHome = goalPenaltyHome != null && goalPenaltyHome > 0;
                boolean validgoalPenaltyAway = goalPenaltyAway != null && goalPenaltyAway > 0;

                if(isDrawMatch && validgoalPenaltyAway && validgoalPenaltyHome){
                    match.setPenaltyGoalAway(goalPenaltyAway);
                    match.setPenaltyGoalHome(goalPenaltyHome);
                }

                match.setMatchState(matchStateRepository.getOne(3L));

                try {
                    matchRepository.save(match);
                } catch (Exception e) {
                    throw new Exception("no se a podido guardar el resultado en la db");
                }
            }else{
                throw new Exception("los goles e y visitante no son validos");

            }


        }
    }
}
