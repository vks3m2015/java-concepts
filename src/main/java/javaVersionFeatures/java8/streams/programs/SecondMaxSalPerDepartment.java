package javaVersionFeatures.java8.streams.programs;

import java.util.*;
import java.util.stream.Collectors;

public class SecondMaxSalPerDepartment {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 90000),
                new Employee("Bob", "IT", 95000),
                new Employee("Charlie", "IT", 87000),
                new Employee("David", "HR", 65000),
                new Employee("Eve", "HR", 70000),
                new Employee("Frank", "HR", 75000),
                new Employee("Grace", "Finance", 80000),
                new Employee("Heidi", "Finance", 78000),
                new Employee("Alex", "Finance", 80000)
        );

        Map<String, Optional<Employee>> secondHighestByDept = employees.stream()
                // Group employees by department
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        // For each department, sort by salary desc and skip the top one
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                        .skip(1)        // skip the top salary
                                        .findFirst()    // pick the next one
                        )
                ));

        secondHighestByDept.forEach((dept, emp) ->
                System.out.println(dept + " → " + emp.orElse(null))
        );

       //------------------------ remove duplicate salary

        Map<String, Optional<Double>> secondMaxPerDept =
                employees.stream().collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.mapping(Employee::getSalary, Collectors.toSet()),//Remove duplicate

                                salList -> salList.stream()
                                        .sorted(Comparator.reverseOrder())
                                        .skip(1)
                                        .findFirst()

                        )
                ));

        secondMaxPerDept.forEach((dept, sal) ->
                System.out.println(dept + " → " + sal.orElse(null))
        );

        //-------------------------------------



        //Get only salary not Employee
        Map<String, OptionalDouble> secondMaxSalary = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.mapping(Employee::getSalary, Collectors.toList()),
                                list -> list.stream()
                                        .sorted(Comparator.reverseOrder())
                                        .skip(1)
                                        .mapToDouble(Double::doubleValue)
                                        .findFirst()
                        )
                ));


    }


    private static class Employee {
        private String name;
        private String department;
        private double salary;

        public Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getName() { return name; }
        public String getDepartment() { return department; }
        public double getSalary() { return salary; }

        @Override
        public String toString() {
            return name + " (" + department + ", " + salary + ")";
        }
    }

}
