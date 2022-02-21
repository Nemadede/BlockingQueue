package com.blocking_queues;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BQueue {

     static BQueue instance;

    private BQueue(){}


    private static final BlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(50);

    public static BQueue getInstance(){
        if (instance == null){
            return new BQueue();
        }

        return instance;
    }

    public void put(Object o){
        try {
            blockingQueue.put(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Object removeObject(){
        Object o = null;
        try {
            o = blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return o;
    }

    public boolean isEmpty(){
        return blockingQueue.isEmpty();
    }

    public void print(){
        System.out.println(Arrays.toString(blockingQueue.toArray()));
    }
}
