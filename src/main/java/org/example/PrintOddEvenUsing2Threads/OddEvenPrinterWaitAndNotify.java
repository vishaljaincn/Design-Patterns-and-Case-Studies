package org.example.PrintOddEvenUsing2Threads;
/*
In your code, the use of synchronized blocks ensures that only one thread can hold the lock on the count object at a time.
When a thread calls count.wait(), it releases the lock on count and enters the waiting state.
The notify method is used to wake up one of the threads that are waiting on the same object's monitor (in this case, count).

Here’s a step-by-step explanation of how your program works:

    Thread 1 (Odd numbers) and Thread 2 (Even numbers) start almost simultaneously.
    Both threads try to enter their respective synchronized blocks, but only one can acquire the lock at a time.

Assume Thread 1 acquires the lock first:
    - It enters the synchronized block and checks if count.value is even (if it is, it will call count.wait()).
    - Since count.value is initially 1 (odd), Thread 1 prints the value and increments it.
    - Then, Thread 1 calls count.notify(), which wakes up Thread 2 if it is waiting.
    - Thread 1 releases the lock on count when it exits the synchronized block (either after printing and notifying or by calling wait and releasing the lock).

Thread 2 can now acquire the lock on count and proceed with its synchronized block:
    - It checks if count.value is odd (if it is, it will call count.wait()).
    - Since count.value was incremented to 2 by Thread 1, Thread 2 prints the value and increments it.
    - Then, Thread 2 calls count.notify(), which wakes up Thread 1 if it is waiting.

This process repeats, with the threads alternating: each thread waits when it’s not their turn, and each thread gets notified when the other thread completes its turn.

The key point is that when a thread calls count.wait(), it releases the lock and goes into the waiting state.
This allows the other thread to acquire the lock.
The count.notify() method does not immediately give up the lock; it merely wakes up a waiting thread, which will then compete to acquire the lock.

/*
Using wait() and notify():

When a thread calls count.wait(), it releases the lock on count and enters a waiting state (WAITING state). This allows another thread (in this case, the other thread) to acquire the lock on count.
When a thread calls count.notify(), it notifies one of the threads waiting on the count object. This waking up of the waiting thread does not immediately relinquish the lock; the notified thread must still compete to reacquire the lock before it can proceed.

 */

public class OddEvenPrinterWaitAndNotify {
    private final Count count = new Count();
    private static final int MAX = 100;

    public static void main(String[] args) {
        OddEvenPrinterWaitAndNotify printer = new OddEvenPrinterWaitAndNotify();

        Thread t1 = new Thread(() -> printer.printOddNumbers());
        Thread t2 = new Thread(() -> printer.printEvenNumbers());

        t1.start();
        t2.start();
    }

    public void printOddNumbers() {
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

    public void printEvenNumbers() {
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
