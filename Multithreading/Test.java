package Multithreading;

import java.util.concurrent.CompletableFuture;

public class Test {
    public static void main(String[] args) {
        int n = 7;
        // Creating futures for each pipe
        CompletableFuture<Integer> s = new TestSquare().fSquare(n), c = new TestCube().fCube(n);
        CompletableFuture<Double> r = new TestRoot().fRoot(n);
        // Future which will be created when all of the given futures are completed
        CompletableFuture<Void> allDone = CompletableFuture.allOf(s, c, r);
        // Then using the thenApply for mapping values
        CompletableFuture<Double> total = allDone.thenApply(_ -> s.join() + c.join() + r.join());
        // join is used as a final operation
        System.out.println("Total: " + total.join());
    }
}
