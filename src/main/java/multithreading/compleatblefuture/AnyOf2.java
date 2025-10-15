package multithreading.compleatblefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/*
Use Cases: anyOf() is useful when you need to proceed as soon as the first result becomes available, without
waiting for all other asynchronous operations to finish. For example, fetching data from multiple sources and
 using the first one that responds.

Result Type: It returns a CompletableFuture<Object> because the input CompletableFuture instances can have different
 return types. You will likely need to cast the result to the expected type if you know which future completed
 */

public class AnyOf2 {

    public static void main(String[] args) throws Exception {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3); // Simulate a long operation
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Result from Future 1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1); // Simulate a shorter operation
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Result from Future 2";
        });

        CompletableFuture<Object> anyOfFuture = CompletableFuture.anyOf(future1, future2);

        // This will print "Result from Future 2" because it completes first
        System.out.println(anyOfFuture.get());
    }
}
