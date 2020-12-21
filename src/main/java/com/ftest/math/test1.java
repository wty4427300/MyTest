package com.ftest.math;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class test1 {
    public static void main(String[] args) {
//        int i=1<<2;
//        System.out.println(i);
//        int b=1>>2;
//        System.out.println(b);
//        Calendar calendar=new GregorianCalendar();
//        calendar.setTime(new Date());
//        System.out.println(calendar.getTime());
//        int week = calendar.get(Calendar.DAY_OF_WEEK);
//        System.out.println(week);
//        Date nowDate = new Date();
//        int hour = getHourByDate(nowDate);
//        System.out.println(hour);
//        int firstDayOfWeek = calendar.getFirstDayOfWeek();
//        System.out.println(firstDayOfWeek);
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("source")
//                .append("=")
//                .append("15822379950");
//        String scene = stringBuilder.toString();
//        System.out.println(scene);
        int[] city={157,159,160,162,164,165,166,167};
        for (int id:city){
            StringBuilder stringBuilder=new StringBuilder();
            stringBuilder.append("(now(),now(),56,")
                    .append(id)
                    .append(",18100,19900,14,2200)")
                    .append(",");
            System.out.println(stringBuilder.toString());
        }
        System.out.println(city.length);
    }

    /**
     * 获取时间的 HOUR_OF_DAY 数值
     * */
    public static int getHourByDate(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour=cal.get(Calendar.HOUR_OF_DAY);
        return hour;



    }
}
