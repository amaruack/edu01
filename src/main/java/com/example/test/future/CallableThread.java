package com.example.test.future;

import java.util.concurrent.Callable;

public class CallableThread implements Callable {
    @Override
    public Object call() throws Exception {

//        Thread.sleep(1000);

        return "object";
    }
}
