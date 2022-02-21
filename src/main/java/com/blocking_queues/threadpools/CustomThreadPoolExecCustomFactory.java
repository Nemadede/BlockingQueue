package com.blocking_queues.threadpools;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExecCustomFactory extends ThreadPoolExecutor {
    ThreadFactory threadFactory;
    public CustomThreadPoolExecCustomFactory(int i, int i1, long l, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i1, l, timeUnit, blockingQueue, threadFactory);
        this.threadFactory = super.getThreadFactory();
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r){
        super.beforeExecute(t,r);
//
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t){
        super.afterExecute(r,t);
        if(t != null){
            System.out.println("Perform exception handler logic");
        }
//        System.out.println("Perform afterExecute() logic");
    }

}
