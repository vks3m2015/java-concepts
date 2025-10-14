package javaVersionFeatures.otherversions.record;

//https://docs.oracle.com/en/java/javase/17/language/records.html
public class Demo {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(4,5);
    }
}

  //Shortest way
record Rectangle(double length, double width) { }


//to explicitly declare the canonical constructor
/*record Rectangle(double length, double width) {
    public Rectangle(double length, double width) {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException(
                    String.format("Invalid dimensions: %f, %f", length, width));
        }
        this.length = length;
        this.width = width;
    }
}*/

//OR like this
/*record Rectangle(double length, double width) {
    public Rectangle {
        if (length <= 0 || width <= 0) {
            throw new java.lang.IllegalArgumentException(
                    String.format("Invalid dimensions: %f, %f", length, width));
        }
    }
}*/

//This concise declaration of a rectangle is equivalent to the following normal class
/*public final class Rectangle {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double length() { return this.length; }
    double width()  { return this.width; }

    // Implementation of equals() and hashCode(), which specify that two record objects are equal if they
    // are of the same type and contain equal field values.
    public boolean equals...
    public int hashCode...

    // An implementation of toString() that returns a string
    // representation of all the record class's fields,
    // including their names.
    public String toString() {...}
}*/

