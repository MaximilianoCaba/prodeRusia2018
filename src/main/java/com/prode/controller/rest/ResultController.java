package com.prode.controller.rest;


import com.prode.request.UserFixtureRound;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ResultController {

    @RequestMapping(value = "/api/fixture", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String create(UserFixtureRound userFixtureRound, Authentication authentication) {
        System.out.println(userFixtureRound);

        return "Ok";
    }


}
