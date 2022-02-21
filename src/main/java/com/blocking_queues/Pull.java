package com.blocking_queues;

import com.blocking_queues.threadpools.CustomThreadPoolExecutor;

import java.time.LocalTime;

public class Pull implements Runnable {
    private String name;
    private long startTime;
    private DataFetchState dataFetchState;

    private CustomThreadPoolExecutor executor;


    public Pull(String name, DataFetchState dataFetchState, CustomThreadPoolExecutor writerExecutor){
        this.name = name;

        this.dataFetchState = dataFetchState;
        this.executor = writerExecutor;
    }
    @Override
    public void run() {

        startTime = System.currentTimeMillis();

        System.out.println("\n" );
        System.out.println("----------------> About to Pull "+ name.toUpperCase() +"---> START TIME "+LocalTime.now()+
                "<--------------------");

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n---------------->"+ name.toUpperCase() +" END TIME "+LocalTime.now()+
                "<--------------------\n");

        dataFetchState = dataFetchState.setCount();
        executor.execute(new Writer(name, dataFetchState));

        System.out.println(executor.getQueue());

    }


    private String reverseString(){
        StringBuilder input1 = new StringBuilder();

        input1.append(name);

        input1.reverse();

        return input1.toString();
    }


}
