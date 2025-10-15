package multithreading.compleatblefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

// runAsync(), supplyAsync()
//Callbacks - thenApply(), thenAccept(), thenRun()
public class CompletableFutureExample {

    private static final Runnable runnableTask = () -> {

        try {
            Thread.sleep(1000L);
            System.out.println("Executing Runnable task." +
                    " Thread Name : "+ Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    };

    private static final Supplier<String> supplierTask = () -> {

        try {
            Thread.sleep(1000L);
            System.out.println("Executing Supplier task." +
                    " Thread Name : "+ Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Supplier Task Result";
    };

    static void runAsyncExample() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> cf = CompletableFuture.runAsync(runnableTask);
        cf.get();
        System.out.println("Statement after runnableTask CompletableFuture. Thread Name : "+ Thread.currentThread().getName());

    }

    static void supplyAsyncExample() throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(supplierTask);
        String result = cf.get();
        System.out.println("Result of supplyAsyncTask = "+result);
        System.out.println("Statement after supplierTask CompletableFuture. Thread Name : "+ Thread.currentThread().getName());

    }

    //thenApply() -> In :- Function
    static void supplyAsyncThenApplyExample() throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf
                = CompletableFuture.supplyAsync(supplierTask)
                .thenApply((message) -> {
                    return "Adding result of thenApply() "+ message;
                });
        String result = cf.get();
        System.out.println("Result of supplyAsyncTask = "+result);
        System.out.println("Statement after supplierTask CompletableFuture. Thread Name : "+ Thread.currentThread().getName());

    }

    //thenAccept() -> In :- Consumer
    static void supplyAsyncThenAcceptExample() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> cf
                = CompletableFuture.supplyAsync(supplierTask)
                .thenAccept((message) -> {
                    System.out.println( "ThenAccept message :  "+ message);
                });
        cf.get();
        //System.out.println("Result of supplyAsyncTask = "+result);
        System.out.println("Statement after supplierTask CompletableFuture. Thread Name : "+ Thread.currentThread().getName());

    }

    //thenRun() -> In :- Runnable
    static void supplyAsyncThenRunExample() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> cf
                = CompletableFuture.supplyAsync(supplierTask)
                .thenRun(() -> {
                    System.out.println( "Executing thenRun() method task ");
                });
        cf.get();
        //System.out.println("Result of supplyAsyncTask = "+result);
        System.out.println("Statement after calling blocking get() method. Thread Name : "+ Thread.currentThread().getName());

    }

    public static void main( String[] args ) throws ExecutionException, InterruptedException {
        System.out.println( "Hello World!...." );
        // runAsync2wqExample();
        //supplyAsyncExample();
        //supplyAsyncThenApplyExample();
        // supplyAsyncThenAcceptExample();
        supplyAsyncThenRunExample();
    }

}
