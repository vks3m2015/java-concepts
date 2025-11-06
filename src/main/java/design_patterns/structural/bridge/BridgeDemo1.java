package design_patterns.structural.bridge;
/*
You have two/multiple dimensions of change, and you don’t want them tightly coupled.
The pattern lets you “bridge” them with a layer of abstraction.

Suppose you are designing a system to draw Shapes like Circle and Square.
And these shapes can be drawn using different rendering APIs like OpenGL or DirectX.

If you try to handle all combinations directly, you might end up with classes like:

CircleWithOpenGL, CircleWithDirectX,
SquareWithOpenGL, SquareWithDirectX

→ That’s class explosion ❌

✅ Bridge Pattern Solution
You create two independent hierarchies:

1️⃣ Abstraction hierarchy (Shape)
Shape (abstract class)
Circle, Square (concrete abstractions)

2️⃣ Implementation hierarchy (Renderer)
Renderer (interface)
OpenGLRenderer, DirectXRenderer (implementations)

And you bridge them:
Shape holds a reference to a Renderer.

        Shape (Abstraction)
            |
    -------------------
    |                 |
Circle             Square
    |  has-a
    ↓
 Renderer (Implementor)
    |
 ---------------
 |             |
OpenGL      DirectX


⚙️ Real-world Example in Spring

Spring indirectly uses the Bridge pattern concept in many places — for example:

JpaRepository (Abstraction)
bridges to
JpaProvider (Implementation) like Hibernate, EclipseLink, etc.

So your code depends only on abstraction (JpaRepository), not the implementation (which provider
 is used under the hood).
 */
public class BridgeDemo1 {

    public static void main(String[] args) {
        Renderer openGL = new OpenGLRenderer();
        Renderer directX = new DirectXRenderer();

        Shape circle = new Circle(openGL);
        Shape square = new Square(directX);

        circle.draw();
        square.draw();
    }

    //----------------------------------------------------------
    interface Renderer {
        void renderShape(String shapeName);
    }

    static class OpenGLRenderer implements Renderer {
        public void renderShape(String shapeName) {
            System.out.println("Rendering " + shapeName + " using OpenGL");
        }
    }

    static class DirectXRenderer implements Renderer {
        public void renderShape(String shapeName) {
            System.out.println("Rendering " + shapeName + " using DirectX");
        }
    }

    //----------------------------------------------------------

    static abstract class Shape {
        protected Renderer renderer;

        public Shape(Renderer renderer) {
            this.renderer = renderer;
        }

        abstract void draw();
    }

    static class Circle extends Shape {
        public Circle(Renderer renderer) {
            super(renderer);
        }

        @Override
        void draw() {
            renderer.renderShape("Circle");
        }
    }

    static class Square extends Shape {
        public Square(Renderer renderer) {
            super(renderer);
        }

        @Override
        void draw() {
            renderer.renderShape("Square");
        }
    }
    //------------------------------------------------------------
}





