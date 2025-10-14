package javaVersionFeatures.otherversions;

// preview feature in Java 14 and finalized in Java 16
//Pattern Matching for instanceof (Java 16+)
class Animal {
}

class Dog extends Animal {
}


public class InstanceOf {

    public static void main(String[] arg) {
        Animal a = new Dog();

        System.out.println(a instanceof Dog);     // true
        System.out.println(a instanceof Animal);  // true
        System.out.println(a instanceof Object);  // true
        //  System.out.println(a instanceof String);  // false (compile-time error)


        //OLD WAY
        if (a instanceof Dog) {
            Dog d = (Dog) a;
            System.out.println("Dog instance old way" + d);
        }

        //NEW WAY
        if (a instanceof Dog d) {
            System.out.println("Dog instance new way" + d);
        }
    }
}
