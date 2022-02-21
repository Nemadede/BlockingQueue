package com.blocking_queues;

public class User {

    private String name;
    private Integer ssn;

    public User(String name, Integer ssn){
        this.name = name;
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public Integer getSsn() {
        return ssn;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", ssn=" + ssn +
                '}';
    }
}
