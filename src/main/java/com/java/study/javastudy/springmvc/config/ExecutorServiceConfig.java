package com.java.study.javastudy.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.*;

/**
 * 线程池配置
 *
 * @author Mr.Xu
 * @date 2020/5/20 22:12
 */
@Configuration
@Async
public class ExecutorServiceConfig {

    private int corePoolSize = 4;
    private int maxPoolSize = 8;
    private int workQueueSize = 100;


    @Bean("executorService")
    public ExecutorService executorService(ThreadFactory threadFactory) {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(workQueueSize);
        return new ThreadPoolExecutor(corePoolSize, maxPoolSize, 0L, TimeUnit.MILLISECONDS, workQueue, threadFactory);
    }

    @Bean
    public ThreadFactory threadFactory() {
        return r -> {
            Thread thread = new Thread(r);
            /*  自定义线程的名称 */
            thread.setName("CustomizeThreadName" + thread.getName());
            return thread;
        };
    }


    public static void main(String[] args) {
        ExecutorServiceConfig executorServiceConfig = new ExecutorServiceConfig();

        ExecutorService executorService = executorServiceConfig.executorService(executorServiceConfig.threadFactory());
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                System.out.println("threadName : " + Thread.currentThread().getName());
            });
        }
        executorService.shutdown();
    }

}
