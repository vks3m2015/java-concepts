package concepts.oops;

import java.util.List;

public class SameMethodName {

    String method(int a){
        System.out.println();
        return "";
    }

    //NOT ALLOWED Only diff in RETURN TYPE
    /*Integer method(int a){
        System.out.println();
        return 1;
    }*/

    String method2(List<String> list){
        System.out.println();
        return "";
    }

    //NOT ALLOWED - same erasure
    /*String method2(List<Integer> list){
        System.out.println();
        return "";
    }*/




    public static void main(String[] args) {

    }
}
