package Multithreading;

import java.util.concurrent.CompletableFuture;

public class TestSquare {

    public CompletableFuture<Integer> fSquare(int n) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("fSquare started...");
            sleep(2000);
            System.out.println("fSquare terminated...");
            return n * n;
        });
    }

    public void sleep(int d) {
        try {
            Thread.sleep(d);
        } catch (InterruptedException e) {
            e.getLocalizedMessage();
        }
    }
}