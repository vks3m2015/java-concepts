package multithreading.practice;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Practice1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture.runAsync(() -> {
            System.out.println(" Runnable Task");
        }).thenApply( r -> {
            //r.
             return 10;
        }).get();
    }
}
