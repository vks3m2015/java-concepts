package multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(3);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        es.submit(new RunnableTask(cyclicBarrier));
        es.submit(new RunnableTask(cyclicBarrier));
        es.submit(new RunnableTask(cyclicBarrier));

        Thread.sleep(2000);


    }



    static class RunnableTask implements Runnable{

        CyclicBarrier cyclicBarrier;

        public RunnableTask(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {

            while(true) {
                try {
                    //Waits until all parties have invoked await on this barrier.
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
