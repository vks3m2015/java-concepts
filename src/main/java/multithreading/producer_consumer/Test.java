package multithreading.producer_consumer;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class Test {

    public static void main(String[] args) {

        ArrayList<String> queue = new ArrayList<>();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
       // producer.start();
        consumer.start();

    }
}



class Producer extends Thread{

    ArrayList<String> queue;

    Producer(ArrayList<String> queue){
        this.queue = queue;
    }


    public void run() {
        int i = 1;
        while (i<=20) {
            synchronized (this) {
                if (queue.size() == 5) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                queue.add("vikas - " +i);
                System.out.println(i +"elemet added in queue");
                i++;
                notify();
            }
        }
    }
}

class Consumer extends Thread{

    ArrayList<String> queue;


    Consumer(ArrayList<String> queue){
        this.queue = queue;
    }


    public void run() {
        int i = 0;
        while (i<=20) {
            synchronized (this) {
                if (queue.isEmpty()) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                String data = queue.remove(0);
                System.out.println("received data from queue = "+data);
                i++;

                notify();
            }
        }
    }

}

