package com.java.study.javastudy.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateErrorTest {


    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        long nowHm = now.getTime();
        System.out.println("现在的毫秒 ： "+nowHm);
        System.out.println("现在的时间： "+sdf.format(now));
        long _30dayAgo = nowHm - (1000*60*60*24*30L);
        System.out.println("30天的毫秒"+1000*60*60*24*30L);
        System.out.println("现在的毫秒 ： "+_30dayAgo);
        Date _30dayAgoDate = new Date(_30dayAgo);
        System.out.println("30天前的毫秒 ： "+_30dayAgo);
        System.out.println("30天前的时间 ： "+sdf.format(_30dayAgoDate));

    }
}
