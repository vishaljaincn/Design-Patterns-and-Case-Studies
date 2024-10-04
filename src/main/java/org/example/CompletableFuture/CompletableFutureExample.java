package org.example.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(9);

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Initial task: return a string
            return "Hello";
        }, executor).thenApplyAsync(result -> {
            // First transformation: append " World"
            return result + " World";
        }, executor).thenApplyAsync(result -> {
            // Second transformation: convert to uppercase
            return result.toUpperCase();
        }, executor).thenApplyAsync(result -> {
            // Third transformation: replace spaces with hyphens
            return result.replace(" ", "-");
        }, executor);

        future.complete("nigga");
        // Get the final result (this will block until the result is available)
        String finalResult = future.get();
        System.out.println("Final Result: " + finalResult);  // Output: HELLO-WORLD

        // Shutdown the executor
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}
