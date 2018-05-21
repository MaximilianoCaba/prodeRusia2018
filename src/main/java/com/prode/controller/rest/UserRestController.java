package com.prode.controller.rest;

import com.prode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserRestController {

    @Autowired
    UserService userService;

    @RequestMapping("/api/user")
	public Object getUser(Authentication authentication) {
		return userService.getUserWhitSession(authentication);
	}

}
