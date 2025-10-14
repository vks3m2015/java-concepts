package javaVersionFeatures.java8.streams;

import java.util.stream.Stream;

public class StringToCharStream {

    public static void main(String[] args) {
        String str = "Hello";

        Stream<Character> charStream = str.chars()   //IntStream
                .mapToObj(c -> (char) c);


        Stream<String> charStream2 = str.codePoints()
                .mapToObj(cp -> new String(Character.toChars(cp)));
                //.forEach(System.out::println);


    }
}
