package com.blocking_queues;

import com.blocking_queues.threadpools.CustomThreadPoolExecutor;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Integer threadCounter = 0;

        final CustomThreadPoolExecutor executor = getCustomThreadPoolExecutor();

        while (true){
            threadCounter++;

            System.out.println("Adding DemoTask: "+ threadCounter);
            executor.execute(new DemoTask(threadCounter.toString()));

            if(threadCounter == 100)
                break;
        }

    }


    private static CustomThreadPoolExecutor getCustomThreadPoolExecutor() {
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(50);
        int corePoolSize = 1;
        int maximumPoolSize = 2;
        long keepAliveTime = 5000;

        final CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor(corePoolSize,maximumPoolSize,
                keepAliveTime, TimeUnit.MILLISECONDS, blockingQueue);

        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable runnable,
                                                  ThreadPoolExecutor threadPoolExecutor) {
                        System.out.println("DemoTask Rejected: "+((DemoTask) runnable).getName());
                        System.out.println("Waiting for a second !!");
                        try{
                            Thread.sleep(1000);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }

                        System.out.println("Lets add another time: " +
                                ((DemoTask) runnable).getName());
                        executor.execute(runnable);
                    }
                }
        );

        executor.prestartAllCoreThreads();
        return executor;
    }
}
