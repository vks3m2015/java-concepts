package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserDemo {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);

        //can work both as CountDownLatch and CyclicBarrier
        Phaser phaser = new Phaser(3);

        es.submit(new Task(phaser));
        es.submit(new Task(phaser));
        es.submit(new Task(phaser));
    }

    static class Task implements Runnable{

        private Phaser phaser;

        public Task(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {

            phaser.arrive();
        }
    }
}
