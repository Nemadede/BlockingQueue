package com.blocking_queues;

import com.blocking_queues.threadpools.CustomThreadPoolExecutor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Writer implements Runnable {

    private final String name;
    private long startTime;
    private DataFetchState dataFetchState;


    public Writer(String name, DataFetchState dataFetchState){
        this.name = name;
        this.dataFetchState = dataFetchState;

    }


    @Override
    public void run() {

        startTime = System.currentTimeMillis();

        System.err.println("\n===============About to Write to "+ name.toUpperCase() +" START TIME "+ LocalTime.now()+
                "=================================");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        batchSave();

        System.err.println("\n============= Done Writing "+ name.toUpperCase() +" END TIME "+LocalTime.now()+
                "===========================\n");

        dataFetchState.setCount();
    }



    private void save(String name){
        new Test(name).save();
    }

    private void batchSave(){
        ArrayList<String> list = generateArray();
        List<Test> tests = new ArrayList<>();
        for(String s: list ){
            tests.add(new Test(s));
        }
//        Anima.saveBatch(tests);
    }

    private ArrayList<String> generateArray(){
        ArrayList<String > array = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            array.add(UserControls.generateRandomString());
        }

        return array;
    }
}
