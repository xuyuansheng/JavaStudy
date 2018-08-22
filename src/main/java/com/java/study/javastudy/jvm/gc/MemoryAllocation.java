package com.java.study.javastudy.jvm.gc;

/**
 * 测试内存分配
 * VM Args: -Xms20M -Xmx20M  -Xmn10M -XX:SurvivorRatio=8  -XX:+PrintGCDetails
 * VM Args: -Xms20M 最小堆内存 -Xmx20M 最大堆内存  -Xmn10M 新生代  -XX:SurvivorRatio=8 新生代老年代比例
 * -XX:+PrintGCDetails gc日志输出
 */
public class MemoryAllocation {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        System.out.println("开始");
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];//出现一次minor gc
        System.out.println();

    }

}
