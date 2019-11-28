package com.wildcoding.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private final static DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static Date toDate(String dateString) {
        try {
            if (dateString == null) {
                return new Date();
            }
            return DATE_FORMAT.parse(dateString);
        } catch (ParseException e) {
            return new Date();
        }
    }
}
