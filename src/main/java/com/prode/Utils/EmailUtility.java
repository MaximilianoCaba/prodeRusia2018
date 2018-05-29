package com.prode.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailUtility {

    private final static String EMAIL_COMPANY_DOMAIN_PATTERN = "^[a-zA-Z0-9_.+-]+@(?:(?:[a-zA-Z0-9-]+\\.)?[a-zA-Z]+\\.)?(snoopconsulting)\\.?(com|com.ar)$";

    public static boolean emailIsCompanyDomain(String email) {

        try {
            Pattern r = Pattern.compile(EMAIL_COMPANY_DOMAIN_PATTERN);
            Matcher m = r.matcher(email);
            if (m.find()) {
                if (!m.group(1).isEmpty())
                    return true;
                else
                    return false;
            } else
                return false;
        } catch (Exception e) {
            return false;
        }
    }
}
