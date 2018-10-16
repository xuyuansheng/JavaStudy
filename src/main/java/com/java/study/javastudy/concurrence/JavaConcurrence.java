package com.java.study.javastudy.concurrence;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * java并发编程,不能用junit测试
 */
public class JavaConcurrence {

    @Test
    public void concurrence(){
        LiftOff lunch = new LiftOff();
        lunch.run();
    }

    @Test
    public void basicThreads(){
        Thread thread = new Thread(new LiftOff());
        thread.start();
        System.out.println("Waiting for LiftOff!");
    }


    @Test
    public void moreBasicThreads() {
        for (int i = 0; i < 5; i++) {
            new Thread(new ExerciseJava()).start();
            System.out.println("Waiting for LiftOff! "+i);
        }

    }
    @Test
    public   void cachedThreadPool(){
        ExecutorService exec = Executors.newCachedThreadPool();
        ExecutorService exec2 = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }

    @Test
    public   void  fixedThreadPool(){
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }

    @Test
    public   void  singleThreadPool(){
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }

    @Test
    public   void  scheduledThreadPool(){
        ExecutorService exec = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }


    public void  callableThread(){
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
        for (Future<String>  fs:results
             ) {
            try {
                if(fs.isDone()){
                    System.out.println(fs.get());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                exec.shutdown();
            }
        }
    }

    public void fibonacci() {
        for (int i = 0; i < 10; i++) {
            new Thread(new Fibonacci(i + 5)).start();
        }
    }

    public static void main(String[] args) {
//        new JavaConcurrence().moreBasicThreads();
//        new JavaConcurrence().cachedThreadPool();
//        new JavaConcurrence().fixedThreadPool();
//        new JavaConcurrence().singleThreadPool();
//        new JavaConcurrence().scheduledThreadPool();
        new JavaConcurrence().callableThread();
    }



}
