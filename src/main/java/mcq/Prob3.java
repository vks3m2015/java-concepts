package mcq;

//What will be the output??
public class Prob3 {
    public static void main(String[] args) {
        Subclass s1 = new Subclass();
        s1.foo(); // Line 7

        Super s = new Subclass();
        //Commented below due to compilation error
    //    s.foo(); // Line 10
    }
}

class Super {
    private void foo() {
        System.out.println("Super");
    }
}

class Subclass extends Super {

    /*
    In class Super, foo() is private.
    Private methods are not inherited by subclasses.
    Therefore, Subclass’s foo() is not overriding the one in Super; it’s a completely new method.
     */

    public void foo() {
        System.out.println("Subclass");
    }
}

