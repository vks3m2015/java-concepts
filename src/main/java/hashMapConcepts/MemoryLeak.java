package hashMapConcepts;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MemoryLeak {


    public static void main(String[] args) {
        memoryLeakDueToNotOverridingEqualsAndHashCode();
        memoryLeakDueToMutableKey();
    }


    /*
    instead of overwriting a single entry for "jon", the HashMap stores 100 separate Person objects, each with the name "jon".
    These objects remain in memory, leading to a memory leak as they are no longer actively used but are still referenced by the HashMap
     */
    static void memoryLeakDueToNotOverridingEqualsAndHashCode(){
        Map<Person, Integer> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(new Person("jon"), 1);
        }
        //if equals() and hashCode() not overridden
        System.out.println("Map size: " + map.size()); // Expected: 1, Actual: 100
    }

    /*
    The entry associated with the original state of key1 ("initialName") remains in the HashMap but becomes effectively unreachable and unremovable, leading to a memory leak as the HashMap holds a reference to an object that cannot be accessed or cleaned up
     */
    static void memoryLeakDueToMutableKey(){
        Map<MutableKey, String> map = new HashMap<>();

        MutableKey key1 = new MutableKey("initialName");
        map.put(key1, "Value for initialName");

        System.out.println("Size of map after putting key1: " + map.size()); // Output: 1
        System.out.println("Value retrieved using key1: " + map.get(key1)); // Output: Value for initialName

        // Modify the key AFTER it's been put into the map
        key1.setName("changedName");

        // Attempt to retrieve using the *original* key object (which has been mutated)
        System.out.println("Value retrieved using mutated key1: " + map.get(key1)); // Output: null (or incorrect value)

        // Attempt to retrieve using a NEW key with the original value
        MutableKey newKeyWithOriginalName = new MutableKey("initialName");
        System.out.println("Value retrieved using new key with original name: " + map.get(newKeyWithOriginalName)); // Output: null

        // The entry with "initialName" is still in the HashMap's internal structure,
        // but its hash code and equals method would now point to "changedName".
        // Attempting to remove it with either the mutated key or a new key with the original name will fail.
        map.remove(key1); // This will attempt to remove "changedName"
        map.remove(newKeyWithOriginalName); // This will attempt to remove "initialName" - but the actual key has changed

        System.out.println("Size of map after attempted removals: " + map.size()); // Output: 1 (the entry is still there)
    }




    static class Person{
        String name;
        public Person(String name) {
            this.name = name;
        }

/* @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }*/
    }

    static class MutableKey {
        private String name;

        public MutableKey(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int hashCode() {
            // A simple hashCode based on the name
            return name != null ? name.hashCode() : 0;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            MutableKey other = (MutableKey) obj;
            return name != null ? name.equals(other.name) : other.name == null;
        }
    }
}

