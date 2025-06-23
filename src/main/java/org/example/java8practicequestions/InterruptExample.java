package org.example.java8practicequestions;

class MyThread extends Thread {
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread running: " + i);
                Thread.sleep(1000); // Simulating work
            }
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted.");
        } finally {
            System.out.println("Thread finished execution.");
        }
    }
}

public class InterruptExample {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        try {
            Thread.sleep(2000); // Main thread waits for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.interrupt(); // Interrupting the thread
    }
}
