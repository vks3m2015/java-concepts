package design_patterns.observer.demo1;

import java.io.File;

public interface EventListener {
    void update(String eventType, File file);
}
