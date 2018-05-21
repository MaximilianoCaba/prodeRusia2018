package com.prode.service.impl;

import com.prode.Utils.AuthenticationUtility;
import com.prode.Utils.EmailUtility;
import com.prode.entity.User;
import com.prode.repository.UserRepository;
import com.prode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getPersonById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User getPersonByMail(String mail) {
        return userRepository.findByMail(mail);
    }

    @Override
    public User getUserWhitSession(Authentication authentication) {

        String email = AuthenticationUtility.getEmailGoogleAuth(authentication);

        if (!email.isEmpty() && EmailUtility.emailIsCompanyDomain(email)) {
            User user = userRepository.findByMail(email);
            if (user == null) {
                String name = AuthenticationUtility.getFullNameGoogleAuth(authentication);
                String picture = AuthenticationUtility.getPictureGoogleAuth(authentication);

                User userSave = new User();
                userSave.setMail(email);
                userSave.setAvatar(picture);
                userSave.setName(name);
                return userRepository.save(userSave);

            }else
                return user;
        } else
            return null;

    }


}
