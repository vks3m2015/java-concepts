package java8.streams.programs;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateElements {

    public static void main(String[] args) {

    }

    static void usingCollectionFrequency(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 2, 3, 5, 1);

        List<Integer> duplicates = list.stream()
                .filter(i -> Collections.frequency(list, i) > 1)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(duplicates);

    }

    static void usingSet(){
        int[] arr = {1, 2, 3, 4, 2, 3, 5, 1};

        Set<Integer> seen = new HashSet<>();
        List<Integer> duplicates = Arrays.stream(arr)
                .filter(num -> !seen.add(num)) // add returns false if element already exists
                .distinct()
                .boxed()
                .collect(Collectors.toList());

        System.out.println(duplicates);
    }

    static void usingGroupByAndCounting(){
        int[] arr = {1, 2, 3, 4, 2, 3, 5, 1};

        List<Integer> duplicates = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(duplicates);

        //For String
        String[] names = {"A", "B", "C", "A", "D", "B"};
        List<String> duplicatesStrings = Arrays.stream(names)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(duplicatesStrings);

    }

}
