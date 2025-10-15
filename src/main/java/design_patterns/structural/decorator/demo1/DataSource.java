package design_patterns.structural.decorator.demo1;

public interface DataSource {
    void writeData(String data);

    String readData();
}
