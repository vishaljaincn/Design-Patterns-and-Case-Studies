package org.example.ProducerConsumerConceptAndCoding;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerLearning {

    public static void main(String[] args) {
        SharedResource sharedBuffer = new SharedResource(10);

        // Creating producer thread using Lambda expression
        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 20; i++) {
                    sharedBuffer.produce(i);
                }
            } catch (Exception e) {
                // Handle exception here
                e.printStackTrace();
            }
        });

        // Creating consumer thread using Lambda expression
        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 20; i++) {
                    sharedBuffer.consume();
                }
            } catch (Exception e) {
                // Handle exception here
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}

class SharedResource {
    private Queue<Integer> sharedBuffer;
    private int bufferSize;

    public SharedResource(int bufferSize) {
        sharedBuffer = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void produce(int item) throws Exception {
        // If buffer is full, wait for the consumer to consume items
        while (sharedBuffer.size() == bufferSize) {
            System.out.println("Buffer is full, Producer is waiting for consumer");
            wait();
        }

        sharedBuffer.add(item);
        System.out.println("Produced: " + item);

        // Add small delay to allow consumer thread to get scheduled
        Thread.sleep(100);

        notify();
    }

    public synchronized int consume() throws Exception {
        // If buffer is empty, wait for the producer to produce items
        while (sharedBuffer.isEmpty()) {
            System.out.println("Buffer is empty, Consumer is waiting for producer");
            wait();
        }

        int item = sharedBuffer.poll();
        System.out.println("Consumed: " + item);

        // Add small delay to allow producer thread to get scheduled
        Thread.sleep(150);

        notify();
        return item;
    }
}