package java8.streams.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* Classes - IntStream, DoubleStream, Stream
 * 
 */



public class IntegerStream {

	public static int findSumUsingStream(int[] array) {
	    return Arrays.stream(array)
				.sum();
	}
	
	public static int findSumUsingStream(Integer[] array) {
	    return Arrays.stream(array)
	      .mapToInt(Integer::intValue)
	      .sum();
	}
	
	public static double findAverageUsingStream(int[] array) {
        return Arrays.stream(array)
                .average()
                .orElse(Double.NaN);
	}

    //Find Second lowest/highest number
    static void prog9() {
        List<Integer> list = Arrays.asList(2,10,2,5,15,10,2);

        int secLargest = list.stream()
                .distinct()
                //.sorted(Collections.reverseOrder())
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();

        System.out.println(" Second highest num = "+ secLargest);

        int secL = list.stream()
                .sorted()
                .distinct()
                .skip(1)
                .findFirst()
                .get();

        System.out.println(" Second lowest num = "+ secL);


    }

    static void maxNElements(){
        List<Integer> list = Arrays.asList(2,10,2,5,15,10,2);

        List<Integer> max3 = list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(max3);
        //Output -> [15, 10, 5]
    }

    static void minNElements(){
        List<Integer> list = Arrays.asList(2,10,2,5,15,10,2);

        List<Integer> min3 = list.stream()
                .distinct()
                .sorted()
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(min3);
        //Output -> [2, 5, 10]
    }

    //Multiply elements of a list
    static void prog10() {
        List<Integer> list = Arrays.asList(2,10,2,5);
        int res = list.stream()
                .reduce((a,b) -> a*b)
                .get();
        System.out.println(res);
    }

    //Square the integres and find average of those squares values that are less than 100
    static void prog4() {
        List<Integer> list = Arrays.asList(2,10,12,5,15);

        double avg = list.stream()
                .map(num -> num * num)
                .filter(squNum -> squNum < 100)
                .mapToInt(squNum -> squNum)
                .average()
                .getAsDouble();

        System.out.println(" avg = "+avg);

    }

    //average of odd integers from int list
    static void prog2() {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        double avg = list.stream()
                .filter(e -> e%2 == 1)
                .mapToInt(e -> e.intValue())
                .average()
                .getAsDouble();

        //	reduce((e1, e2) -> e1 + e2).map(e -> e/2).get();
        System.out.println(" average of "+list + "= "+ avg);
    }


    //find max/min
    static void prog6() {
        List<Integer> list = Arrays.asList(2,10,2,5,15,10,2);

        int max = list.stream().max(Comparator.comparing(Integer :: valueOf)).get();
        // int max = list.stream().max(Integer::compareTo).get();

        int min = list.stream().min(Comparator.comparing(Integer :: valueOf)).get();
        //int min = list.stream().min(Integer::compareTo).get();

        System.out.println("max = "+ max + " min = "+ min);
    }

    //Sort list
    static void prog7() {
        List<Integer> list = Arrays.asList(2,10,2,5,15,10,2);

        List<Integer> sortAsc = list.stream().sorted().toList();

        System.out.println("sortAsc = "+sortAsc);

        List<Integer> sortDesc = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        System.out.println("sortDesc = "+sortDesc);

    }

    //limit skip
    static void prog8() {
        List<Integer> list = Arrays.asList(2,10,2,5,15,10,2);

        int sumFirstN = list.stream().limit(3).mapToInt(num -> num).sum();

        int sumFirstN2 = list.stream().limit(3).reduce((a,b) -> a+b).get();


        int sumSkippingN = list.stream().skip(3).reduce((a,b) -> a+b).get();



    }
	
	public static void main(String[] args) {
		
	
		int[] arr = {3,2,1,0,8,1};
		int[] arr1 = {3,1,1};
		
		//Find 3 distinct smallest number
		System.out.println("3 distinct smallest number...");
		IntStream.of(arr)
		         .distinct()
		         .sorted()
		         .limit(3)
		         .forEach(System.out :: println);
		
		//Filter Even Numbers
		System.out.println(" Even Numbers...");
		IntStream.of(arr)
		         .filter(num -> num % 2 == 0)  
		         .forEach(System.out :: println);
		
		System.out.println("After doubling each number..");
		IntStream.of(arr)
		         .map(num -> num * 2)
		         .forEach(System.out :: println);
		
		System.out.println("Min = "+IntStream.of(arr).min().getAsInt());
		System.out.println("Max = "+IntStream.of(arr).max().getAsInt());
		System.out.println("Avg = "+IntStream.of(arr).average().getAsDouble());
		         	
	}

}
 