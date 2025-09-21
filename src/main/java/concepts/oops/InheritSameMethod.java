package concepts.oops;

interface InA{
    int m();
   // String m2();
}

interface InB{
    int m();
   // Double m2();
}


public class InheritSameMethod implements InA, InB{

    @Override
    public int m() {
        System.out.println("CAN inherit method common in both interface with same name and same return type");
        return 0;
    }

    /*@Override
    public String m2() {
        System.out.println("Compilation error");
        System.out.println("Can't inherit method common in both interface with same name but different return type");
        return "";
    }*/


    public static void main(String[] args) {
    }
}
