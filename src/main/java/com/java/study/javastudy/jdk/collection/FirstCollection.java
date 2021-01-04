package com.java.study.javastudy.jdk.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 */
public class FirstCollection {
    @Test
    public void setcollection() {
        List list = new ArrayList();
        HashSet<String> set = new HashSet<>();
        set.add("f");
        set.add("f");
        set.add("a");
        set.add("a");
        set.add("b");
        set.add("b");
        set.add("d");
        set.add("d");
// 增强for循环
        for (String string : set) {
            System.out.println(string);

        }
    }

}
