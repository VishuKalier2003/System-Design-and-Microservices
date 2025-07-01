package Multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleThread {
    public static final ExecutorService es = Executors.newSingleThreadExecutor();
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String tasks[] = {"Task1 : drinking coffee", "Task2 : eating peach", "Task 3 : running"};
        for(String task : tasks)
            System.out.println(runThread(task));
        es.shutdown();
    }

    public static String runThread(String data) throws InterruptedException, ExecutionException {
        Future<String> f = es.submit(() -> {
            System.out.println("Started task..."+data);
            Thread.sleep(2000);
            return "COMPLETED : "+data;
        });
        return f.get();
    }
}
