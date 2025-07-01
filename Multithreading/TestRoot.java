package Multithreading;

import java.util.concurrent.CompletableFuture;

public class TestRoot {
    
    public CompletableFuture<Double> fRoot(int n) {
        // Start with supplyAsync to return a value or runAsync to not return a value
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("fRoot started...");
            try {Thread.sleep(5000);}
            catch(InterruptedException e) {e.getMessage();}
            System.out.println("fRoot terminated...");
            return Math.sqrt(n);
        });
    }
}
