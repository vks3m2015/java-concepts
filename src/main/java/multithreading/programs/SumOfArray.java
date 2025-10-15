package multithreading.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class SumOfArray {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        conventionalApproach();
        usingExecutor();
        parallelStream();
    }

    static void conventionalApproach() throws InterruptedException {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) arr[i] = i + 1; // fill 1 to 1000

        int numThreads = 4; // number of threads
        int chunkSize = arr.length / numThreads;
        SumTask[] threads = new SumTask[numThreads];

        // create and start threads
        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? arr.length : start + chunkSize;
            threads[i] = new SumTask(arr, start, end);
            threads[i].start();
        }

        // wait for all threads
        long totalSum = 0;
        for (SumTask t : threads) {
            t.join();
            totalSum += t.getPartialSum();
        }

        System.out.println("Total sum = " + totalSum);
    }


    static class SumTask extends Thread {
        private int[] arr;
        private int start, end;
        private long partialSum = 0;

        public SumTask(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                partialSum += arr[i];
            }
        }

        public long getPartialSum() {
            return partialSum;
        }
    }

    static void usingExecutor() throws ExecutionException, InterruptedException {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) arr[i] = i + 1;

        int numThreads = 4;
        int chunkSize = arr.length / numThreads;

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<Long>> results = new ArrayList<>();

        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? arr.length : start + chunkSize;

            Callable<Long> task = () -> {
                long sum = 0;
                for (int j = start; j < end; j++) {
                    sum += arr[j];
                }
                return sum;
            };

            results.add(executor.submit(task));
        }

        long totalSum = 0;
        for (Future<Long> f : results) {
            totalSum += f.get(); // wait for result
        }

        executor.shutdown();

        System.out.println("Total sum = " + totalSum);
    }

    //Use ForkJoinPool (Parallel Streams)
    static void parallelStream(){
        int[] arr = IntStream.rangeClosed(1, 1000).toArray();

        long sum = Arrays.stream(arr)
                .parallel()     // uses ForkJoinPool internally
                .sum();

        System.out.println("Total sum = " + sum);
    }
}
