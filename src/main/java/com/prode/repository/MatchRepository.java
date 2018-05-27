package com.prode.repository;

import com.prode.entity.Match;
import com.prode.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {

    public List<Match> findAllByRound(Integer round);

    public Match findByRoundAndTeamHomeAndTeamAway(Integer round, Team teamHome, Team teamAway);

}
