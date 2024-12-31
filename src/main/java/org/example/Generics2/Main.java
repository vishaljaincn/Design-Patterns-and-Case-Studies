package org.example.Generics2;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException("Exception in run()");

    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {


        // Set an UncaughtExceptionHandler
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            System.out.println("Exception in thread " + t.getName() + ": " + e.getMessage());
        });
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        Thread.currentThread().wait();

        try {
            // Main thread is not affected by exceptions in MyRunnable
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println("Main thread execution continues.");
    }
}
