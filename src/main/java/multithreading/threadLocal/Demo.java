package multithreading.threadLocal;

public class Demo {



    public static void main(String[] args) {
        ThreadLocal<String> thLocal = new ThreadLocal<>();
        thLocal.set("Vikas");

        /*ThreadLocal<String> thLocal2 = new ThreadLocal<>();
        thLocal.set("Vikas2");*/

        Thread thread1 = new Thread(() -> {
            System.out.println("Inside Thread-1");
            System.out.println("1.ThreadLocal value inside [ Thread-1 ] thread = "+ thLocal.get());

            //this will value inside thread that called this method (Thread.currentThread())
            thLocal.set("Singh");
           // thLocal2.set("Singh2");
            System.out.println("2.ThreadLocal value inside [ Thread-1 ] thread = "+ thLocal.get());
           // System.out.println("3.ThreadLocal value inside [ Thread-1 ] thread = "+ thLocal2.get());

            //Thread.currentThread()


        }, "Thread-1");
        thread1.start();
        System.out.println("Inside Main thread");
        System.out.println("ThreadLocal value inside [ main ] thread = "+ thLocal.get());
    }

}
