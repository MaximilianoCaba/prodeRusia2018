package com.prode.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomError implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value=PATH, method= RequestMethod.GET)
    public String errorGeneral() {
        return "site.error";
    }

    @RequestMapping(value = "/403", method= RequestMethod.GET)
    public String error403() {
        return "site.403";
    }

    @RequestMapping(value = "/404", method= RequestMethod.GET)
    public String error404() {
        return "site.404";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

}