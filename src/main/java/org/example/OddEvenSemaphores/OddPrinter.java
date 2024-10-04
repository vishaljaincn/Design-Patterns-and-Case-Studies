package org.example.OddEvenSemaphores;

import java.util.concurrent.Semaphore;

public class OddPrinter implements Runnable {
    private final Count count;
    private final Semaphore oddSemaphore;
    private final Semaphore evenSemaphore;
    private static final int MAX = 100;

    public OddPrinter(Count count, Semaphore oddSemaphore, Semaphore evenSemaphore) {
        this.count = count;
        this.oddSemaphore = oddSemaphore;
        this.evenSemaphore = evenSemaphore;
    }

    @Override
    public void run() {
        try {
            while (count.value < MAX) {
                oddSemaphore.acquire(); // Acquire the odd semaphore
                if (count.value < MAX && count.value % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + " (Odd): " + count.value);
                    count.value++;
                    evenSemaphore.release(); // Release the even semaphore
                }

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
