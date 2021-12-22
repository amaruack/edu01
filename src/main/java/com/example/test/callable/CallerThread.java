package com.example.test.callable;

import java.util.concurrent.Callable;

public class CallerThread implements Callable {
    @Override
    public Object call() throws Exception {

//        Thread.sleep(1000);

        return "object";
    }
}
