package javaVersionFeatures.java8.completableFuture;


import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static javaVersionFeatures.java8.completableFuture.EmployeeRepository.fetchEmployees;


public class RunAsyncDemo {

  public static void saveEmp() throws ExecutionException, InterruptedException {
      CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
          List<Employee> empList = fetchEmployees();
          System.out.println(" size = "+ empList.size());
          System.out.println(" Thread name = "+ Thread.currentThread().getName());
      });
      completableFuture.get();
  }

    public static void main( String[] args ) throws ExecutionException, InterruptedException {
        saveEmp();

    }
}
