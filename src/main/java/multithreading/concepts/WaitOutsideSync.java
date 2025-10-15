package multithreading.concepts;

public class WaitOutsideSync {

    //Exception in thread "main" java.lang.IllegalMonitorStateException:
    // current thread is not owner
    void m() throws InterruptedException {
        wait();
    }

    public static void main(String[] args) throws InterruptedException {
        WaitOutsideSync waitOutsideSync = new WaitOutsideSync();
        waitOutsideSync.m();
    }
}
