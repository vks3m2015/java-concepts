package javaVersionFeatures.java8.streams.concepts;

import java.util.List;
import java.util.stream.Collectors;

//having list of strings - ["java", "spring"] print list of letters from all strings - [j, a, v, a, s, p, r, i, n, g]
public class FlatMap {

    public static void main(String[] args) {
       // example1();
        example2();

    }

    static void example1(){
        List<String> words = List.of("java", "spring");
        List<Character> charList = words.stream()
                .flatMap(str -> str.chars().mapToObj(in -> (char)in))
                .collect(Collectors.toList());

        System.out.println("charList = "+ charList);
    }

    //Give single list of mobile numbers of all users
    static void example2(){
        record User(String name, List<String> mobileNumbers){}
        List<User> users = List.of(
                new User("Alice", List.of("111", "222")),
                new User("Bob", List.of("333", "444")),
                new User("Charlie", List.of("555"))
        );

        List<String> mobileNumbers = users.stream()
                .flatMap(user -> user.mobileNumbers().stream())
                .toList();

        System.out.println("mobileNumbers = "+ mobileNumbers);
    }
}
