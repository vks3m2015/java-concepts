package javaVersionFeatures.java8.streams.exceptionHandling;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

//https://www.baeldung.com/java-lambda-exceptions
public class ExceptionInLambda {

    public static void main(String[] args) {

        List<String> list = List.of("1", "2", "x", "3");

      /*  list.stream()
                .map(Integer::parseInt)   // ❌ throws NumberFormatException for "x"
                .forEach(System.out::println);
*/
        list.stream()
                .map(ExceptionInLambda::safeParse)
                .filter(Objects::nonNull)
                .forEach(System.out::println);


        list.stream()
                .map(usingWrapperFunction(Integer::parseInt ))
                .filter(Objects::nonNull)
                .forEach(System.out::println);




    }

    static Function<String, Integer> usingWrapperFunction(Function<String, Integer> function){
        return (s) -> {
            try {
                return function.apply(s);
            } catch (NumberFormatException e) {
                return null;
            }
        };
    }

    private static Integer safeParse(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
