package org.example.OddEvenWaitNotifyWithComments;

class Count {
    int value = 1;  // Shared counter
}

class EvenPrinter implements Runnable {
    private final Count count;
    private static final int MAX = 10;  // Reduced MAX for clarity

    public EvenPrinter(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (count) {
            while (count.value <= MAX) {
                if (count.value % 2 != 0) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " (Even) is WAITING");
                        count.wait();  // Releases lock and waits
                        System.out.println(Thread.currentThread().getName() + " (Even) RESUMED after wait");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                // Prints even number
                System.out.println(Thread.currentThread().getName() + " (Even): " + count.value);
                count.value++;

                // Notifies OddPrinter
                count.notify();
            }
        }
    }
}

class OddPrinter implements Runnable {
    private final Count count;
    private static final int MAX = 10;

    public OddPrinter(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (count) {
            while (count.value <= MAX) {
                if (count.value % 2 == 0) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " (Odd) is WAITING");
                        count.wait();  // Releases lock and waits
                        System.out.println(Thread.currentThread().getName() + " (Odd) RESUMED after wait");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                // Prints odd number
                System.out.println(Thread.currentThread().getName() + " (Odd): " + count.value);
                count.value++;

                // Notifies EvenPrinter
                count.notify();
            }
        }
    }
}

public class OddEvenThreadExample {
    public static void main(String[] args) {
        Count count = new Count();

        Thread evenThread = new Thread(new EvenPrinter(count), "EvenThread");
        Thread oddThread = new Thread(new OddPrinter(count), "OddThread");
        evenThread.interrupt();

        oddThread.start();
        evenThread.start();
    }
}
