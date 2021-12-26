package com.example.test.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTest {

    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {

        int corePoolSize = 10;
        int maximumPoolSize = 20;
        int keepAliveTime = 600;

        int queueSize = 100;

        // 기본 abort
        ThreadPoolExecutor executor  = new ThreadPoolExecutor(
            corePoolSize,
            maximumPoolSize,
            keepAliveTime, TimeUnit.SECONDS,
            new SynchronousQueue<>()
        );

        // queue size 지정
//        ThreadPoolExecutor executor  = new ThreadPoolExecutor(
//            corePoolSize,
//            maximumPoolSize,
//            keepAliveTime, TimeUnit.SECONDS,
//            new LinkedBlockingQueue(queueSize),
//            new ThreadPoolExecutor.CallerRunsPolicy()
//        );

        // queue size 지정 안함
//        ThreadPoolExecutor executor  = new ThreadPoolExecutor(
//            corePoolSize,
//            maximumPoolSize,
//            keepAliveTime, TimeUnit.SECONDS,
//            new LinkedBlockingQueue(),
//            new ThreadPoolExecutor.CallerRunsPolicy()
//        );


        for (int i = 0; i < 100 ; i++) {
            SampleThread th = new SampleThread(i);
            executor.execute(th);
            System.out.println("current millis " +System.currentTimeMillis()+ " getCorePoolSize = "+ executor.getCorePoolSize() +" getPoolSize = "+ executor.getPoolSize() +" getActiveCount = "+ executor.getActiveCount() +" getTaskCount = "+ executor.getTaskCount()+" getCompletedTaskCount = "+ executor.getCompletedTaskCount()+" getQueue size = "+ executor.getQueue().size());
        }

        while (true) {
            System.out.println("extra getCorePoolSize = "+ executor.getCorePoolSize() +" getPoolSize = "+ executor.getPoolSize() +"  getActiveCount = "+ executor.getActiveCount() +" getTaskCount = "+ executor.getTaskCount()+" getCompletedTaskCount = "+ executor.getCompletedTaskCount()+" getQueue size = "+ executor.getQueue().size());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}
