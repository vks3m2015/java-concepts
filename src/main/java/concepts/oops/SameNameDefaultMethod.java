package concepts.oops;

interface IA{
    default void m(){
        System.out.println("default method m in interface IA");
    }
}

interface IB{
    default void m(){
        System.out.println("default method m in interface IB");
    }
}


public class SameNameDefaultMethod implements IA, IB{
    @Override
    public void m() {
        System.out.println("MUST NEED TO OVERRIDE this method as it is common in both interface");
        IA.super.m();
        // IB.super.m(); //or this
    }

    public static void main(String[] args) {

    }
}
