package org.example.AdderSubtractorSynchronised;

public class SynchronizationExample {

    private int counter = 0;

    // Synchronized block
    public void incrementCounterSynchronizedBlock() {
        synchronized (this) {
            counter++;
            System.out.println("Counter: " + counter + " - Thread: " + Thread.currentThread().getName());
        }
    }

    public int getCounter() {
        return counter;
    }

    public static void main(String[] args) {
        SynchronizationExample example = new SynchronizationExample();

        // Create multiple threads to increment the counter
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                example.incrementCounterSynchronizedBlock();
            }
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                example.incrementCounterSynchronizedBlock();
            }
        }, "Thread-2");

        // Start the threads
        thread1.start();
        thread2.start();

        // Wait for threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter Value: " + example.getCounter());
    }
}
