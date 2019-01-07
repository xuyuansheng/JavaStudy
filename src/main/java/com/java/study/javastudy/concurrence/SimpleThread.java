package com.java.study.javastudy.concurrence;

/**
 * 编码变体：简单的任务可以用继承的方式来实现
 */
public class SimpleThread extends Thread{

    private int countDowm = 5;
    private static int threadCount=0;

    public SimpleThread() {
        super(Integer.toString(++threadCount));

        start();//实例化时自动启动thread
    }

    public String toString(){
        return "#" + getName() + "(" + countDowm + ").";
    }

    @Override
    public void run() {
        while (true)
        {
            System.out.println(this);
            if(--countDowm==0){
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SimpleThread();

        }
    }
}
