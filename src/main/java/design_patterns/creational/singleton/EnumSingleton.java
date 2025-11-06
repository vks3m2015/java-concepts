package design_patterns.creational.singleton;

//Therefore, it is 100% guaranteed that only one instance of ENUM is present within a JVM
//Java enums are guaranteed to have only one instance per enum constant
//Constructor is by default private for ENUM
//Since enums are inherently serializable, we don't need to implement it with a serializable interface.
// The reflection problem is also not there

public enum EnumSingleton {
    INSTANCE; // The single instance of the enum

    private String configuration;

    //EnumSingleton(String str) {}

    // Private constructor to initialize any necessary data
    private EnumSingleton() {
        // This constructor is called only once when INSTANCE is initialized
        this.configuration = "Default Configuration";
        System.out.println("EnumSingleton constructor called.");
    }

    // Public method to access and modify the configuration
    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String config) {
        this.configuration = config;
    }

    // Example usage
    public static void main(String[] args) {
        EnumSingleton singleton1 = EnumSingleton.INSTANCE;
        EnumSingleton singleton2 = EnumSingleton.INSTANCE;

        System.out.println("Is singleton1 and singleton2 the same instance? " + (singleton1 == singleton2));

        singleton1.setConfiguration("New Configuration");
        System.out.println("Configuration from singleton1: " + singleton1.getConfiguration());
        System.out.println("Configuration from singleton2: " + singleton2.getConfiguration());
    }
}
