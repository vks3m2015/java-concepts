package javaVersionFeatures.java8.streams.programs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostRepeatedWord {

    public static void main(String[] args) {
         caseInsensitive();
         allTopFrequentWords();
    }

    static void caseInsensitive(){

        String text = "apple BANANA Apple orange banana APPLE mango Banana";

        String mostRepeated = Arrays.stream(text.toLowerCase().split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        System.out.println("Most repeated word: " + mostRepeated);

    }

    static void allTopFrequentWords(){
        String text = "apple BANANA Apple orange banana APPLE mango Banana";

        Map<String, Long> wordCount = Arrays.stream(text.toLowerCase().split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

       // wordCount.forEach((word, count) -> System.out.println(word + " → " + count));

        long maxCount = wordCount.values()
                .stream()
                .mapToLong(Long::longValue)
                .max()
                .orElse(0);

        List<String> mostFrequentWords = wordCount.entrySet().stream()
                .filter(e -> e.getValue() == maxCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Most repeated words: " + mostFrequentWords);

    }
}
