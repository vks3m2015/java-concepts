package javaVersionFeatures.otherversions;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

//JDK 10
public class LocalVariableTypeInference {


    public static void main(String[] args) throws IOException {

        URL url = new URL("http://www.oracle.com/");
        URLConnection conn = url.openConnection();
        Reader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        //Above can be formated as
        //The type of the variables are inferred from the context
        var url2 = new URL("http://www.oracle.com/");
        var conn2 = url.openConnection();
        var reader2 = new BufferedReader(new InputStreamReader(conn.getInputStream()));


        List<String> myList = Arrays.asList("a", "b", "c");
        for (var element : myList) {}  // infers String

        try (var input = new FileInputStream("validation.txt")) {}   // infers FileInputStream




    }
}
