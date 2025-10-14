package javaVersionFeatures.java8.completableFuture;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class EmployeeRepository {
    static ObjectMapper mapper = new ObjectMapper();

    static String path = "C:\\Users\\Vikas Singh\\IdeaProjects\\java8features\\src\\main\\java\\com\\vik\\completableFuture\\employees.json";


    static List<Employee> fetchEmployees() {
        List<Employee> empList = null;
        try {
            empList = mapper.readValue(new File(path), new TypeReference<List<Employee>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return empList;
    }

    static void saveEmployee(){

    }
}
