package mcq;

public class Prob2 {

    public static void main(String[] args) {

        /*
        parseInt("300") returns a primitive int value 300
        /it’s stored directly   On the stack  (inside the local variable table of the current method).
         */
        int a = Integer.parseInt("300");

        //This creates or returns an Integer object, which lives    on the heap.
        //Since 300 is outside the Integer cache range (-128 to 127), a new Integer object is created.
        //So b is a reference variable (stored on the stack) that points to that new Integer object on the heap
        Integer b = Integer.valueOf(300);

        /*
        So: a and b do not share the same memory location.
            a is a primitive (just bits on the stack).
            b is a reference to an object on the heap.
         */

        //Java unboxed b to its primitive value (300) before comparison,
        System.out.println(a == b);  //TRUE



    }
}
