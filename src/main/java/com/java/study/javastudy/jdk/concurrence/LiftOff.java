package com.java.study.javastudy.jdk.concurrence;

/**
 * 需要用多线程执行的任务，没有返回值，是独立的任务
 * 任务：LiftOff显示发射之前的倒计时
 */
public class LiftOff  implements  Runnable {

    protected  int countDown=10;
    private static  int taskCount=0;
    private final int id=taskCount++;
    private static int nextLine=1;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
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
            Thread.yield();
        }
    }
}
