package com.java.study.javastudy.concurrence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 把LiftOff 复制过来，将任务中的yield（） 换为 sleep（）
 * 任务：LiftOff显示发射之前的倒计时
 */
public class SleepingTask implements  Runnable {

    protected  int countDown=10;
    private static  int taskCount=0;
    private final int id=taskCount++;
    private static  int nextLine=1;

    public SleepingTask() {
    }

    public SleepingTask(int countDown) {
        this.countDown = countDown;
    }

    public String status(){
        nextLine++;
        return "#"+id+"("+(countDown>0?countDown:"LiftOff!")+").\t";
    }

    @Override
    public void run() {
        while (countDown-->0){
            if(nextLine%10==0){
                System.out.println(status());
            }else{
                System.out.print(status());
            }
            try {
                //老的写法
                //Thread.sleep(100);
                //java se 5/6 写法
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
