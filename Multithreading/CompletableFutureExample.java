package Multithreading;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Create a CompletableFuture that runs a simple task asynchronously.
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result of the asynchronous computation";
        });

        // Block and get the result of the Future.
        String result = future.get();
        System.out.println(result);

        // Create a CompletableFuture that completes with a value.
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.complete("Hello");

        // Attach a callback to the CompletableFuture.
        completableFuture.thenAccept(s -> System.out.println("Received: "+s));

        // Create a CompletableFuture that runs a task and returns a value.
        CompletableFuture<Integer> futureWithResult = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 123;
        });

        // Attach a callback to the CompletableFuture that will be executed when the future completes.
        futureWithResult.thenAccept(r -> System.out.println("Result: " + r));

        // Wait for the future to complete.
        futureWithResult.join();
    }
}
