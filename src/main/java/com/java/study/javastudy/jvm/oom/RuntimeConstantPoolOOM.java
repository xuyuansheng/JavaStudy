package com.java.study.javastudy.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池内存溢出，导致OOM
 * 1.7 及以下 VM Args :  -XX:PermSize=10M   -XX:MaxPermSize=10M
 * 1.8  VM Args : -XX:MetaspaceSize=1M -XX:MaxMetaspaceSize=1M
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        //使用list保持着常量池的引用，避免Full GC 回收常量池
        List<String> list = new ArrayList<>();
        //10MB 的permSize在Integer范围内足够产生OOM
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
            System.out.println(i);
        }

    }

}
