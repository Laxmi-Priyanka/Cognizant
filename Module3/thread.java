class MessageThread extends Thread {
    private String message;
    private int count;

    public MessageThread(String message, int count) {
        this.message = message;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= count; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + message + " (" + i + ")");
            try {
                Thread.sleep(500); // Pause 0.5 seconds for visibility
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        MessageThread t1 = new MessageThread("Hello from Thread 1", 5);
        MessageThread t2 = new MessageThread("Hello from Thread 2", 5);

        t1.start();
        t2.start();
    }
}
