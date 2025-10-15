package multithreading.compleatblefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/*
Functionality:
It takes a variable number of CompletableFuture objects as arguments (varargs).
It returns a new CompletableFuture<Void> that completes when all of the input CompletableFuture instances have completed,
  regardless of whether they completed successfully or exceptionally.
If any of the input CompletableFutures complete exceptionally, the CompletableFuture returned by allOf() will
   also complete exceptionally, with a CompletionException wrapping the original exception.
The CompletableFuture<Void> returned by allOf() does not carry the results of the individual input futures.
To retrieve the results of the individual futures, you need to call get() or join() on each of them separately after
the allOf() future has completed.

Usage Scenario:
allOf() is particularly useful when you need to wait for a set of independent asynchronous tasks to finish before
proceeding with further operations. For example, if you initiate multiple network requests concurrently and need to
 process all their responses before continuing, allOf() can be used to achieve this.
 */

public class AllOf2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Result from Future 1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Result from Future 2";
        });

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2);

        // Wait for all futures to complete
        allFutures.join(); // Blocks until all futures are done

        // Retrieve individual results
        System.out.println(future1.get());
        System.out.println(future2.get());
    }
}
