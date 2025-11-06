package mcq;

/*
A static nested class does not load automatically when the parent class loads.
✅ It is loaded only when it is first used (referenced).

In Java, class loading follows the lazy loading principle —
a class is loaded into the JVM only when it’s actually needed (e.g., when
 you create an object or reference a static member).
 */
class NestedClass {
    public static void main(String[] args) {
        System.out.println("Program started");
        Outer o = new Outer();  // only references Outer

        //Output
        /*
        Program started
        Outer class loaded
         */
    }
}

class Outer {
    static {
        System.out.println("Outer class loaded");
    }

    static class Inner {
        static {
            System.out.println("Inner class loaded");
        }
    }
}

