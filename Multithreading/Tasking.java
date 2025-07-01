package Multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Tasking {
    public static final ExecutorService es = Executors.newFixedThreadPool(3);
    public static void main(String[] args) throws Exception {
        for(int i = 0; i <= 5; i++){
            executeCallable(i);
            executeRunnable(i);
        }
    }

    public static Integer executeCallable(int taskID) throws InterruptedException, ExecutionException {
        Callable<Integer> task = () -> {
            System.out.println("task "+taskID+" started...");
            Thread.sleep(1500);
            return taskID;
        };
        FutureTask<Integer> f = new FutureTask<>(task);
        es.submit(f);
        return f.get();
    }

    public static Integer executeRunnable(int taskID) throws Exception {
        es.submit(() -> {
            System.out.println("Task "+taskID+" started...");
            return taskID;
        });
        return taskID;
    }
}
