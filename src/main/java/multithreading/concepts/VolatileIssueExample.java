package multithreading.concepts;

public class VolatileIssueExample {

    public static void main(String[] args) throws InterruptedException {
        Stopper stopper = new Stopper();

        Thread workerThread = new Thread(() -> stopper.runLoop());
        workerThread.start();

        Thread.sleep(100); // Give workerThread some time to start

        stopper.stopLoop(); // Signal to stop

        // The workerThread might not terminate as expected
        // if keepRunning is not volatile
    }
}

class Stopper {
    //this may cause visibility issue. Value changed by a thread might mot be visible to
    private boolean keepRunning = true; // Not declared volatile

    public void runLoop() {
        while (keepRunning) {
            // Do some work
            System.out.println("Inside while loop");
        }
        System.out.println("Loop stopped.");
    }

    public void stopLoop() throws InterruptedException {
      //  Thread.sleep(100);
        this.keepRunning = false;
        System.out.println("Stopping signal sent.");
    }
}
