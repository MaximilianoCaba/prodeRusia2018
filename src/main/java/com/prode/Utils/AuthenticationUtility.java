package com.prode.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthenticationUtility {

    public static String getPictureGoogleAuth(Authentication authentication) {
        String pattern = "(\"|\')picture(\"|\'):(\"|\')(.*?)((\"|\'),(\"|\')email(\"|\'))";
        return getStringByPatter(authentication,pattern);
    }

    public static String getEmailGoogleAuth(Authentication authentication) {
        String pattern = "(\"|\')email(\"|\'):(\"|\')(.*?)((\"|\'),(\"|\')email_verified(\"|\'))";
        return getStringByPatter(authentication,pattern);
    }


    public static String getFullNameGoogleAuth(Authentication authentication){
        String pattern =  "(\"|\')name(\"|\'):(\"|\')(.*?)((\"|\'),(\"|\')given_name(\"|\'))";
        return getStringByPatter(authentication,pattern);
    }

    private static String getStringByPatter(Authentication authentication, String pattern){
        ObjectMapper mapper = new ObjectMapper();
        try {
            String string = mapper.writeValueAsString(authentication);
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(string);
            if (m.find()) {

                if (!m.group(4).isEmpty())
                    return m.group(4);
                else
                    return "";
            } else {
                return "";
            }
        } catch (JsonProcessingException e) {
            return "";
        }


    }

}

