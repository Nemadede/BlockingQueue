package com.blocking_queues.threadpools;

import java.util.concurrent.*;

public class CustomThreadPoolExecutor extends ThreadPoolExecutor {


    public CustomThreadPoolExecutor(int i, int i1, long l, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        super(i, i1, l, timeUnit, blockingQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r){
        super.beforeExecute(t,r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t){
       super.afterExecute(r,t);
       if(t != null){
           System.out.println("Perform exception handler logic");
       }
    }



}
