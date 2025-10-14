package javaVersionFeatures.java8.streams;

import beans.Employee;

import java.util.*;

public class StreamPractice {
    static void commonElements() {
        //list1 = {1,2,3,4,5}
        //list2 = {3,4,5,6,7}
        //Find out the common elements from the two lists (O/P - 3,4,5)

        Integer[] arr1 = {1,2,3,4,5};
        Integer[] arr2 = {3,4,5,6,7};


       // System.out.println("common elements" + set);

    }

    static void occuranceOfChars() {
        String str = "I am a human being";
        str = "Programming";

        //  System.out.println(" map = "+ countMap);
    }

    static void occuranceOfElements(){
        List<Integer> list = Arrays.asList(1, 3,5,1,4,3);



        // System.out.println(countMap);
        //Output -> 1=2, 3=2, 4=1, 5=1}
    }


    static void topkOccurigWords() {
        String str = "the day is sunny day is sunny sunday sunny ";

        String[] strArr = str.split("\\s");


        // System.out.println("Top 3 occuring words = " + map);

    }

    //to complete
    static void studentsHavingMaxMarksPerSection() {
        /*List<Student> students = List.of(
                new Student(90, "A", "1", List.of(12,8)),
                new Student(80, "B", "1", List.of(11,9)),
                new Student(75, "C", "1", List.of(10,6)),
                new Student(93, "P", "2", List.of(6,8)),
                new Student(70, "Q", "2", List.of(8,10)),
                new Student(75, "X", "3", List.of(3,2)),
                new Student(75, "Y", "3", List.of(4,5))
        );*/




        // System.out.println(st);


    }

    static void sortMapByValue() {

        Map<String, Integer> budget = new HashMap<>();
        budget.put("clothes", 120);
        budget.put("grocery", 150);
        budget.put("transportation", 100);
        budget.put("utility", 130);
        budget.put("rent", 1150);
        budget.put("miscellneous", 90);

        System.out.println(" map = "+budget);

        //Ascending Order

        // System.out.println(" sorted map = "+ sortedBudget);

        //Descending Order

        // System.out.println(" reversed sorted map = "+ sortedBudgetReversed);


    }

    static void findSecondHighestSalaryEmployeeName() {
        List<Employee> empList = Arrays.asList(
                new Employee(222, "A", 2000, "Knp", "UP"),
                new Employee(111, "B", 3000, "Knp", "UP"),
                new Employee(333, "C", 3500, "Pune", "MH"),
                new Employee(333, "P", 3500, "Pune", "MH"),
                new Employee(123, "D", 3700, "Mumbai", "MH"),
                new Employee(123, "Z", 3700, "Mumbai", "MH"));

        //multiple employees having same salary (this will not work in that case)


        // System.out.println(" 2nd Highest Salary Employee name = "+name); //Z



        //  System.out.println(" 2nd Highest Salary Employee name.... = "+em);  //C,P

    }

    static void firstSortSalaryThenName() {
        List<Employee> empList = Arrays.asList(
                new Employee(222, "A", 5000.50),
                new Employee(111, "C", 3000.40),
                new Employee(333, "B", 3000.40),
                new Employee(123, "A", 3700));




        //  System.out.println(" sorted : "+sorted);


    }

    //Find duplicate elements
    static void prog5() {
        List<Integer> list = Arrays.asList(2,10,2,5,15,10,2);


        // System.out.println("duplicates" + duplicates);

        //Method - 2


        //System.out.println("duplicates2" + duplicates2);


    }

    static void prog_removeDuplicates(){
        List<String> list = Arrays.asList("Java", "C", "Python", "C", "Java", "Go");



        // System.out.println(distinctList);
        //Output -> [Java, C, Python, Go]
    }

    //find max/min
    static void prog6() {
        List<Integer> list = Arrays.asList(2,10,2,5,15,10,2);

        //  int max =

        //int min =

        // System.out.println("max = "+ max + " min = "+ min);
    }

    //Sort list
    static void prog7() {
        List<Integer> list = Arrays.asList(2,10,2,5,15,10,2);


        //  System.out.println("sortAsc = "+sortAsc);


        // System.out.println("sortDesc = "+sortDesc);

    }

    //limit skip
    static void prog8() {
        List<Integer> list = Arrays.asList(2,10,2,5,15,10,2);





    }

    //Find Second lowest/highest number
    static void prog9() {


        List<Integer> list = Arrays.asList(2,10,2,5,15,10,2);



        // System.out.println(" Second highest num = "+ secLargest);



        //System.out.println(" Second lowest num = "+ secL);


    }

    static void maxNElements(){
        List<Integer> list = Arrays.asList(2,10,2,5,15,10,2);



        // System.out.println(max3);
        //Output -> [15, 10, 5]
    }

    static void minNElements(){
        List<Integer> list = Arrays.asList(2,10,2,5,15,10,2);


        // System.out.println(min3);
        //Output -> [2, 5, 10]
    }

    //Multiply elements of a list
    static void prog10() {
        List<Integer> list = Arrays.asList(2,10,2,5);
        // System.out.println(res);
    }

    //Square the integres and find average of those squares values that are less than 100
    static void prog4() {
        List<Integer> list = Arrays.asList(2,10,12,5,15);



        //   System.out.println(" avg = "+avg);

    }

    //average of odd integers from int list
    static void prog2() {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        // System.out.println(" average of "+list + "= "+ avg);
    }




    //Interview
    //from list of integers..create list that contains elements that start with number 1
    static void prog1() {

        List<Integer> list = Arrays.asList(10, 15, 5, 20, 25, 100);



        // System.out.println(list2);
    }

    static void prog3() {

        final class Employee{
            int id;
            int age;

            Employee(int id, int age){
                this.id = id;
                this.age = age;
            }
        }

        List<Employee> list = Arrays.asList(new Employee(123, 23), new Employee(345, 24), new Employee(567, 25));




        //System.out.println(sum);
        //System.out.println(sum2);

    }


    public static void main(String[] args) {
        // prog1();
        // prog2();
        // prog3();
        // prog4();
        // prog5();
        // prog6();
        // prog7();
        //prog8();
        prog9();
        //prog10();
        //findSecondHighestSalaryEmployeeName();
        //firstSortSalaryThenName();
        //sortMapByValue();
        //studentsHavingMaxMarksPerSection();
        //topkOccurigWords();
        //occuranceOfChars();
        //occuranceOfElements();
        //prog_removeDuplicates();
        //maxNElements();
        //minNElements();
        //commonElements();


    }
}
