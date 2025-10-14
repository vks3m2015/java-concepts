package javaVersionFeatures.java8.completableFuture;


import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static javaVersionFeatures.java8.completableFuture.EmployeeRepository.fetchEmployees;


public class SupplyAsyncDemo {


   static CompletableFuture<List<Employee>> fetchEmployees1(){
       return CompletableFuture.supplyAsync( () -> {
          List<Employee> employeeList = fetchEmployees();
          //by default it uses fork-join thread pool
           System.out.println(" Thread name = "+ Thread.currentThread().getName());
          return employeeList;
       });
   }

    static CompletableFuture<List<Employee>> fetchEmployeesUsingProvidedThreadPool(){
        Executor executor = Executors.newCachedThreadPool();
        return CompletableFuture.supplyAsync( () -> {
            List<Employee> employeeList = fetchEmployees();
            System.out.println(" Thread name = "+ Thread.currentThread().getName());
            return employeeList;
        }, executor);
    }

    public static void main( String[] args ) throws ExecutionException, InterruptedException {
        CompletableFuture<List<Employee>> empListCompFuture = fetchEmployees1();
        System.out.println("empList size  "+ empListCompFuture.get().size());
    }
}
