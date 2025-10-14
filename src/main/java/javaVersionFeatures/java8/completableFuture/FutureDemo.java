package javaVersionFeatures.java8.completableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static javaVersionFeatures.java8.completableFuture.EmployeeRepository.saveEmployee;


public class FutureDemo {

    public static void main( String[] args ) throws ExecutionException, InterruptedException {

        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<?> f = es.submit(() -> {
            //pool-1-thread-1
            System.out.println(" Thread name = "+ Thread.currentThread().getName());
            saveEmployee();
        });
        f.get();
    }
}
