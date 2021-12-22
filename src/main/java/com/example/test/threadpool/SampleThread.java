package com.example.test.threadpool;

import com.example.test.threadpool.ThreadPoolTest;

public class SampleThread implements Runnable {

    private int number;

    public SampleThread(int number){
        this.number = number;
    }

    @Override
    public void run() {
        try {
            System.out.println("start thread id = " + Thread.currentThread().getId()+ " number = "+ number);
            int count = ThreadPoolTest.count.getAndIncrement();
            System.out.println("start count " + count);
            Thread.sleep(5000);
            System.out.println("end thread id = " + Thread.currentThread().getId() + " number = "+ number);
            System.out.println("end count " + count);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
