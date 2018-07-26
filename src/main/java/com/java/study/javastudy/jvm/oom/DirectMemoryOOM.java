package com.java.study.javastudy.jvm.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 直接内存溢出
 * VM Args： -Xmx20m -XX:MaxDirectMemorySize=10
 */
public class DirectMemoryOOM {

    public static void main(String[] args) throws Exception {
        System.out.println("开始");
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(1024 * 1024L);
        }
    }
}
