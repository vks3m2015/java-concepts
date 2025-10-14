package java8.streams.programs;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Find common elements between two arrays
public class CommonElements {

    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3, 4, 5};
        Integer[] arr2 = {4, 5, 6, 7, 8};

       // Stream<Integer> arr3 = Stream.of(arr1);

        // Convert arr2 to a Set for faster lookup
        Set<Integer> set2 = Arrays.stream(arr2).collect(Collectors.toSet());

        // Filter arr1 elements that exist in arr2
        List<Integer> common = Arrays.stream(arr1)
                .filter(set2::contains)
                .collect(Collectors.toList());

        System.out.println("Common elements: " + common);

        //If Arrays Contain Primitive Types------------------------------------------
        int[] ar1 = {1, 2, 3, 4, 5};
        int[] ar2 = {4, 5, 6, 7, 8};

        //Stream<Integer> arr3 = Stream.of(ar1);

        Set<Integer> st2 = Arrays.stream(ar2).boxed().collect(Collectors.toSet());

        List<Integer> comn = Arrays.stream(ar1)
                .boxed()
                .filter(st2::contains)
                .collect(Collectors.toList());

        System.out.println("Common elements: " + comn);


        //Works for Any Type (Strings, Objects, etc.)---------------------------------------
        String[] names1 = {"Alice", "Bob", "Charlie"};
        String[] names2 = {"Bob", "David", "Charlie"};

        List<String> commonNames = Arrays.stream(names1)
                .filter(name -> Arrays.asList(names2).contains(name))
                .collect(Collectors.toList());

        System.out.println(commonNames); // [Bob, Charlie]


    }
}
