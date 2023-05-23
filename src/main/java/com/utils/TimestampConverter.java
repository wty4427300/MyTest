package com.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampConverter {
    public static long getTimestamp(String dateString, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        try {
            Date date = dateFormat.parse(dateString);
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void main(String[] args) {
        String dateString = "2023-05-17 15:59:57";
        String format = "yyyy-MM-dd HH:mm:ss";
        long timestamp = getTimestamp(dateString, format);
        System.out.println("Timestamp: " + timestamp);
    }
}

