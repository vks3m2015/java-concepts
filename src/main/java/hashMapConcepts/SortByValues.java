package hashMapConcepts;

//https://www.journaldev.com/780/comparable-and-comparator-in-java-example --NEED TO DO

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SortByValues {

    static HashMap<Integer, String> hmap = new HashMap<Integer, String>();

    static {
        hmap.put(5, "A");
        hmap.put(11, "C");
        hmap.put(4, "Z");
        hmap.put(77, "Y");
        hmap.put(9, "P");
        hmap.put(66, "Q");
        hmap.put(0, "R");
    }

    public static void main(String[] args) {
        sortByValues();
        usingStream();
    }

    static void usingStream() {
        Map<Integer, String> map = hmap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (key1, key2) -> key1, LinkedHashMap::new));
        System.out.println(" sorted map using stream => "+ map);
    }

    static HashMap<Integer, String> sortByValues() {

        //Convert Set to List
        List<Map.Entry<Integer, String>> list = new LinkedList<Map.Entry<Integer, String>>(hmap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        //copying the sorted list in LinkedHashMap to preserve the insertion order
        HashMap<Integer, String> sortedHashMap = new LinkedHashMap<Integer, String>();
        for (Iterator<Map.Entry<Integer, String>> it = list.iterator(); it.hasNext(); ) {
            Map.Entry<Integer, String> entry = it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        System.out.println(" Sorted HashMap => " + sortedHashMap);
        return sortedHashMap;
    }
}