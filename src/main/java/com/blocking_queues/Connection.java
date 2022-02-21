package com.blocking_queues;

import io.github.biezhi.anima.Anima;

public class Connection {

    public void connect(){

        Anima.open("jdbc:mysql://localhost:3306/queues", "nemalove","root");
    }
}
