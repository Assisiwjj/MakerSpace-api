package com.makerspace.demo.utils;

import java.util.Calendar;

public class TimeUtil {

    //获取时间  返回毫秒级时间
    public static String getTime() {
        //System.out.println("getTime...util...");

        Calendar calendar = Calendar.getInstance();
        //获取毫秒时间
        Long date = calendar.getTime().getTime() + 5*60*1000;

        return date.toString();
    }

    //比较时间
    public static boolean cmpTime(String time) {
        //System.out.println("cmpTime...util...");
        long tempTime = Long.parseLong(time);
        System.out.println("tempTime"+tempTime);

        //在获取现在的时间
        Calendar calendar = Calendar.getInstance();
        //获取毫秒时间
        Long date = calendar.getTime().getTime();
        System.out.println("date"+date);

        //15分钟
        if(date< tempTime  ) {
            return true;
        } else {
            return false;
        }

    }
}
