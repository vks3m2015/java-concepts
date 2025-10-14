package java8.streams.programs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Flatten2DArray {

    public static void main(String[] args) {

        int[][] arr = {{1, 2}, {3, 4}};

        List<Integer> l =
        Arrays.stream(arr)
                .flatMap( ar -> Arrays.stream(ar).mapToObj(e -> e))
                .collect(Collectors.toList());

        System.out.println(l);

//------------------------------------------------------------
        int[][] arr1 = {
                {1, 2, 3},
                {4, 5},
                {6, 7, 8, 9}
        };

        int[] flat = Arrays.stream(arr1)
                .flatMapToInt(Arrays::stream) // flatten each int[]
                .toArray();       // back to int[]

        System.out.println(Arrays.toString(flat));

        //-------------------------------------------------------------

        String[][] names = {
                {"Alice", "Bob"},
                {"Charlie"},
                {"David", "Eve"}
        };

        String[] flatNames = Arrays.stream(names)
                .flatMap(Arrays::stream)
                .toArray(String[]::new);

        System.out.println(Arrays.toString(flatNames));

    }
}
