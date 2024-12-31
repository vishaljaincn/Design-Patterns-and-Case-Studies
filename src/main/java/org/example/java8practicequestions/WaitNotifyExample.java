package org.example.java8practicequestions;

class SharedResource {
    private int item = 0;
    private final int MAX_ITEMS = 5;

    // Producer thread method
    public synchronized void produce() throws InterruptedException {
        while (item >= MAX_ITEMS) {
            this.wait(); // Wait if the buffer is full
        }
        item++;
        System.out.println("Produced item " + item);
        this.notify(); // Notify consumer to consume
    }

    // Consumer thread method
    public synchronized void consume() throws InterruptedException {
        while (item <= 0) {
            this.wait(); // Wait if the buffer is empty
        }
        System.out.println("Consumed item " + item);
        item--;
        this.notify(); // Notify producer to produce
    }
}

public class WaitNotifyExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    resource.produce();
                    Thread.sleep(500); // Simulate production time
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    resource.consume();
                    Thread.sleep(1000); // Simulate consumption time
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
