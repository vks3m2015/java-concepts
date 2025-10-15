package multithreading.producer_consumer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        Runnable producer = () -> {

            for(int i = 1; i< 10; i++){
                try {
                    buffer.add(i);
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }


        };
        new Thread(producer).start();

        Runnable consumer = () -> {
            try {
                while (true) {
                    int data = buffer.read();
                    System.out.println(" data read from buffer = " + data);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        new Thread(consumer).start();


    }




}

class Buffer{

    private List<Integer> buffer = new ArrayList<>();
    //private List<Integer> buffer = new LinkedList<>();
    int capacity = 5;

    public synchronized void add(int element) throws InterruptedException {
        while(buffer.size() == capacity){
            wait();
        }
        buffer.add(element);
        System.out.println(element + " added in buffer");
        notify();
    }

    public synchronized int read() throws InterruptedException {
        while (buffer.isEmpty()){
            wait();
        }

        int element = buffer.remove(0);
        System.out.println(element +" read from buffer ");
        notify();
        return element;
    }
}
