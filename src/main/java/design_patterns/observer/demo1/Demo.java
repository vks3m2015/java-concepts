package design_patterns.observer.demo1;

import concepts.design_patterns.observer.demo1.Editor;
import concepts.design_patterns.observer.demo1.EmailNotificationListener;
import concepts.design_patterns.observer.demo1.LogOpenListener;

public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open",
                new LogOpenListener("/path/to/log/file.txt"));

        editor.events.subscribe("save",
                new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
