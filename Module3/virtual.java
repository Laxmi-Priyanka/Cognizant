public class VirtualThreadsExample {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        // Create and start 100,000 virtual threads
        var threads = new Thread[100_000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = Thread.startVirtualThread(() -> {
                // Each thread prints a simple message (can be commented to speed up)
                // System.out.println("Hello from virtual thread " + Thread.currentThread().getName());
            });
        }

        // Wait for all threads to finish
        for (Thread t : threads) {
            t.join();
        }

        long end = System.currentTimeMillis();
        System.out.println("Completed 100,000 virtual threads in " + (end - start) + " ms");
    }
}
