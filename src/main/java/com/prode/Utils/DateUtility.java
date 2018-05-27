package com.prode.Utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {

    public static Timestamp stringToTimestamp(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date parsed = format.parse(date);
        return new java.sql.Timestamp(parsed.getTime());
    }
}
