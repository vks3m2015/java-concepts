package static_methods;


class Parent {
    static void greet() {
        System.out.println("Hello from parent");
    }
}

class Child extends Parent {
}

public class StaticMethodsInClass {

    public static void main(String[] args) {
        Parent.greet();     // ✅ OK
        Child.greet();      // ✅ Also OK,
    }
}
