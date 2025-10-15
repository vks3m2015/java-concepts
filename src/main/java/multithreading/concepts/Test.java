package multithreading.concepts;

public class Test {



    public static void main(String[] args) {
       // boolean flag = false;
        boolean[] arr = {false};

        new Thread(() -> {
            System.out.println(" [ Thread 1 ]  flag = "+ arr[0]);
            arr[0] = true;

        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(" [ Thread 2 ]  flag = "+ arr[0]);
        }).start();

    }

}
