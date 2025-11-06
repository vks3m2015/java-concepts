package javaVersionFeatures.java8.streams.concepts;

import java.util.Arrays;
import java.util.List;

//https://www.baeldung.com/java-when-to-use-parallel-stream
/*
Parallel stream should be used when we have large amount of data and having cpu bound operations

Sequential streams use a single thread to process the pipeline
A parallel stream divides the stream’s elements into multiple chunks and processes them in parallel using
 the ForkJoinPool (a thread pool that Java uses for parallel tasks).


The number of threads in the common pool is equal to (the number of processor cores -1).

parallel streams have overhead of managing multiple threads, memory locality, splitting
the source and merging the results. Sometimes the overhead of managing threads, sources and results is
a more expensive operation than doing the actual work

Splitting cost
splitting data in array is more efficient than splitting data in linkedlist in parallel stream

Merging cost
merge operations like grouping to sets or maps can be quite expensive in parallel stream

 */

public class SeqVsParallelStream {

    public static void main(String[] args) {

        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);

        listOfNumbers.stream().forEach(number ->
                System.out.println(number + " " + Thread.currentThread().getName())
        );
        /* Output   //Ordered
        1 main
        2 main
        3 main
        4 main*/


        listOfNumbers.parallelStream().forEach(number ->
                System.out.println(number + " " + Thread.currentThread().getName())
        );

        /* Output Order is not predictable
        2 ForkJoinPool.commonPool-worker-1
        3 main
        1 ForkJoinPool.commonPool-worker-2
        4 ForkJoinPool.commonPool-worker-3
         */

        listOfNumbers = Arrays.asList(1, 2, 3, 4);

        int sum = listOfNumbers.stream().reduce(5, Integer::sum);
        System.out.println(" sum using sequential stream = "+ sum); //15

        //The actual result might differ depending on the number of threads used in the common fork-join pool
        sum = listOfNumbers.parallelStream().reduce(5, Integer::sum);
        System.out.println(" sum using parallel stream = "+ sum); //30

        //Fix - 5 should be added outside of the parallel stream
        sum = listOfNumbers.parallelStream().reduce(0, Integer::sum) + 5;


    }
}
