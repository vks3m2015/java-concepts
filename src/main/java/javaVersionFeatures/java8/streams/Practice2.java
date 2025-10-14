package javaVersionFeatures.java8.streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice2 {

    //Find top N occurring words in a Sentence
    public static void main(String[] args) {
        String str = "the day is sunny day is sunny sunday sunny ";

        Arrays.stream(str.split("\\s+"));

        Map<String, Long> map =
        Stream.of(str.split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(( Map.Entry<String, Long> entry1, Map.Entry<String, Long> entry2)  -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(4)
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry :: getValue,
                        (k1, k2) -> k1,
                        LinkedHashMap::new));

        System.out.println(" map = "+ map);
    }
}
