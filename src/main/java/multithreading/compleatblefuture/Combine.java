package multithreading.compleatblefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;

public class Combine {



    static void independentFutures() throws ExecutionException, InterruptedException {
        CompletableFuture<Double> getWeight = CompletableFuture.supplyAsync( () -> {
            double randomWeight = ThreadLocalRandom.current().nextDouble(40, 120);
            System.out.println(" Returning Weight : "+ randomWeight);
            return randomWeight;
        });

        CompletableFuture<Double> getHeight = CompletableFuture.supplyAsync( () -> {
            double randomHeight = ThreadLocalRandom.current().nextDouble(100, 200)/100;
            System.out.println(" Returning Height : "+ randomHeight);
            return randomHeight;
        });

        //BMI = weight/height^2
        CompletableFuture<Double> calculateBMI = getHeight
                .thenCombine( getWeight, (height, weight) -> {
                      return weight / (height * height);
                } );

        System.out.println(" Calculate BMI : " + calculateBMI.get());

    }

    public static void main( String[] args ) throws ExecutionException, InterruptedException {
          independentFutures();
    }
}
