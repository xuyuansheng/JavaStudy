package com.java.study.javastudy.jdk.concurrence;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁测试
 *
 * @author Mr.Xu
 * @date 2020/5/19 21:31
 */
public class LockTest {

    static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        lock.lock();
        Condition condition = lock.newCondition();
        Thread a = new Thread(() -> {
            try {
                lock.lockInterruptibly();
                System.out.println(Thread.currentThread().getName()+"interrupted");
            }catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        });
        a.start();
        Thread.sleep(1000);
        condition.await(2, TimeUnit.MILLISECONDS);
//        a.interrupt();
        System.out.println("over");

    }
}
