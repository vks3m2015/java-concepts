package multithreading.compleatblefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Compose {

    static void dependentFutures() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> getRadius = CompletableFuture.supplyAsync( () -> 5);

        CompletableFuture<Double> calculateArea = getRadius.thenCompose( radius -> {
            return CompletableFuture.supplyAsync( () -> Math.PI * radius * radius);
        });

        System.out.println(" Area of Circle : "+ calculateArea.get());
    }

    public static void main( String[] args ) throws ExecutionException, InterruptedException {
        dependentFutures();
    }
}
