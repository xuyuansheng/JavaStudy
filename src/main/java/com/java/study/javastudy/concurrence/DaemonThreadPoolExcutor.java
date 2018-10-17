package com.java.study.javastudy.concurrence;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 每个静态的ExcutorService创建方法都被重载为接受一个ThreadFactory对象，而这个对象将被用来创建新的线程
 */
public class DaemonThreadPoolExcutor extends ThreadPoolExecutor {
//  没有无参构造的类，其子类要显示的重写构造类

    public DaemonThreadPoolExcutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public DaemonThreadPoolExcutor() {
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(),new DaemonThreadFactory());
    }
}
