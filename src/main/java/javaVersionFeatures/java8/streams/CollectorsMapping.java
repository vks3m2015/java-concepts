package javaVersionFeatures.java8.streams;

import beans.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsMapping {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "CAV"),
                new Employee(2, "Bob", "ACC"),
                new Employee(3, "Charlie", "INFO"),
                new Employee(4, "David", "TCS")
        );

        Map<String, List<String>> departmentEmployeeNames = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getName,
                        Collectors.mapping(Employee::getCompany, Collectors.toList())
                ));

        System.out.println(departmentEmployeeNames);
    }
}
