package javaVersionFeatures.otherversions;

//JAVA-14
public class MeaningfulNPE {

    public static void main(String[] arg){
        Person1 p = new Person1(null, 30);
        System.out.println("person1 == " + p.name.toLowerCase());

        //Exception will be -
        //Exception in thread "main" java.lang.NullPointerException:
        //        Cannot invoke "String.toLowerCase()" because "p.name" is null

    }


}

class Person1{
    String name;
    int age;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


