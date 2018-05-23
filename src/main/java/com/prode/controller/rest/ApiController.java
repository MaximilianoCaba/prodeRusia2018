package com.prode.controller.rest;


import com.prode.request.UserFixtureRound;
import com.prode.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/fixture", method = RequestMethod.POST, consumes = "application/json")
    @ApiOperation(consumes = "application/json", value = "cargar fixture de un usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveFixture(@RequestBody UserFixtureRound userFixtureRound) {
        System.out.println(userFixtureRound);
        return "Ok";
    }

    @RequestMapping(value ="/user", method = RequestMethod.GET)
    @ApiOperation(consumes = "application/json", value = "Obtener usuario Logueado")
    public Object getUser(Authentication authentication) {
        return userService.getUserWhitSession(authentication);
    }

}
