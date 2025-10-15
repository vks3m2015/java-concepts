package multithreading.compleatblefuture;


import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExceptionHandling {

    public static void main(String[] args)
            throws InterruptedException, ExecutionException {
        usingExceptionally();
        usingHandle();
        usingWhenComplete();
    }

    private static void usingExceptionally() throws InterruptedException, ExecutionException {

        CompletableFuture<Integer> numberFuture
                = CompletableFuture.supplyAsync(() -> {
            //Processing
            throw new RuntimeException("Exception Occured while "
                    + "generating Number");
        });

        CompletableFuture<Integer> exceptionally
                = numberFuture.exceptionally(exception -> {
            System.err.println("Exceptionally EXCEPTION: " + exception.getMessage());
            return -1;
        });

        System.out.println("Future Number: " + exceptionally.get());
    }

    private static void usingHandle() throws InterruptedException, ExecutionException {

        CompletableFuture<Integer> numberFuture = CompletableFuture.supplyAsync(
                () -> {
            //Processing
            throw new RuntimeException("Exception Occured while "
                    + "generating Number");
        });

        CompletableFuture<Integer> handle
                = numberFuture.handle((response, exception) -> {
            if (Objects.nonNull(exception)) {
                System.err.println("Handle EXCEPTION: " + exception.getMessage());
                return -1;
            } else {
                return response;
            }
        });

        System.out.println("Future Number: " + handle.get());
    }

    private static void usingWhenComplete() {
        CompletableFuture<Integer> numberFuture = CompletableFuture.supplyAsync(() -> {
            //Processing
            throw new RuntimeException("Exception Occured while "
                    + "generating Number");
        });

        numberFuture.whenComplete((response, exception) -> {
            if (Objects.nonNull(exception)) {
                System.err.println("WhenComplete EXCEPTION: " + exception.getMessage());
            } else {
                System.out.println(response);
            }
        });
    }
}
