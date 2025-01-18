package org.example.java8practicequestions.MCQ;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;

public class UserDataFetcher {

    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("Something went wrong!");
        });

// Using get()
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Handled Exception with get(): " + e.getCause());
        }

// Using join()
        try {
            future.join();
        } catch (CompletionException e) {
            System.err.println("Handled Exception with join(): " + e.getCause());
        }


    }
}
