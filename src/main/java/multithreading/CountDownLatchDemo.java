package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService es = Executors.newFixedThreadPool(3);

        CountDownLatch countDownLatch = new CountDownLatch(3);
        es.submit(new RunnableTask(countDownLatch));
        es.submit(new RunnableTask(countDownLatch));
        es.submit(new RunnableTask(countDownLatch));

        //Causes the current thread to wait until the latch has counted down to zero or unless the thread is interrupted.
        countDownLatch.await();

    }

    static class RunnableTask implements Runnable{

        private CountDownLatch countDownLatch;

        public RunnableTask(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {

            //startup task
            countDownLatch.countDown();
            //Continue with other operations
        }
    }


}
