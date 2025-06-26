package org.example.CompletableFuture;

import java.util.concurrent.*;

/**
 * Example demonstrating CompletableFuture's asynchronous chaining capabilities
 * with custom thread pool executor.
 */
public class CompletableFutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Create a thread pool with fixed number of threads
        ExecutorService executor = Executors.newFixedThreadPool(9);

        try {
            // Create and chain multiple operations in CompletableFuture
            CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("Initial task running on thread: " + Thread.currentThread().getName());
                    try {
                        // Simulate a long-running operation that might take too long
                        Thread.sleep(5000); // 5 seconds
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    return "Hello";
                }, executor)
                .thenApplyAsync(result -> {
                    System.out.println("First transformation running on thread: " + Thread.currentThread().getName());
                    return result + " World";
                }, executor)
                .thenApplyAsync(result -> {
                    System.out.println("Second transformation running on thread: " + Thread.currentThread().getName());
                    return result.toUpperCase();
                }, executor)
                .thenApplyAsync(result -> {
                    System.out.println("Third transformation running on thread: " + Thread.currentThread().getName());
                    return result.replace(" ", "-");
                }, executor);

            // Set up a timeout mechanism that will complete the future after 2 seconds if not already done
            CompletableFuture.runAsync(() -> {
                try {
                    // Wait for 2 seconds
                    Thread.sleep(2000);

                    // Check if the future is still not complete
                    if (!future.isDone()) {
                        System.out.println("Operation is taking too long! Completing manually with a timeout value.");
                        // Manually complete the future with a default value
                        boolean wasCompleted = future.complete("OPERATION-TIMED-OUT");
                        if (wasCompleted) {
                            System.out.println("Successfully completed the future manually.");
                        } else {
                            System.out.println("Future was already completed by the time we tried.");
                        }
                    } else {
                        System.out.println("Future completed naturally before timeout.");
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, executor);

            // Block and wait for the final result
            String finalResult = future.get();
            System.out.println("Final Result: " + finalResult);  // Will be either HELLO-WORLD or OPERATION-TIMED-OUT
        } finally {
            // Clean shutdown of the executor service
            System.out.println("Shutting down executor service...");
            executor.shutdown();
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.err.println("Executor did not terminate in the specified time.");
                executor.shutdownNow();
            }
        }
    }
}
