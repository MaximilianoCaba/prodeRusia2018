package com.prode.service;

import com.prode.entity.User;
import org.springframework.security.core.Authentication;

public interface UserService {

    User getPersonById(Long id);

    User getPersonByMail(String mail);

    User getUserWhitSession(Authentication authentication);

}

