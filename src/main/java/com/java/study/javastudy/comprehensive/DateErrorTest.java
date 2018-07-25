package com.java.study.javastudy.comprehensive;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *   减去毫秒数的时候要转化为Long （(1000*60*60*24*30L)），不然回int  超长  即使是long 也可能会出现超长的情况 所以此方式谨慎使用
 */
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
