package com.java.study.javastudy.concurrence;

import java.util.concurrent.TimeUnit;

/**
 * 一个后台线程创建的任何线程都将被自动设置为后台线程
 */

public class Daemons{
    public static void main(String[] args) {
        Thread t = new Thread(new Daemon());
        t.setDaemon(true);
        t.start();
        try {
            TimeUnit.MICROSECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

 class Daemon implements Runnable{

    private Thread[] t = new Thread[10];

    @Override
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn "+i+" 已经启动.");
        }
        for (int i = 0; i < t.length; i++) {
            System.out.println("t["+i+"].isDaemon() = "+t[i].isDaemon()+",");
        }
        while (true){
            Thread.yield();
        }
    }
}
class DaemonSpawn implements Runnable{

    @Override
    public void run() {
        while (true)
            Thread.yield();
    }
}

