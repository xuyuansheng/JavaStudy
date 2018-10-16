package com.java.study.javastudy.concurrence;

/**
 * 多线程练习1
 */
public class ExerciseJava implements Runnable{

    private static  int taskCount=0;
    private final int id=taskCount++;

    public ExerciseJava() {
        System.out.println("初始化线程 "+id);
    }

    @Override
    public void run() {
        System.out.println("线程 "+id+" 第一次打印消息！");
        Thread.yield();
        System.out.println("线程 "+id+" 第二次打印消息！");
        Thread.yield();
        System.out.println("线程 "+id+" 第三次打印消息！");
        Thread.yield();
        System.out.println("线程 "+id+"消息打印结束");
    }
}
