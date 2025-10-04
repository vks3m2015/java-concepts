package static_methods;

interface Parent1 {
    static void greet() {
        System.out.println("Hello from parent");
    }
}

class Child1 implements Parent1 {
}


public class StaticMethodsInInterface {

    public static void main(String[] args) {
        Parent1.greet();     // ✅ OK
       // Child1.greet();      //Compilation error
    }
}
