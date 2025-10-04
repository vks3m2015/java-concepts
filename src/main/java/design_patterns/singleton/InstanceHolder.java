package design_patterns.singleton;

public class InstanceHolder {
    public static void main(String[] args) {
        Singleton1 singleton = Singleton1.getInstance();
    }
}

class Singleton1 {

    private Singleton1(){}

    private static class SingletonHolder {
        private static Singleton1 instance = new Singleton1();
    }

    public static Singleton1 getInstance(){
          return SingletonHolder.instance;
    }
}
