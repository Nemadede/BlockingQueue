package com.blocking_queues.threadpools;

import com.blocking_queues.threadpools.CustomThreadPoolExecutor;

import java.util.concurrent.*;

public class PoolsControl {

    final static BlockingQueue<Runnable> WblockingQueue = new ArrayBlockingQueue<Runnable>(50);
    final static BlockingQueue<Runnable> PblockingQueue = new ArrayBlockingQueue<Runnable>(50);
    final static BlockingQueue<Runnable> UblockingQueue = new ArrayBlockingQueue<Runnable>(50);

    public static CustomThreadPoolExecutor getCustomThreadPoolExecutor() {
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(1);
        int corePoolSize = 1;
        int maximumPoolSize = 10;
        long keepAliveTime = 5000;

        final CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor(corePoolSize,maximumPoolSize,
                keepAliveTime, TimeUnit.MILLISECONDS, blockingQueue);

        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
                 @Override
                 public void rejectedExecution(Runnable runnable,
                                               ThreadPoolExecutor threadPoolExecutor) {
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

    // Executors for Pulling
    public static CustomThreadPoolExecutor getPullThreadPoolExecutor() {
        int corePoolSize = 2;
        int maximumPoolSize = 4;
        long keepAliveTime = 5000;

        final CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor(corePoolSize,maximumPoolSize,
                keepAliveTime, TimeUnit.MILLISECONDS, PblockingQueue);

        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
                 @Override
                 public void rejectedExecution(Runnable runnable,
                                               ThreadPoolExecutor threadPoolExecutor) {
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

    // Executors for Writing
    public static CustomThreadPoolExecutor getWriteThreadPoolExecutor() {

        int corePoolSize = 1;
        int maximumPoolSize =2;
        long keepAliveTime = 100;

        final CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor(corePoolSize,maximumPoolSize,
                keepAliveTime, TimeUnit.MILLISECONDS, WblockingQueue);

        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
                 @Override
                 public void rejectedExecution(Runnable runnable,
                                               ThreadPoolExecutor threadPoolExecutor) {
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

   public static CustomThreadPoolExecutor getUserThreadPoolExecutor() {

        int corePoolSize = 1;
        int maximumPoolSize = 1;
        long keepAliveTime = 100;

        final CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor(corePoolSize,maximumPoolSize,
                keepAliveTime, TimeUnit.MILLISECONDS, UblockingQueue);

        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
                 @Override
                 public void rejectedExecution(Runnable runnable,
                                               ThreadPoolExecutor threadPoolExecutor) {
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
   public static CustomThreadPoolExecCustomFactory testDefaultFactory(ThreadFactory customFactory ) {

        int corePoolSize = 3;
        int maximumPoolSize = 10;
        long keepAliveTime = 1;

        final CustomThreadPoolExecCustomFactory executor = new CustomThreadPoolExecCustomFactory(corePoolSize,maximumPoolSize,
                keepAliveTime, TimeUnit.MILLISECONDS, UblockingQueue, customFactory);

        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
                 @Override
                 public void rejectedExecution(Runnable runnable,
                                               ThreadPoolExecutor threadPoolExecutor) {
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
