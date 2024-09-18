package org.example.OddEvenWaitAndNotify;

public class OddPrinter implements Runnable {
    private final Count count;
    private static final int MAX = 100;

    public OddPrinter(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (count) {
            while (count.value < MAX) {
                if (count.value % 2 == 0) {
                    try {
                        count.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " (Odd): " + count.value);
                count.value++;
                count.notify();
            }
        }
    }
}
