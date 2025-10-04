package java_basic;

public class FinalizeDemo {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize() method of class FinalizeDemo called");
    }

    public static void main(String[] arg){
        FinalizeDemo fd = new FinalizeDemo();
        fd = null;
        System.gc();
    }
}
