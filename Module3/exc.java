import java.util.concurrent.*;
import java.util.*;

public class CallableExecutorExample {
    public static void main(String[] args) {
        // Create a fixed thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Create a list of Callable tasks
        List<Callable<String>> tasks = new ArrayList<>();
        tasks.add(() -> {
            Thread.sleep(1000);  // Simulate some work
            return "Task 1 completed";
        });
        tasks.add(() -> {
            Thread.sleep(500);
            return "Task 2 completed";
        });
        tasks.add(() -> {
            Thread.sleep(700);
            return "Task 3 completed";
        });

        try {
            // Submit all tasks and get a list of Future objects
            List<Future<String>> futures = executor.invokeAll(tasks);

            // Iterate over the futures and get the results
            for (Future<String> future : futures) {
                try {
                    String result = future.get();  // This will block until the result is available
                    System.out.println(result);
                } catch (ExecutionException e) {
                    System.out.println("Error executing task: " + e.getMessage());
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Tasks interrupted");
        } finally {
            // Shutdown the executor service
            executor.shutdown();
        }
    }
}
