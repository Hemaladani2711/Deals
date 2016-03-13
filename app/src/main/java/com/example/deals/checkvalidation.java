package com.example.deals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Rangel on 3/12/2016.
 */
public class checkvalidation {



    public boolean isEmailValid(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public boolean isPasswordValid(String pass) {
        if (pass.length() > 0)
        {
            return true;
        }
        return false;
    }
}
