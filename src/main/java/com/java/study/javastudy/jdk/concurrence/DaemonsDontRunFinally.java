package com.java.study.javastudy.jdk.concurrence;

import java.util.concurrent.TimeUnit;

/**
 * 后台线程不会执行finally块
 */
public class DaemonsDontRunFinally {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ADaemon());
        thread.setDaemon(true);
        thread.start();
        TimeUnit.MILLISECONDS.sleep(100);
    }
}


class ADaemon implements Runnable{

    @Override
    public void run() {
        System.out.println("开始 ADaemon");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("这是必须要执行的？");
        }
    }
}