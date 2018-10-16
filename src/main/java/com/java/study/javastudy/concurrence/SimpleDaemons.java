package com.java.study.javastudy.concurrence;

import java.util.concurrent.TimeUnit;

/**
 * 后台线程:指在程序运行的时候在后台提供一种通用服务的线程，并且这种线程
 */
public class SimpleDaemons implements Runnable{
    @Override
    public void run() {
        while (true){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread()+""+this);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
                e.printStackTrace();
            }
        }
    }


}
