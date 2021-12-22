package com.example.test.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolTest {

    public static List<Future> list = new ArrayList<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int corePoolSize = 10;
        int maximumPoolSize = 20;
        int keepAliveTime = 600;

        int queueSize = 100;

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            corePoolSize,
            maximumPoolSize,
            keepAliveTime, TimeUnit.SECONDS,
            new LinkedBlockingQueue(queueSize),
            new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for (int i = 0; i < 100; i++) {
            CallerThread th = new CallerThread();
            Future future = executor.submit(th);
            list.add(future);
        }

        System.out.println("INSERT ALL");

        for (Future fu : list) {
            Object returnOjb = fu.get();
            System.out.println(returnOjb);
        }

        System.out.println("PROCESS END");

    }

}
