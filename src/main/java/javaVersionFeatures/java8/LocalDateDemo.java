package javaVersionFeatures.java8;

import java.time.LocalDate;

//LocalDate introduced in java 8
public class LocalDateDemo {

    public static void main(String[] args) {

        String str = "13-09-2025"; // Exception
        str =  "2025-09-13";  //Correct
       // str = "13-SEP-2025";  //Exception

        LocalDate localDate = LocalDate.parse(str);

        //localDate.getYear();
        //localDate.getMonth();

        System.out.println(localDate);

    }
}
