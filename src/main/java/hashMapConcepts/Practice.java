package hashMapConcepts;

import java.util.*;
import java.util.stream.Collectors;

public class Practice {

    public static void main(String[] args) {

        HashMap<Integer, String> hmap = new HashMap<Integer, String>();
        hmap.put(5, "A");
        hmap.put(11, "C");
        hmap.put(4, "Z");
        hmap.put(77, "Y");
        hmap.put(9, "P");
        hmap.put(66, "Q");
        hmap.put(0, "R");

       Map<Integer, String> map = hmap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (key1, key2) -> key1 , LinkedHashMap :: new));

        System.out.println(" map == "+ map);
    }
}
