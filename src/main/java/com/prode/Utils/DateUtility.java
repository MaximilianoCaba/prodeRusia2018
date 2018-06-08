package com.prode.Utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtility {

    public static Timestamp stringToTimestamp(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date parsed = format.parse(date);
        return new java.sql.Timestamp(parsed.getTime());
    }

    //resta dos timestamp y da un numero en segundos, si el resultado es menor a 3600
    // significa que falta menos de 1 hora entre esas dos fechas
    public static boolean ifLessThanAnHourDiference(Date date){

        //si surge problemas cambiar el GTM por el local para transformar por ejemplo GTM-3 = arg
        TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"));
        System.out.println(new Date());
        Timestamp timestamp3 = new Timestamp(date.getTime());
        Timestamp timestampNow = new Timestamp(new Date().getTime());
        long miliseconds = timestamp3.getTime() - timestampNow.getTime();

        if(miliseconds < 3610000)
            return true;
        else
            return false;

    }
}
