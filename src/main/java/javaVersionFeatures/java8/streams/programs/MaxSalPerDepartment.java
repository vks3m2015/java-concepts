package java8.streams.programs;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


//find the maximum salary per department from a list of employees
public class MaxSalPerDepartment {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "HR", 60000),
                new Employee("Charlie", "IT", 90000),
                new Employee("David", "IT", 85000),
                new Employee("Eva", "Finance", 75000)
        );

        Map<String, Optional<Employee>> maxSalaryPerDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        //Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))
                ));

        // Print results
        maxSalaryPerDept.forEach((dept, emp) ->
                System.out.println(dept + " -> " + emp.get().getName() + " (" + emp.get().getSalary() + ")"));



        //If You Only Want Salary (Not the Employee Object)
        Map<String, Double> maxSalaryPerDept2 = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                opt -> opt.map(Employee::getSalary).orElse(0.0)
                        )
                ));

       /* maxSalaryPerDept2.forEach((dept, salary) ->
                System.out.println(dept + " -> " + salary));*/

    }




    private static class Employee {
        private String name;
        private String department;
        private double salary;

        // constructor, getters, setters
        public Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }

        public String getName() {
            return name;
        }
    }

}
