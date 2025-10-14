package hashMapConcepts;

import java.util.IdentityHashMap;
import java.util.Map;

/*
Unlike HashMap which uses the equals() method and hashCode() method for comparing keys,
IdentityHashMap relies on reference-equality (==).
This means two keys k1 and k2 are considered equal in an IdentityHashMap if and only if k1 == k2.
This applies to values as well if they are compared.
 */
public class IdentityHashMapExample {

    public static void main(String[] args) {

        Map<String, String> identityMap = new IdentityHashMap<>();

        String s1 = new String("hello");
        String s2 = new String("hello");
        String s3 = s1; // s3 refers to the same object as s1

        identityMap.put(s1, "value1");
        identityMap.put(s2, "value2"); // s2 is a different object than s1
        identityMap.put(s3, "value3"); // s3 is the same object as s1

        System.out.println("Size of IdentityHashMap: " + identityMap.size());
        System.out.println("Value for s1: " + identityMap.get(s1)); // Will be "value3"
        System.out.println("Value for s2: " + identityMap.get(s2)); // Will be "value2"

        // In a regular HashMap, s1 and s2 would be considered equal
        // and the map size would be 1, with the value for "hello" being "value2".
    }
}
