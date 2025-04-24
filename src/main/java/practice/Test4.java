package practice;

public class Test4 {

    public static void main(String[] args) throws Exception {

        System.out.println("");
    }
}

class Parent{

    String p(String msg){
        System.out.println(msg) ;
        return "1";
    }
}

class Child extends Parent{

    String p(String msg){
        System.out.println(msg) ;
        return "msg";
    }
}