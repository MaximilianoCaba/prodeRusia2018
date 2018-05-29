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

    //resta dos timestamp y da un numero en segundos, si el resultado es menor a 3600
    // significa que falta menos de 1 hora entre esas dos fechas
    public static boolean ifLessThanAnHourDiference(Date date){
        Timestamp timestamp3 = new Timestamp(date.getTime());
        Timestamp timestampNow = new Timestamp(new Date().getTime());
        long miliseconds = timestamp3.getTime() - timestampNow.getTime();

        if(miliseconds < 3600000)
            return true;
        else
            return false;

    }
}
