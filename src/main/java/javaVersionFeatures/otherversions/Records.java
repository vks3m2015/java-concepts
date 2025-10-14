package javaVersionFeatures.otherversions;

//https://docs.oracle.com/en/java/javase/17/language/records.html
//Java-14
//immutable carriers for data
//Records are implicitly final and can't be extended
//Java automatically generates constructors, accessor methods, equals(), hashCode(), and toString() methods
record Person(String name, int age) {}

public class Records {
    public static void main(String[] args) {
        Person person = new Person("John Doe", 30);
        System.out.println(person.name()); // Accessor method
        System.out.println(person); // toString()
    }
}


//Java21
class RecordPatternMatching{

    void recordPatternMatch(){

      /*  Person obj = new Person("John Doe", 30);
        if (obj instanceof Person(String name, int age)) {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        }*/

    }

}
