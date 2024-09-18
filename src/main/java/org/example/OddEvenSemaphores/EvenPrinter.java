package org.example.OddEvenSemaphores;

import java.util.concurrent.Semaphore;

public class EvenPrinter implements Runnable {
    private final Count count;
    private final Semaphore oddSemaphore;
    private final Semaphore evenSemaphore;
    private static final int MAX = 100;

    public EvenPrinter(Count count, Semaphore oddSemaphore, Semaphore evenSemaphore) {
        this.count = count;
        this.oddSemaphore = oddSemaphore;
        this.evenSemaphore = evenSemaphore;
    }

    @Override
    public void run() {
        try {
            while (count.value <= MAX) {
                evenSemaphore.acquire(); // Acquire the even semaphore
                if (count.value <= MAX && count.value % 2 == 0) {
                    System.out.println(Thread.currentThread().getName()+" (Even): " + count.value);
                    count.value++;
                }
                oddSemaphore.release(); // Release the odd semaphore
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
