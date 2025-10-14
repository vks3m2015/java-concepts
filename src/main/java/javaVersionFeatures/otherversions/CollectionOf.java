package javaVersionFeatures.otherversions;

import java.util.List;
import java.util.Map;
import java.util.Set;

//Java 9 to create immutable collections (Lists, Sets, and Maps)
public class CollectionOf {

    public static void main(String[] arg){

        List<String> fruits = List.of("Apple", "Banana", "Mango");
        System.out.println(fruits); // [Apple, Banana, Mango]

        Set<Integer> numbers = Set.of(1, 2, 3, 4);
        System.out.println(numbers); // [1, 2, 3, 4]

        Map<String, Integer> ages = Map.of("Alice", 30, "Bob", 25);
        System.out.println(ages); // {Alice=30, Bob=25}

        Map<String, String> countries = Map.ofEntries(
                Map.entry("US", "United States"),
                Map.entry("FR", "France"),
                Map.entry("JP", "Japan")
        );
        System.out.println(countries); // {US=United States, FR=France, JP=Japan}




    }

}
