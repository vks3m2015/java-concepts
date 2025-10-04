package design_patterns.decorator.demo1;

import concepts.design_patterns.decorator.demo1.DataSource;

public abstract class DataSourceDecorator implements concepts.design_patterns.decorator.demo1.DataSource {
    private concepts.design_patterns.decorator.demo1.DataSource wrapper;

    DataSourceDecorator(DataSource source) {
        this.wrapper = source;
    }

    @Override
    public void writeData(String data) {
        wrapper.writeData(data);
    }

    @Override
    public String readData() {
        return wrapper.readData();
    }
}