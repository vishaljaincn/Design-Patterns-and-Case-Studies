package org.example.SemaphoreExample;

import java.util.concurrent.Semaphore;

class Worker extends Thread {
    private Semaphore semaphore;
    private int workerId;

    public Worker(Semaphore semaphore, int workerId) {
        this.semaphore = semaphore;
        this.workerId = workerId;
    }

    @Override
    public void run() {
        try {
            // Acquire a permit before entering critical section
            semaphore.acquire();
            System.out.println("Worker " + workerId + " is accessing the resource...");

            // Simulating some work with sleep
            Thread.sleep(2000);

            System.out.println("Worker " + workerId + " is done. Releasing the resource...");

            // Release the permit after work is done
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SemaphoreExample {
    public static void main(String[] args) {
        // Create a semaphore with 3 permits
        Semaphore semaphore = new Semaphore(3);

        // Create and start multiple workers
        for (int i = 1; i <= 6; i++) {
            new Worker(semaphore, i).start();
        }
    }
}
