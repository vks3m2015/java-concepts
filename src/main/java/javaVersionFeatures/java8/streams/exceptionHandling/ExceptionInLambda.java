package javaVersionFeatures.java8.streams.exceptionHandling;

import java.util.List;
import java.util.Objects;

//https://www.baeldung.com/java-lambda-exceptions
public class ExceptionInLambda {

    public static void main(String[] args) {

        List<String> list = List.of("1", "2", "x", "3");

        list.stream()
                .map(Integer::parseInt)   // ❌ throws NumberFormatException for "x"
                .forEach(System.out::println);

        list.stream()
                .map(ExceptionInLambda::safeParse)
                .filter(Objects::nonNull)
                .forEach(System.out::println);




    }

    private static Integer safeParse(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
