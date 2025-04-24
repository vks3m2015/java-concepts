package concepts;

public class FinallyWithReturn {

    static int show() {  //return 3
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }

    static int show2() {  //return 2
        try {
            return 1;
        } finally {
            return 2;
        }
    }

    static int show3() {  //return 2
        try {
            throw new NullPointerException();
        } finally {
            return 2;
        }
    }

    public static void main(String[] arg) {
        System.out.println(show());  //prints 3
        System.out.println(show2());  //print 2
        System.out.println(show3()); //prints 2


        final Integer[] array = {1, 2};
        System.out.println(array[0]);
        System.out.println(array[1]);
        array[0] = 10;
        System.out.println(array[0]);
    }

}
