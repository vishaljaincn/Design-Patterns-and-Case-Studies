package org.example.NumberPrinter1to100ExecutorService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 100; i++) {
            if (i == 11 || i == 51 || i == 99) {
                System.out.println("DEBUG");
            }
            NumberPrinter numberPrinter = new NumberPrinter(i);
            executorService.submit(numberPrinter);
        }

        executorService.shutdown();
    }
}