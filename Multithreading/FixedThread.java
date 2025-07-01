package Multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FixedThread {
    public static final ExecutorService ex = Executors.newFixedThreadPool(3);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String tasks[] = {"Task1", "Task2", "Task3", "Task4", "Task5", "Task6", "Task7"};
        for(String task : tasks)
            System.out.println(executeProcess(task));
        ex.shutdown();
    }

    public static String executeProcess(String data) throws ExecutionException, InterruptedException {
        // submit() can be used to provide a result of Future<T> or Callable<T> with exceptions
        Callable<String> task = () -> {
            System.out.println("Started task : "+data+" on : "+Thread.currentThread().getName());
            Thread.sleep(2000);
            return "COMPLETED task : "+data;
        };
        FutureTask<String> future = new FutureTask<>(task);
        ex.submit(future);
        return future.get();
    }
}