package com.ftest.myMath;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 没想好写啥
 */
public class Test2 {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        int today = cal.get(Calendar.DAY_OF_WEEK);
        Date sundayDate=null;
        if (today==Calendar.SUNDAY){

        }
        String weekEnd = sdf.format(sundayDate);
        System.out.println("所在周星期六的日期：" + weekEnd);
    }
}
