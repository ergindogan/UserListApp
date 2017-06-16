package com.example.ergindoganyildiz.userlistapp;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by ergindoganyildiz on 6/15/17.
 */

public class DateUtil {

    public static Date formatDate(String dateString){
        //1983-07-14 07:29:45
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat(pattern);

        try {
            Date date = format.parse(dateString);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
