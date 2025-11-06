package Apractice.stream;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//https://medium.com/@veenaraofr/java8-stream-api-commonly-asked-questions-about-employee-highest-salary-99c21cec4d98

//3. Find the count of male and female employees present in the organization.
//4.Find the count of male and female present in each department
//Find maximum age/oldest of employee in the organisation.
//43. Sort the employees salary in each department in descending order
//44. Find list of employees whose age is less than 30 in Department HR
public class StreamProgramsPrac {

    record Employee(String name, String department, double salary){}

    static List<Employee> empList = Arrays.asList(
            new Employee("A", "HR",2000),
            new Employee("B", "Finance",3000),
            new Employee( "C", "IT",4000),
            new Employee( "P", "Finance",4000),
            new Employee( "D", "HR",5000),
            new Employee( "Z", "IT",5000));

    record Invoice(String id, LocalDate date, double amount) {}

    public static void main(String[] args) {

    }

    //Find Max Salary per department
    static void maxSalPerDepartmet(){

        
    }

    //Second highest salary
    static void secondHighestSal(){

    }

    //Find second max salary per department
    static void secondMaxSalPerDepartment(){

    Map<String, Double> map =
        empList.stream().collect(Collectors.groupingBy(
               Employee::department, Collectors.collectingAndThen( Collectors.toList(),
                        list -> list.stream()
                                .map(employee -> employee.salary)
                                .mapToDouble(sal -> sal)
                                .max()
                                .orElse(-1)

                )
        ));

    }

    //Find names of employees in each department
    static void employeeNamesPerDepartment(){

    }

    //case-insensitive
    static void findMostRepeatedWord(){
        String text = "apple BANANA Apple orange banana APPLE mango Banana";

    }

    static void findInvoiceSumForEachDate(){
        List<Invoice> invoices = List.of(
                new Invoice("INV001", LocalDate.of(2025, 10, 1), 500.0),
                new Invoice("INV002", LocalDate.of(2025, 10, 1), 300.0),
                new Invoice("INV003", LocalDate.of(2025, 10, 2), 200.0),
                new Invoice("INV004", LocalDate.of(2025, 10, 3), 100.0),
                new Invoice("INV005", LocalDate.of(2025, 10, 2), 700.0)
        );


    }

    //Find top 3rd occuring word
    static void topkOccurigWords() {
        String str = "the day is sunny day is sunny sunday sunny ";
    }
}
