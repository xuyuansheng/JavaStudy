package com.java.study.javastudy.concurrence;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * java并发编程,不能用junit测试
 */
public class JavaConcurrence {

    @Test
    public void concurrence() {
        LiftOff lunch = new LiftOff();
        lunch.run();
    }

    @Test
    public void basicThreads() {
        Thread thread = new Thread(new LiftOff());
        thread.start();
        System.out.println("Waiting for LiftOff!");
    }
    //
    @Test
    public void moreBasicThreads() {
        for (int i = 0; i < 5; i++) {
            new Thread(new ExerciseJava()).start();
            System.out.println("Waiting for LiftOff! " + i);
        }

    }
    //线程池
    @Test
    public void cachedThreadPool() {
        ExecutorService exec = Executors.newCachedThreadPool();
        ExecutorService exec2 = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
    //定长的线程池
    @Test
    public void fixedThreadPool() {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
    //单线程的线程池
    @Test
    public void singleThreadPool() {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
    //定时线程池
    @Test
    public void scheduledThreadPool() {
        ExecutorService exec = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
    //带返回值的线程
    public void callableThread() {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();

        for (int i = 0; i < 10; i++) {
            Future<String> result = exec.submit(new TaskWithResult(i));
            results.add(result);
        }
        try {
            // 给所有任务1000毫秒时间执行，然后去拿执行完成的结果
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Future<String> fs : results
                ) {
            try {
                if (fs.isDone()) {
                    System.out.println(fs.get());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }
        }
    }
    //Fibonacci数列
    public void fibonacci() {
        for (int i = 0; i < 10; i++) {
            new Thread(new Fibonacci(i + 5)).start();
        }
    }
    //Fibonacci数列
    public void fibonacciSum() {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();
        for (int i = 0; i < 10; i++) {
            Future<Integer> result = exec.submit(new FibonacciSum(i + 3));
            results.add(result);
        }
        try {
            for (Future<Integer> res : results
                    ) {
                //主线程会阻塞在res.get() 等待线程池中计算的结果
                System.out.println(res.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    //线程休眠
    public void sleepingTask() {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exec.execute(new SleepingTask());
        }
    }

    //线程优先级
    public void simplePriorities() {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));//先开启多个低优先级的线程
        }
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));//最后开启一个高优先级的线程
        exec.shutdown();

    }

    //后台线程
    public void simpleDaemons() {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);//设为后台线程
            daemon.start();
        }
        System.out.println("所有线程已启动！");
        try {
            TimeUnit.MILLISECONDS.sleep(110);//调整为不同的值  看看后台线程的输出为什么
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
//        new JavaConcurrence().moreBasicThreads();
//        new JavaConcurrence().cachedThreadPool();
//        new JavaConcurrence().fixedThreadPool();
//        new JavaConcurrence().singleThreadPool();
//        new JavaConcurrence().scheduledThreadPool();
//        new JavaConcurrence().callableThread();
//        new JavaConcurrence().fibonacci();
//        new JavaConcurrence().fibonacciSum();
//        new JavaConcurrence().sleepingTask();
//        new JavaConcurrence().simplePriorities();
        new JavaConcurrence().simpleDaemons();
    }


}
