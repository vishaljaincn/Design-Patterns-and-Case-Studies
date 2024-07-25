package org.example.numberprinter1to100;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("First Printed by thread: " + Thread.currentThread().getName());
        Thread t;
        for (int i = 1; i <= 100; i++) {
            NumberPrinter numberPrinterTask = new NumberPrinter(i);
            t = new Thread(numberPrinterTask);
            t.start();
            t.join();
        }
        System.out.println("Last Printed by thread: " + Thread.currentThread().getName());
    }
}
