package mcq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamProb {

    public static void main(String[] args) {
        whatIsOutput();   //Australia
        whatIsOutput2();   //Shape[name=S2, diameter=512.0]
    }

    static void whatIsOutput(){
        List<String> countries = Arrays.asList("Germany", "England", "China",
                "Denmark", "Brazil", "France", "Australia");

        Optional<String> countryName = countries.stream().reduce(
                (c1, c2) -> c1.length() > c2.length() ? c1 : c2
        );

        countryName.ifPresent(System.out::println);
    }

    static void whatIsOutput2(){
        record Shape(String name, double diameter) {}

        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Shape("S1", 286));  // Index 0
        shapes.add(new Shape("S2", 512));  // Index 1
        shapes.add(new Shape("S3", 268));  // Index 2
        shapes.add(new Shape("S4", 258));  // Index 3
        shapes.add(new Shape("S5", 431));  // Index 4
        shapes.add(new Shape("S6", 289));  // Index 5

        Shape s = shapes.stream().reduce(
                shapes.get(0), // Identity element (initial value)
                (a, b) -> a.diameter() > b.diameter() ? a : b
        );

        System.out.println(s);
    }


}
