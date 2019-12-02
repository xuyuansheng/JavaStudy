package com.java.study.javastudy.leetcode.arrays;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @program: java-study
 * @description:
 * @author: Mr.Xu
 * @create: 2019/11/29 16:55
 */
public class ArraysClass {

    public static void main(String[] args) {


        LocalDate now = LocalDate.now();
        LocalDate start = now;
        for (int i = -3; i < 10; i++) {
            LocalDate max = now.plusDays(i);
            getList(start, max);
        }
    }


    public static void getList(LocalDate start, LocalDate max) {

        ArrayList<Object> list = new ArrayList<>();

        LocalDate after = start.plusDays(4);
        LocalDate end = after.isAfter(max) ? max : after;
        while (!start.isAfter(end)) {

            LocalDate ts = start;
            while (!ts.isAfter(end)) {
                list.add(ts);
                ts = ts.plusDays(1);
            }

            start = end.plusDays(1);
            after = start.plusDays(4);
            end = after.isAfter(max) ? max : after;

        }
        System.out.println(list.size() + "|" + list);
    }
    public static void getList1(LocalDate start, LocalDate max) {

        ArrayList<Object> list = new ArrayList<>();

        LocalDate after = start.plusDays(4);
        LocalDate end = after.isAfter(max) ? max.plusDays(1) : after;
        while (start.isBefore(end)) {

            LocalDate ts = start;
            while (!ts.isAfter(end)) {
                list.add(ts);
                ts = ts.plusDays(1);
            }

            start = end.plusDays(1);
            after = start.plusDays(4);
            end = after.isAfter(max) ? max.plusDays(1) : after;

        }
        System.out.println(list.size() + "|" + list);
    }
}
