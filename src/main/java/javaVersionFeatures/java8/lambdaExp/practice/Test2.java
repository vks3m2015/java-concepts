package javaVersionFeatures.java8.lambdaExp.practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Test2 {


    public static void main(String[] args) {

        IntStream intStream = IntStream.of(1,2,4,6);
        DoubleStream doubleStream = DoubleStream.of(1.2, 3.455, 6.32, 433.12);
        //FloatStream floatStream = FloatStr



    }

    static void sortMapByValue() {

        Map<String, Integer> budget = new HashMap<>();
        budget.put("clothes", 120);
        budget.put("grocery", 150);
        budget.put("transportation", 100);
        budget.put("utility", 130);
        budget.put("rent", 1150);
        budget.put("miscellneous", 90);

        System.out.println(" map = "+budget);

        budget.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .collect(Collectors.toList())
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (o, o2) -> o, LinkedHashMap::new));



    }
}
