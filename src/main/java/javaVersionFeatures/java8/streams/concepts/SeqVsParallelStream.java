package java8.streams.concepts;

import java.util.Arrays;
import java.util.List;

//https://www.baeldung.com/java-when-to-use-parallel-stream
public class SeqVsParallelStream {

    public static void main(String[] args) {

       /* List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
        listOfNumbers.stream().forEach(number ->
                System.out.println(number + " " + Thread.currentThread().getName())
        );*/
        /* Output   //Ordered
        1 main
        2 main
        3 main
        4 main
         */


        List<Integer> listOfNumbers2 = Arrays.asList(1, 2, 3, 4);
        listOfNumbers2.parallelStream().forEach(number ->
                System.out.println(number + " " + Thread.currentThread().getName())
        );

        /* Output Order is not predictable

        2 ForkJoinPool.commonPool-worker-1
        3 main
        1 ForkJoinPool.commonPool-worker-2
        4 ForkJoinPool.commonPool-worker-3
         */
    }
}
