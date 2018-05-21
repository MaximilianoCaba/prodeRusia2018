package com.prode.service;

import com.prode.entity.User;
import com.prode.response.myRound.FixtureRound;
import com.prode.response.home.Result;

public interface ResultService {

    Result getResultRound();

    FixtureRound getFixture(User user);

}
