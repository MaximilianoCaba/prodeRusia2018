package com.prode.service;

import com.prode.enums.TeamEnum;

import java.util.Date;

public interface MatchService {

    public void saveMatch(Integer round, TeamEnum teamHome, TeamEnum teamAway, String date) throws Exception;
}
