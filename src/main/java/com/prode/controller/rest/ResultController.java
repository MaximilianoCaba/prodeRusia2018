package com.prode.controller.rest;


import com.prode.request.UserFixtureRound;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResultController {


    /**
     * @param userFixtureRound
     * @param authentication
     * @return {
     * "round": 1,
     * "pronosticResults": [
     * {
     * "matchId": 1,
     * "userId": 1,
     * "goalHome":1,
     * "goalAway": 1,
     * "goalPenaltyHome": 1,
     * "goalPenaltyAway": 1
     * }
     * ]
     * }
     */


    @RequestMapping(value = "/api/fixture", method = RequestMethod.POST, consumes = "application/json")
    @ApiOperation(consumes = "application/json", value = "Método para persistir el webhook", notes = "Método para persistir el webhook")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody UserFixtureRound userFixtureRound, Authentication authentication) {
        System.out.println(userFixtureRound);

        return "Ok";
    }


}
