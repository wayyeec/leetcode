package com.cwy.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author: wayyee
 * @Date: 2020/6/20 19:55
 * Describe: 时间工具
 */
public class TimeUtil {

    /**
     * 格式化日期
     * 使用线程安全的DateTimeFormatter
     * @return “年-月-日”字符串
     */
    public static String getFormatDateForThree(){

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return now.format(format);
    }

    /**
     * 格式化日期
     * 使用线程安全的DateTimeFormatter
     * @return “年-月-日 时:分:秒”字符串
     */
    public static String getFormatDateForSix(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(format);
    }

    /**
     * 格式化日期
     * 使用线程安全的DateTimeFormatter
     * @return “年-月-日 时:分”字符串
     */
    public static String getFormatDateForFive(){

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return now.format(format);
    }

    /**
     * 解析日期
     * @param date 日期 2020-06-21
     * @return
     */
    public static LocalDate getParseDateForThree(String date){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, format);
    }

    /**
     * 解析日期
     * @param date 日期 2020-06-21 12:01:25
     * @return
     */
    public static LocalDate getParseDateForSix(String date){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDate.parse(date, format);
    }

    /**
     * 获得当前时间的时间戳
     * @return 时间戳
     */
    public static long getLongTime(){
        Date now = new Date();
        return now.getTime()/1000;
    }

    /**
     * 时间中横杆转换为年
     * @param str 2020-08
     * @return 2020年8月
     */
    public static String timeWhippletreeToYear(String str){
        StringBuilder s = new StringBuilder();
        s.append(str.substring(0,4));
        s.append("年");
        s.append(str.substring(5,7));
        s.append("月");
        return String.valueOf(s);
    }

    /**
     * 时间中的年转换为横杠
     * @param str 2020年07月
     * @return 2020-07
     */
    public static String timeYearToWhippletree(String str){
        StringBuilder s = new StringBuilder();
        s.append(str.substring(0,4));
        s.append("-");
        s.append(str.substring(5,7));
        return String.valueOf(s);
    }
}
