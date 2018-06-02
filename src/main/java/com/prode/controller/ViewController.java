package com.prode.controller;


import com.prode.entity.User;
import com.prode.service.ResultService;
import com.prode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @Autowired
    private UserService userService;

    @Autowired
    private ResultService resultService;

    @RequestMapping(value = "/")
    public String home(Authentication authentication, Model model) throws Exception {
        model.addAttribute("user", userService.getUserWhitSession(authentication));
        model.addAttribute("results", resultService.getResultRound());
        return "site.home";
    }

    @RequestMapping(value = "/myRound")
    public String myRound(Authentication authentication, Model model) throws Exception {
        User user = userService.getUserWhitSession(authentication);
        model.addAttribute("user", user);
        model.addAttribute("results", resultService.getFixture(user));
        return "site.myRound";
    }

    @RequestMapping(value = "/rules")
    public String rules(Authentication authentication, Model model) throws Exception {
        model.addAttribute("user", userService.getUserWhitSession(authentication));
        return "site.rules";
    }
}
