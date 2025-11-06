package javaVersionFeatures.java8.streams.concepts;

import java.util.List;

public class StringToCharStream {

    public static void main(String[] args) {

        String str = "java";

        List<Character> charList = str.chars()  //IntStream
                .mapToObj(in -> (char)in)
                .toList();

        System.out.println("Character stream -- charList == "+ charList);


         str.chars()  //IntStream
                .map(in -> (char) in) //IntStream
                .forEach(in -> System.out.println(in));

         /*
         This will print
         106
         97
         118
         97
          */


    }
}
