package com.prode.controller.rest;


import com.prode.entity.User;
import com.prode.request.PronosticResult;
import com.prode.service.UserMatchService;
import com.prode.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMatchService userMatchService;

    @RequestMapping(value = "/fixture", method = RequestMethod.POST)
    @ApiOperation(consumes = "application/json", value = "cargar fixture de un usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveFixture(@RequestBody List<PronosticResult> pronosticResultList, Authentication authentication) {
        return userMatchService.savePronosticResult(pronosticResultList, userService.getUserWhitSession(authentication));
    }

    @RequestMapping(value ="/user", method = RequestMethod.GET)
    @ApiOperation(consumes = "application/json", value = "Obtener usuario Logueado")
    public Object getUser(Authentication authentication) {
        return userService.getUserWhitSession(authentication);
    }

}
