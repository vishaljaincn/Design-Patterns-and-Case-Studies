package org.example.OddEvenSemaphores;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Count count = new Count();
        Semaphore oddSemaphore = new Semaphore(1); // Initially allow the odd thread to run
        Semaphore evenSemaphore = new Semaphore(0); // Initially block the even thread

        OddPrinter oddPrinter = new OddPrinter(count, oddSemaphore, evenSemaphore);
        EvenPrinter evenPrinter = new EvenPrinter(count, oddSemaphore, evenSemaphore);

        Thread t1 = new Thread(oddPrinter);
        Thread t2 = new Thread(evenPrinter);

        t1.start();
        t2.start();
    }
}
