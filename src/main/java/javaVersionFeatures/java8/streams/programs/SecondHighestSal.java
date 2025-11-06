package javaVersionFeatures.java8.streams.programs;

import beans.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

//Find employee with second-highest Salary
public class SecondHighestSal {

    public static void main(String[] args) {

        record Employee(String name, String department, double salary){}

        List<Employee> empList = Arrays.asList(
                new Employee("A", "HR",2000),
                new Employee("B", "Finance",3000),
                new Employee( "C", "IT",4000),
                new Employee( "P", "Finance",4000),
                new Employee( "D", "HR",5000),
                new Employee( "Z", "IT",5000));


        //Approach 2-----------------------------------------------------------------------------------
        List<Employee> empListSecondHighestSal = empList.stream()
                .collect(Collectors.groupingBy(Employee::salary))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry<Double, List<Employee>>::getKey).reversed())
                .skip(1)
                .map(entry -> entry.getValue())
                .findFirst()
                .get();

        System.out.println("[Approach 2] emplist with second highest sal  = "+ empListSecondHighestSal);


        //Approach 1------------------------------------------------------------------------------
        double secondHighest = empList.stream()
                .map(Employee::salary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No second highest salary found"));

        List<Employee> secondHighestEmployees = empList.stream()
                .filter(e -> e.salary() == secondHighest)
                .collect(Collectors.toList());

        System.out.println("[Approach 1] emplist with second highest sal  = "+ secondHighestEmployees);
        /*secondHighestEmployees.forEach(e ->
                System.out.println(e.getName() + " -> " + e.getSalary()));*/
    }
}
