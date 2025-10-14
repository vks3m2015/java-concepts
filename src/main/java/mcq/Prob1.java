package mcq;

import java.util.Set;
import java.util.TreeSet;

public class Prob1 {

    public static void main(String[] args) {
        exception();  //What will it print??
        /* Ans -
        Finally
        Divide by zero
         */

        set(); //What will it print //Ans - [2, 3]

        whatWillBeOutput1();




    }

    private static void whatWillBeOutput1() {
        int a = Integer.parseInt("300");
        Integer b = Integer.valueOf(300);
        Integer c = new Integer(300);
        System.out.println("a==b : " + (a==b));  //true
        System.out.println("b==c : " + (c==b));  //false



        Integer y = 127;
        Integer z = 127;
        System.out.println("y == z " +(y == z));  // true (cached)

        Integer p = 128;
        Integer q = 128;
        System.out.println("p == q " + (p == q)); //false (not cached)
    }

    public static void exception(){

        try {
            divide(10, 0);
        }catch (Exception e){
            System.out.println("Divide by zero");
        }

    }

    public static Integer divide(int a, int b){
        try{
            return a/b;
        }finally {
            System.out.println("Finally");
        }
    }

    public static void set(){
        Set<Integer> set = new TreeSet<>();
        set.add(3);
        set.add((int)3.0);
        set.add(2);
        set.add(new Integer(2));
        set.add(Integer.parseInt("2"));

        System.out.println(set);
    }
}
