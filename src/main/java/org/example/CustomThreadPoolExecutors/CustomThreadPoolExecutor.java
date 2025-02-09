package org.example.CustomThreadPoolExecutors;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExecutor {
    public static void main(String[] args) {
        // Creating a ThreadPoolExecutor
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, // corePoolSize
                5, // maximumPoolSize
                60, // keepAliveTime
                TimeUnit.SECONDS, // unit
                new LinkedBlockingQueue<Runnable>(), // workQueue
                Executors.defaultThreadFactory(), // threadFactory
                new ThreadPoolExecutor.AbortPolicy() // handler
        );

        // Submitting tasks to the thread pool
        for (int i = 0; i < 10; i++) {
            final int taskNumber = i;
            executor.execute(() -> {
                System.out.println("Executing Task " + taskNumber + " by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // Shutdown the executor
        executor.shutdown();
    }
}
