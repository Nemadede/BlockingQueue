package com.blocking_queues;

import java.util.Random;

public class UserControls {

    private BQueue queue;

    public static User createUser(String name, Integer ssn){
        BQueue queue = BQueue.getInstance();
        User user = new User(name, ssn);
//        queue.put(user);

        return user;
    }

    public static String generateRandomString(){
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;

        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static Integer generateRandomSSN(){
        Random random = new Random();

        return random.nextInt(100);
    }


    public static float timing(long start){
        long end = System.currentTimeMillis();

        return (end-start)/1000F;
    }

}
