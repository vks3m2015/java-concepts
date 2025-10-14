package javaVersionFeatures.java8.streams;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CreatingStream {


    public static void main(String[] arg){

        //Arrays stream() method

        int[] intArr = {1,2,3,4,5};
        IntStream intStream = Arrays.stream(intArr);

        long[] longArr = {1,2,3,4,5};
        LongStream longStream = Arrays.stream(longArr);

        double[] doubles = {1.1, 2.3, 3.3, 4.4, 5.5};
        DoubleStream doubleStream = Arrays.stream(doubles);

        Character[] chars = {'1','2','3'};
        Stream<Character> characterStream = Arrays.stream(chars);

        //of method
        IntStream intStream1 = IntStream.of(1,2,2,3);
        LongStream longStream1 = LongStream.of(113, 121, 333);
        DoubleStream doubleStream1 = DoubleStream.of(1.22, 3.33, 1.9);
        Stream<String> stream = Stream.of("my", "name");




    }
}
