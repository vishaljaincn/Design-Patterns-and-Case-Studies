package org.example.CountDownLatch_and_CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () ->
                System.out.println("All threads reached barrier. Proceeding...")
        );

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " waiting at barrier.");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " crossed the barrier.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}
