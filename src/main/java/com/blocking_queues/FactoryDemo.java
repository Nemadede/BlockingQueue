package com.blocking_queues;

import com.blocking_queues.threadpools.CustomThreadPoolExecCustomFactory;
import com.blocking_queues.threadpools.PoolsControl;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

public class FactoryDemo {
    public static void main(String[] args) {
//        SimpleThreadFactory threadFactory = new SimpleThreadFactory(1);
//
//        CustomThreadPoolExecCustomFactory executor = PoolsControl.testDefaultFactory(threadFactory);

        for(int i = 0; i< 3; i++){
            SimpleThreadFactory threadFactory = new SimpleThreadFactory(i);

            CustomThreadPoolExecCustomFactory executor = PoolsControl.testDefaultFactory(threadFactory);

            for(int j=0; j<11; j++){
                executor.execute(new RunnableDemo(j));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class RunnableDemo implements Runnable{
    private int count;

    public RunnableDemo(int count){
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + count);

        try {
            Thread.sleep(10);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class SimpleThreadFactory implements ThreadFactory{

    int num;

    public SimpleThreadFactory(int num){
        this.num = num;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("Nema:-" + num + "-" + UserControls.generateRandomSSN());
        return thread;
    }
}

