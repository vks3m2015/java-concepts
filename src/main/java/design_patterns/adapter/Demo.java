package design_patterns.adapter;

/*
Imagine you have a Pen interface that defines a write() method, and your client code expects
to use objects that implement this Pen interface. You also have a PilotPen class (the Adaptee)
which has a mark() method, but does not implement the Pen interface. To use PilotPen with your
client code, you create an adapter
 */

// Target Interface
interface Pen {
    void write(String text);
}

// Adaptee (Service)
class PilotPen {
    void mark(String text) {
        System.out.println("PilotPen marks: " + text);
    }
}

// Adapter
class PilotPenAdapter implements Pen {
    PilotPen pp = new PilotPen(); // Composition

    @Override
    public void write(String text) {
        pp.mark(text); // Adapting the call
    }
}

// Client
public class Demo {
    public static void main(String[] args) {
        Pen p = new PilotPenAdapter();
        p.write("Hello Adapter!");
    }
}

