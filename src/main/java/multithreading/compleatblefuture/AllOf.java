package multithreading.compleatblefuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;

public class AllOf {

    public static void main( String[] args ) throws ExecutionException, InterruptedException {
        wheAllFutureComplete();
    }
    private static List<String> osList
            = List.of("RHEL", "Ubuntu", "Fedora", "Kali",
            "Debian", "Linux-Mint");

    private static void wheAllFutureComplete()
            throws InterruptedException, ExecutionException, ExecutionException {

        List<String> listOfServers = List.of("server1", "server2",
                "server3", "server4", "server5");

        List<CompletableFuture<String>> osDetailsFuture = listOfServers.stream()
                .map(server -> getOSDetails(server))
                .toList();

        CompletableFuture<Void> allOSFutureComplete = CompletableFuture
                .allOf(osDetailsFuture.toArray(CompletableFuture[]::new));

        CompletableFuture<List<String>> finalOSFuture
                = allOSFutureComplete.thenApply(future -> {
            return osDetailsFuture.stream()
                    .map(osFuture -> osFuture.join())
                    .toList();
        });

        System.out.println(finalOSFuture.get());
    }
    private static CompletableFuture<String> getOSDetails(String server) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + ": Connecting to " + server);

            System.out.println(Thread.currentThread().getName() + ": Executing Command in " + server);

            sleep(ThreadLocalRandom.current().nextLong(500, 1000));

            return server + " : " + osList.get(ThreadLocalRandom.current()
                    .nextInt(0, 4));
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
