package org.example.OddEvenWaitAndNotify;

public class EvenPrinter implements Runnable {
    private final Count count;
    private static final int MAX = 100;

    public EvenPrinter(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (count) {
            while (count.value <= MAX) {
                if (count.value % 2 != 0) {
                    try {
                        count.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(Thread.currentThread().getName()+ "(Even): " + count.value);
                count.value++;
                count.notify();
            }
        }
    }
}
