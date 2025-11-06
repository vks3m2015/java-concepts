package javaVersionFeatures.java8.streams.concepts;

import java.util.stream.Stream;

/*
Stream.of() does not allow nulls.
Stream.ofNullable() allows null
 */
public class NullableStream {

    public static void main(String[] args) {

        Stream.ofNullable("A");   // → Stream containing "A"
        Stream.ofNullable(null);  // → Empty Stream

      //  Stream.of(null);  //NullPointerException

        //use case
        record User(String name){};

        User user = new User(null);

        Stream.ofNullable(user)
                .map(User::name)
               // .filter(n -> n.equals("a"))
                .forEach(System.out::println);

        Stream<String> stream = Stream.of(user)
                .map(User::name);
                //.forEach(System.out::println);

        System.out.println("stream== " + stream);

        stream.forEach( str -> System.out.println(str));


    }
}
