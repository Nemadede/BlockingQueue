package com.blocking_queues;

import com.blocking_queues.threadpools.CustomThreadPoolExecutor;

import java.util.concurrent.*;

public class WriteThreadPool {

    private WriteThreadPool(){}

    private static WriteThreadPool instance;
    final static BlockingQueue<Runnable> WblockingQueue = new ArrayBlockingQueue<Runnable>(50);

    public static WriteThreadPool getInstance(){
        if(instance == null){
            return new WriteThreadPool();
        }

        return instance;
    }

    // Executors for Writing
    public CustomThreadPoolExecutor getWriteThreadPoolExecutor() {

        int corePoolSize = 1;
        int maximumPoolSize =1;
        long keepAliveTime = 100;

        final CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor(corePoolSize,maximumPoolSize,
                keepAliveTime, TimeUnit.MILLISECONDS, WblockingQueue);

        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                  System.out.println(" ");
                  System.out.println("Waiting for a second !!");

                  try{
                      Thread.sleep(1000);
                  }catch (InterruptedException e){
                      e.printStackTrace();
                  }


                  executor.execute(runnable);
              }
          }
        );

        executor.prestartAllCoreThreads();
        return executor;
    }
}
