package org.example.OddEvenWaitAndNotify;

public class Main {
    public static void main(String[] args) {
        Count count = new Count();
        OddPrinter oddPrinter = new OddPrinter(count);
        EvenPrinter evenPrinter = new EvenPrinter(count);

        Thread t1 = new Thread(oddPrinter);
        Thread t2 = new Thread(evenPrinter);

        t1.start();
        t2.start();
    }
}
