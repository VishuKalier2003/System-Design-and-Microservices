package Multithreading;

import java.util.concurrent.CompletableFuture;

public class TestCube {
    public CompletableFuture<Integer> fCube(int n) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("fCube started...");
            try {Thread.sleep(3000);}
            catch(InterruptedException e) {e.getMessage();}
            System.out.println("fCube terminated...");
            return n * n * n;
        });
    }
}
