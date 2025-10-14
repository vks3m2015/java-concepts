package java8.streams.programs;

import beans.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

//Find employee with second highest Salary
public class SecondHighestSal {

    public static void main(String[] args) {

        List<Employee> empList = Arrays.asList(
                new Employee(2, "A", 2000, "Knp", "UP"),
                new Employee(1, "B", 3000, "Knp", "UP"),
                new Employee(3, "C", 4000, "Pune", "MH"),
                new Employee(5, "P", 4000, "Pune", "MH"),
                new Employee(4, "D", 5000, "Mumbai", "MH"),
                new Employee(6, "Z", 5000, "Mumbai", "MH"));


        //Approach 2-----------------------------------------------------------------------------------
        List<Employee> empListSecondHighestSal = empList.stream()
                .collect(Collectors.groupingBy(Employee::getSalary))
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
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No second highest salary found"));

        List<Employee> secondHighestEmployees = empList.stream()
                .filter(e -> e.getSalary() == secondHighest)
                .collect(Collectors.toList());

        System.out.println("[Approach 1] emplist with second highest sal  = "+ secondHighestEmployees);
        /*secondHighestEmployees.forEach(e ->
                System.out.println(e.getName() + " -> " + e.getSalary()));*/




    }
}
