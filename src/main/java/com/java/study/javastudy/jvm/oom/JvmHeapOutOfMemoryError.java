package com.java.study.javastudy.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * java堆内存溢出异常测试
 * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author xu
 */
public class JvmHeapOutOfMemoryError {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        while (true){
            list.add(new MyObject());
        }
    }

    static class MyObject{

    }

}