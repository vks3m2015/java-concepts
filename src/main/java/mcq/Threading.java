package mcq;

public class Threading {

    public static void main(String[] args) throws InterruptedException {
        //1
        startThreadTwice();

        //2
        new NewThread(); // Creates and starts the thread
    }

    private static class Test implements Runnable {
        public void run() {
            System.out.println("TURING ");
        }
    }
    public static void startThreadTwice() throws InterruptedException {
        Thread thread1 = new Thread(new Test());
        thread1.start(); // Start the thread
        thread1.start(); // Try to start the same thread again
        System.out.println(thread1.getState());
    }

    private static class NewThread extends Thread {
        NewThread() {
            super("My Thread"); // Sets thread name
            start();           // Starts a new thread immediately
        }
        public void run() {
            System.out.println(this); // Prints the Thread object's details
        }
    }
}
