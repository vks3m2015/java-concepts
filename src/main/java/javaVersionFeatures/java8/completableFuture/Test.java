package java8.completableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService es = Executors.newFixedThreadPool(3);

        Future<List<Integer>> future = es.submit( () -> {
            System.out.println(" Thread name "+ Thread.currentThread().getName());
            //Suppose API call taking 30s to respond
            Thread.sleep(30 * 1000);
            return Arrays.asList(1,2,3,4);
        });

        System.out.println("list == "+ future.get());

        //future.cancel()

      //  CompletableFuture<String> cf = CompletableFuture.supplyAsync()

    }
}
