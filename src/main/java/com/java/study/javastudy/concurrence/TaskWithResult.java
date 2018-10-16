package com.java.study.javastudy.concurrence;

import java.util.concurrent.Callable;

/**
 * 需要用多线程执行的任务，有返回值
 *
 */
public class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        if(id==4)
            Thread.sleep(5000);
        return "result with taskResult id :"+id;
    }
}
