package multithreading.compleatblefuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;

public class AnyOf {
    public static void main( String[] args ) throws ExecutionException, InterruptedException {
        whenAnyFeatureComplete();
    }

    private static void whenAnyFeatureComplete()
            throws ExecutionException, InterruptedException, ExecutionException {
        List<String> CDNServers = List.of("nam", "emea",
                "apac", "mx");

        List<CompletableFuture<String>> submitAllForContent
                = CDNServers.stream()
                .map(server -> getContent(server))
                .toList();

        CompletableFuture<Object> quickestContentCDN
                = CompletableFuture.anyOf(submitAllForContent
                .toArray(CompletableFuture[]::new));

        System.out.println(quickestContentCDN.get());
    }

    private static CompletableFuture<String> getContent(String cdn) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Content Request Received at " + cdn);
            sleep(ThreadLocalRandom.current()
                    .nextLong(500, 5000));
            return "Content Received from " + cdn;
        });
    }

    private static void sleep(Long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
