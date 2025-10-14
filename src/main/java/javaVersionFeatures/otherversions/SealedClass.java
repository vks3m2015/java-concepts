package javaVersionFeatures.otherversions;

//Java 15 (preview) and finalized in Java 17
//A sealed class or interface restricts which other classes or interfaces may extend or implement it.
public class SealedClass {

    public static void main(String[] arg){
        Shape shape = new Circle(1);
        System.out.println(" Area of Circle = "+shape.area());

        Shape shape2 = new Rectangle(1, 1);
        System.out.println(" Area of Rectangle = "+shape2.area());
    }

//Sealed classes work exceptionally well with pattern matching for switch expressions.
// The compiler can perform exhaustive checks, ensuring that all possible permitted subclasses are handled,
// potentially eliminating the need for a default clause and leading to more robust and readable code
void processShape(Shape shape) {
    switch (shape) {
        case Circle c -> System.out.println("Processing Circle with radius: " + c.radius);
        case Rectangle r -> System.out.println("Processing Rectangle with width: " + r.width + ", height: " + r.height);
        // case Triangle t -> System.out.println("Processing Triangle with side1: " + t.side1() + ", side2: " + t.side2() + ", side3: " + t.side3());
    }
}
}

sealed abstract class Shape permits Circle, Rectangle {
    public abstract double area();
}

//sealed, non-sealed or final modifiers expected for child classes
final class Circle extends Shape {
    double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

//non-sealed subclass allows unrestricted extension
//This is useful when you want to control the initial set of implementations for an abstraction but
// allow for open-ended extensions of certain concrete types within that set
non-sealed class Rectangle extends Shape {
    double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

class Square extends Rectangle{

    public Square(double width, double height) {
        super(width, height);
    }
}

//Compilation error => 'Triangle' is not allowed in the sealed hierarchy
/*
final class Triangle extends Shape{

    @Override
    public double area() {
        return 0;
    }
}*/
