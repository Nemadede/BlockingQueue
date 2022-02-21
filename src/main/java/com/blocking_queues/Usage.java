package com.blocking_queues;

import java.util.concurrent.Semaphore;

public class Usage implements Runnable {
    User user;
    Semaphore semaphore;
    DataFetchState dataFetchState;

    public Usage(User user, Semaphore semaphore, DataFetchState dataFetchState){
        this.user = user;
        this.semaphore = semaphore;
        this.dataFetchState = dataFetchState;
    }

    @Override
    public void run() {

        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------------------------------------------------------------------->" +
                " Running User with name:" +
                " "+user.getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        dataFetchState = dataFetchState.setCount();
        PullService pullService = new PullService(user, dataFetchState);
        pullService.pull();

    }
}
