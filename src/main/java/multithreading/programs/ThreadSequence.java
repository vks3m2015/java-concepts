package multithreading.programs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Print ABCABCABC... in sequence using 3 threads
public class ThreadSequence {

    public static void main(String[] args) {

        //Using wait() and notifyAll()
        Printer printer = new Printer(5); // print "ABC" 5 times
        Thread t1 = new Thread(printer::printA);
        Thread t2 = new Thread(printer::printB);
        Thread t3 = new Thread(printer::printC);
        t1.start();
        t2.start();
        t3.start();


        //Using ReentrantLock and Condition
       /* ABCPrinter printer2 = new ABCPrinter(5);
        new Thread(printer2::printA).start();
        new Thread(printer2::printB).start();
        new Thread(printer2::printC).start();*/
    }



    private static class Printer {
        private int state = 1; // 1 -> A, 2 -> B, 3 -> C
        private final int maxIterations;

        public Printer(int maxIterations) {
            this.maxIterations = maxIterations;
        }

        public synchronized void printA() {
            for (int i = 0; i < maxIterations; i++) {
                while (state != 1) {
                    try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
                }
                System.out.print("A");
                state = 2;
                notifyAll();
            }
        }

        public synchronized void printB() {
            for (int i = 0; i < maxIterations; i++) {
                while (state != 2) {
                    try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
                }
                System.out.print("B");
                state = 3;
                notifyAll();
            }
        }

        public synchronized void printC() {
            for (int i = 0; i < maxIterations; i++) {
                while (state != 3) {
                    try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
                }
                System.out.print("C");
                state = 1;
                notifyAll();
            }
        }
    }



    private static class ABCPrinter {
        private final Lock lock = new ReentrantLock();
        private final Condition conditionA = lock.newCondition();
        private final Condition conditionB = lock.newCondition();
        private final Condition conditionC = lock.newCondition();

        private int state = 1; // 1 -> A, 2 -> B, 3 -> C
        private final int maxIterations;

        public ABCPrinter(int maxIterations) {
            this.maxIterations = maxIterations;
        }

        public void printA() {
            for (int i = 0; i < maxIterations; i++) {
                lock.lock();
                try {
                    while (state != 1) conditionA.await();
                    System.out.print("A");
                    state = 2;
                    conditionB.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }

        public void printB() {
            for (int i = 0; i < maxIterations; i++) {
                lock.lock();
                try {
                    while (state != 2) conditionB.await();
                    System.out.print("B");
                    state = 3;
                    conditionC.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }

        public void printC() {
            for (int i = 0; i < maxIterations; i++) {
                lock.lock();
                try {
                    while (state != 3) conditionC.await();
                    System.out.print("C");
                    state = 1;
                    conditionA.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}








