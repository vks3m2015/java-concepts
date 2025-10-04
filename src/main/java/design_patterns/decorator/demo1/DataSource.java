package design_patterns.decorator.demo1;

public interface DataSource {
    void writeData(String data);

    String readData();
}
