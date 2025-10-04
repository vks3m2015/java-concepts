package jvm_memory;

import java.util.ArrayList;
import java.util.List;

/*
Explanation of the Leak:
Static Field: The leakedObjects list is declared as static. Static fields belong to the class itself, not to any specific instance, and they persist in memory for the entire lifetime of the application (or until the classloader is unloaded, which is usually at application shutdown).

Continuous Object Creation and Referencing: The addObjectsToLeak() method enters an infinite while(true) loop. Inside this loop, new Object instances are continuously created.

Strong References: Each newly created Object is added to the leakedObjects list. This creates a strong reference from the leakedObjects list to each of these Object instances.

Garbage Collection Prevention: Because leakedObjects is a static field and holds strong references to all the Object instances, the garbage collector will never consider these Object instances as eligible for collection, even though they might not be actively used by other parts of the application.

Memory Exhaustion: Over time, as more and more Object instances are added to the leakedObjects list, the application's heap memory will be consumed, eventually leading to an OutOfMemoryError.
 */

//https://www.youtube.com/watch?v=1ksJpgk1HIc
//https://www.youtube.com/watch?v=ZYPa93q2zj8
public class MemoryLeakExample {

    // A static List that will hold references to objects
    private static List<Object> leakedObjects = new ArrayList<>();

    public void addObjectsToLeak() {
        while (true) {
            // Create a new object in each iteration
            Object obj = new Object();
            // Add the object to the static list, keeping a strong reference
            leakedObjects.add(obj);
            // Optional: Introduce a small delay to observe the leak more clearly
            /*try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }*/
        }
    }

    public static void main(String[] args) {
        MemoryLeakExample example = new MemoryLeakExample();
        example.addObjectsToLeak(); // This method will continuously add objects
    }
}