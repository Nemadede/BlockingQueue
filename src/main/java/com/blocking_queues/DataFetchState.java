package com.blocking_queues;

import java.util.concurrent.Semaphore;

public class DataFetchState {

    private Integer count = 0;
    private static  Object next;
    private Integer totalCount = 0;
    private User user;
    private String name;
    private Semaphore semaphore;

    public  DataFetchState setCount() {


        this.count ++;

        if (this.count.equals(totalCount)){
            System.err.println("-------------------------------------------------------------------------------> " +
                    "Pulling is done for User : " + getName());
            semaphore.release();
        }


        return this;
    }

    public static void setNext(Object next) {
        DataFetchState.next = next;
    }

    public DataFetchState setUser(User user) {
        this.user = user;
        return this;
    }

    public Integer getCount(){
        return this.count;
    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public DataFetchState setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        return this;
    }
}
