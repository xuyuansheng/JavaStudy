package com.java.study.javastudy.concurrence;

/**
 * 线程优先级
 */
public class SimplePriorities implements Runnable {

    private int countDowm = 5;//线程输出的次数
    private volatile double d; //No Optimization 没有优化
    private int priority; // 优先

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ":" + countDowm;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        for (int i = 1; i < 100000; i++) {
            //执行了10000次开销较大的浮点运算，volatile 以尽可能地保证不做编译优化，如果不做这些操作，很难看出优先级的效果
            d += (Math.PI + Math.E)/(double)i;
            if(i%1000==0){
                Thread.yield();
            }
            System.out.println(this);
            if(--countDowm==0){
                return;
            }
        }
    }
}
