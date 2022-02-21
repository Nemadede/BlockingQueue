package com.blocking_queues;

import com.blocking_queues.threadpools.CustomThreadPoolExecutor;
import com.blocking_queues.threadpools.PoolsControl;
import io.github.biezhi.anima.Anima;

import java.util.concurrent.*;

public class Service {
    public static void main(String[] args) {

        Anima.open("jdbc:mysql://localhost:3306/queues", "username", "root");



        CustomThreadPoolExecutor executor = PoolsControl.getUserThreadPoolExecutor();

        Semaphore sem = new Semaphore(2);
        System.err.println("Starting................................");

        for (int i =0; i<10; i++){
            String name = UserControls.generateRandomString();
            int ssn = UserControls.generateRandomSSN();
            User user = UserControls.createUser(name, ssn);

            DataFetchState dataFetchState = new DataFetchState();
            dataFetchState.setName(name);
            dataFetchState.setSemaphore(sem);
            executor.execute(new Usage(user,sem, dataFetchState));

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(executor.getQueue());

    }

}
