package com.prode.controller.rest;


import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ResultController {

    @RequestMapping(value ="/api/saveMyRound", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String create(HttpServletRequest request, Authentication authentication){
        return "Ok";
    }


}
