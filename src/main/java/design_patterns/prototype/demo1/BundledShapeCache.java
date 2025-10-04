package design_patterns.prototype.demo1;

import concepts.design_patterns.prototype.demo1.Circle;
import concepts.design_patterns.prototype.demo1.Rectangle;
import concepts.design_patterns.prototype.demo1.Shape;

import java.util.HashMap;
import java.util.Map;

public class BundledShapeCache {
    private Map<String, concepts.design_patterns.prototype.demo1.Shape> cache = new HashMap<>();

    public BundledShapeCache() {
        concepts.design_patterns.prototype.demo1.Circle circle = new Circle();
        circle.x = 5;
        circle.y = 7;
        circle.radius = 45;
        circle.color = "Green";

        concepts.design_patterns.prototype.demo1.Rectangle rectangle = new Rectangle();
        rectangle.x = 6;
        rectangle.y = 9;
        rectangle.width = 8;
        rectangle.height = 10;
        rectangle.color = "Blue";

        cache.put("Big green circle", circle);
        cache.put("Medium blue rectangle", rectangle);
    }

    public concepts.design_patterns.prototype.demo1.Shape put(String key, concepts.design_patterns.prototype.demo1.Shape shape) {
        cache.put(key, shape);
        return shape;
    }

    public Shape get(String key) {
        return cache.get(key).clone();
    }
}