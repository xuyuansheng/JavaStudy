package com.java.study.javastudy.concurrence;

/**
 * 通过使用内部类将线程代码隐藏在类中
 */
public class ThreadVariations {



}
class InnerThread1{
    private int countDown=5;
    private Inner inner;
    private class Inner extends Thread{
        public Inner(String name) {
            super(name);
            start();
        }
        public void run() {
                    try {
                        while (true) {
                            System.out.println(this);
                            if (--countDown == 0) {
                               return;
                            }
                            sleep(10);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
        }

        @Override
        public String toString() {
            return getName()+":"+countDown;
        }
    }
    public InnerThread1(String name){
        inner = new Inner(name);
    }
}

class InnerThread2{
    private int countDown=5;
    private Thread t;

    public InnerThread2(String name) {
        t = new Thread(name){
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) {
                            return;
                        }
                        sleep(10);
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            public String toString() {
                return getName()+":"+countDown;
            }
        };
        t.start();
    }
}