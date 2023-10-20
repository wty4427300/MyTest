package com.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author wangqinghe 日期工具类
 */
@Slf4j
public class DateUtil {


    /**
     * 年-月-日 时:分:秒:毫秒 最全版
     */
    public final static String DEFAULT_PATTERN_DATETIME_FULL = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 年-月-日 时:分:秒:毫秒 中文版
     */
    public final static String DEFAULT_PATTERN_DATETIME_FULL_CHINESE = "yyyy年MM月dd日 HH:mm:ss.SSS";

    /**
     * 年-月-日 时:分:秒:毫秒 中文版全
     */
    public final static String DEFAULT_PATTERN_DATETIME_CHINESE_FULL = "yyyy年MM月dd日 HH时mm分ss秒SSS毫秒";

    /**
     * 年-月-日 时:分:秒 标准样式
     */
    public final static String DEFAULT_PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";

    /**
     * 年-月-日 时:分 中文版1
     */
    public final static String DEFAULT_PATTERN_DATETIME_CHINESE_ONE = "yyyy年MM月dd日 HH:mm";

    /**
     * 年-月-日 时:分:秒 中文版2
     */
    public final static String DEFAULT_PATTERN_DATETIME_CHINESE_TWO = "yyyy年MM月dd日 HH时mm分ss秒";

    /**
     * 年-月-日
     */
    public final static String DEFAULT_PATTERN_DATE = "yyyy-MM-dd";

    /**
     * 年-月-日 中文版
     */
    public final static String DEFAULT_PATTERN_DATE_CHINESE = "yyyy年MM月dd日";

    /**
     * 年
     */
    public final static String DEFAULT_PATTERN_DATE_YEAR = "yyyy";

    /**
     * 月-日
     */
    public final static String DEFAULT_PATTERN_MONTH = "MM-dd";

    /**
     * 日
     */
    public final static String DEFAULT_PATTERN_DAY = "dd";

    /**
     * 时:分:秒
     */
    public final static String DEFAULT_PATTERN_TIME = "HH:mm:ss";

    /**
     * 年月日时分
     */
    public final static String DEFAULT_PATTERN_DATETIME_SIMPLE_FULL = "yyyy-MM-dd HH:mm";

    /**
     * 年月日时分秒
     */
    public final static String DEFAULT_PATTERN_DATETIME_SIMPLE = "yyyyMMddHHmmss";

    /**
     * 年月日
     */
    public final static String DEFAULT_PATTERN_DATETIME_DATE = "yyyyMMdd";

    /**
     * 月日
     */
    public final static String DEFAULT_PATTERN_YEAR_MONTH = "yyyy-MM";

    /**
     * 时分
     */
    public final static String DEFAULT_PATTERN_DATETIME_TIME_FULL = "HH:mm";


    public static String getStringDateYYYYMMdd(Date date) {
        if (date == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN_DATETIME_DATE);
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return localDateTime.format(formatter);
    }


    public static String getStringDate(Date date) {
        if (date == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN_DATE);
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return localDateTime.format(formatter);
    }

    public static String getStringDateTime(Date date) {
        if (date == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN_DATETIME);
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().format(formatter);
    }

    public static String getStringDateHHSS(Date date) {
        if (date == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN_DATETIME_TIME_FULL);
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().format(formatter);
    }

    public static String getStringDateHHSSMM(Date date) {
        if (date == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN_TIME);
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().format(formatter);
    }

    public static String getDateTimeFormat(Date date, String formatStr) {
        if (date == null) {
            return null;
        }
        DateFormat format = new SimpleDateFormat(formatStr);
        return format.format(date);
    }

    public static Date getDateYYYYMMdd(String dateStr) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN_DATETIME_DATE);
        LocalDate localDate = LocalDate.parse(dateStr, formatter);
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date getYearMonthDayDate(Date date) {
        if (date == null) {
            return null;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN_DATE);
            String format = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().format(formatter);
            LocalDate localDate = LocalDate.parse(format, formatter);
            return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date getReportDateFormat(Date date) {
        if (date == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN_DATE);
        String format = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().format(formatter);
        LocalDate localDate = LocalDate.parse(format, formatter);
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * date2比date1多的天数
     */
    public static int differentDays(Date date1, Date date2) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();

        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();

        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    public static int differentYears(Date date1, Date date2) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        int year1 = cal.get(Calendar.YEAR);

        cal.setTime(date2);
        int year2 = cal.get(Calendar.YEAR);

        return (year2 - year1);
    }

    /**
     * 根据日期获取星期几
     */
    public static Integer getWeekDay(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK) - 1 == 0 ? 7 : calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }

    public static Date getDateByString(String dateStr, String format) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        try {
            Date date = null;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

            switch (format) {
                case DEFAULT_PATTERN_DATE:
                    LocalDate localDate = LocalDate.parse(dateStr, formatter);
                    date = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
                    break;
                case DEFAULT_PATTERN_DATETIME:
                case DEFAULT_PATTERN_DATETIME_SIMPLE_FULL:
                    LocalDateTime localDateTime = LocalDateTime.parse(dateStr, formatter);
                    date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
                    break;
                default:
                    break;
            }
            return date;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("getDateByString dateStr:{} format:{} error:{}", dateStr, format, e);
            return null;
        }
    }

    public static Date getDateTimeByString(String dateStr) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        try {
            //"yyyy-MM-dd HH:mm:ss"格式必须如此
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN_DATETIME);
            LocalDateTime localDateTime = LocalDateTime.parse(dateStr, formatter);
            return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        } catch (Exception e) {
            log.error("getDateTimeByString dateStr:{} error:{}", dateStr, e);
            return null;
        }
    }

    public static Date getDateByString(String dateStr) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        try {
            //"yyyy-MM-dd"格式必须如此
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN_DATE);
            LocalDate localDate= LocalDate.parse(dateStr, formatter);
            return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        } catch (Exception e) {
            log.error("getDateTimeByString dateStr:{} error:{}", dateStr, e);
            return null;
        }
    }

    public static Date dateAddDays(Date date, int addDays) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, addDays); //把日期往后增加一天,整数  往后推,负数往前移动
        return calendar.getTime();
    }

    public static Date dateAddHours(Date date, int addHours) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, addHours);
        return calendar.getTime();
    }

    public static Date dateAddMinute(Date date, int addMinute) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, addMinute);
        return calendar.getTime();
    }


    /**
     * 评论时间跟当前时间比，7天内显示中文 N天内 其他显示 MM-dd
     */
    public static String discussShowDate(Date date) {

        Date nowDate = new Date();
        long diff = nowDate.getTime() - date.getTime();
        int minutes = (int) (diff / (1000 * 60));
        int hours = (int) (diff / (1000 * 60 * 60));
        int days = (int) (diff / (1000 * 60 * 60 * 24));
        //1. 刚刚 -10分钟内
        if (minutes <= 10) {
            return "刚刚";
        } else if (minutes > 10 && minutes < 60) {
            return minutes + "分钟前";
        }
        //2. 1-23小时前 or 昨天HH:mm
        if (hours <= 24 && days < 1) {
            return hours + "小时前";
        }
        if (days == 1) {
            return "昨天" + DateUtil.getDateTimeFormat(date, DEFAULT_PATTERN_DATETIME_TIME_FULL);
        }
        //3. 2-6天前
        if (days < 7) {
            return days + "天前";
        }
        //4. MM-DD ：一年内
        Calendar dateCal = Calendar.getInstance();
        dateCal.setTime(date);
        Calendar nowDateCal = Calendar.getInstance();
        nowDateCal.setTime(nowDate);
        int year1 = dateCal.get(Calendar.YEAR);
        int year2 = nowDateCal.get(Calendar.YEAR);
        if (year1 == year2) {
            return DateUtil.getDateTimeFormat(date, DEFAULT_PATTERN_DATETIME_TIME_FULL);
        }
        //5. 一年以上
        return DateUtil.getDateTimeFormat(date, DEFAULT_PATTERN_DATETIME_SIMPLE_FULL);
    }

    public static boolean sameDate(Date d1, Date d2) {
        if (null == d1 || null == d2) {
            return false;
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(d1);
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(d2);
        cal2.set(Calendar.HOUR_OF_DAY, 0);
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.SECOND, 0);
        cal2.set(Calendar.MILLISECOND, 0);
        return cal1.getTime().equals(cal2.getTime());
    }

    /**
     * 获取时间的 HOUR_OF_DAY 数值
     */
    public static int getHourByDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * date2比date1多多少小时
     */
    public static int differentHours(Date date1, Date date2) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();

        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();

        long between_hours = (time2 - time1) / (1000 * 60 * 60);
        return Integer.parseInt(String.valueOf(between_hours));
    }

    /**
     * 获取两个日期字符串之间的日期集合
     *
     * @param startDate:开始日期
     * @param endDate:结束日期
     * @return list:yyyy-MM-dd
     */
    public static List<Date> getBetweenDate(Date startDate, Date endDate) {
        // 声明保存日期集合
        List<Date> list = new ArrayList<>();

        //用Calendar 进行日期比较判断
        Calendar calendar = Calendar.getInstance();
        while (startDate.getTime() <= endDate.getTime()) {
            // 把日期添加到集合
            list.add(startDate);
            // 设置日期
            calendar.setTime(startDate);
            //把日期增加一天
            calendar.add(Calendar.DATE, 1);
            // 获取增加后的日期
            startDate = calendar.getTime();
        }
        return list;
    }


    public static void main(String[] args) {

        Calendar now = Calendar.getInstance();
        System.out.println(DateUtil.getStringDateTime(new Date()));
        now.add(Calendar.DATE, -30);
        System.out.println(DateUtil.getStringDateTime(now.getTime()));
    }
}
