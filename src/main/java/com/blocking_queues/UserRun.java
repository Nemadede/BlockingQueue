package com.blocking_queues;

import java.util.concurrent.Callable;

public class UserRun implements Callable {

    private BQueue bQueue;
    public UserRun(){
        bQueue =  BQueue.getInstance();
    }

    @Override
    public Object call(){
            User o = (User) bQueue.removeObject();
            return o;
    }
}
