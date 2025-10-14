package java8.streams.programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import beans.Employee;

//TODO - https://stackoverflow.com/questions/63783027/how-to-group-and-aggregate-using-maxby-in-java-stream

public class StreamsPrograms {
	

	
	static void occuranceOfChars() {
		String str = "I am a human being";
		str = "Programming";
		//String[] spStr = str.split("");
		//System.out.println(Arrays.toString(spStr));
		//Arrays.stream(spStr);

        Map<Character, Long> countMap = str.chars()
				.mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	    System.out.println(" map = "+ countMap);
	}

	static void occuranceOfElements(){
		List<Integer> list = Arrays.asList(1, 3,5,1,4,3);
		Map<Integer, Long> countMap = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(countMap);
		//Output -> 1=2, 3=2, 4=1, 5=1}
	}
	 
	
	static void topkOccurigWords() {
		String str = "the day is sunny day is sunny sunday sunny ";
		
		String[] strArr = str.split("\\s");
		Comparator<String> strComp = (str1, str2) -> str1.compareTo(str2) ;
		Comparator<Map.Entry<String, Integer>> entryComp = (entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()) ;
		
		Map<String, Integer> map2 = new TreeMap<>(strComp);

		Map<String, Long> map = Stream.of(str.split("\\s"))      //Arrays.stream(str.split("\\s"))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream()
				.sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(3)
				// .map(entry -> entry.getKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (k1, k2) -> k1,
                        LinkedHashMap::new));
		System.out.println("Top 3 occuring words = " + map);
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
	    Map<String, Integer> sortedBudget = budget.entrySet().stream()
	    		.sorted(Map.Entry.comparingByValue())
	    		.collect(Collectors.toMap(Map.Entry :: getKey, Map.Entry :: getValue, (a,b) -> a,
                        LinkedHashMap:: new));
	    
	    System.out.println(" sorted map = "+ sortedBudget);
	    
	    //Descending Order
	    Map<String, Integer> sortedBudgetReversed = budget.entrySet().stream()
	    		.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
	    		.collect(Collectors.toMap(Map.Entry :: getKey, Map.Entry :: getValue, (a,b) -> a, LinkedHashMap:: new));
	    
	    System.out.println(" reversed sorted map = "+ sortedBudgetReversed);
	    
		
	}
	

	static void firstSortSalaryThenName() {
		List<Employee> empList = Arrays.asList(
				new Employee(222, "A", 5000.50),
				new Employee(111, "C", 3000.40), 
				new Employee(333, "B", 3000.40),
				new Employee(123, "A", 3700));
		
		
		List<Employee> sorted = empList.stream()
				///.sorted(Comparator.comparing( (Employee e) -> e.salary).thenComparing((Employee e) -> e.name))
				.sorted(Comparator.comparing( Employee :: getSalary).thenComparing(Employee :: getName	))

				.collect(Collectors.toList());
		
		System.out.println(" sorted : "+sorted);
		
		
	}
	

	static void prog_removeDuplicates(){
	   List<String> list = Arrays.asList("Java", "C", "Python", "C", "Java", "Go");

	   List<String> distinctList = list.stream()
			   .distinct()
			   .collect(Collectors.toList());

	   System.out.println(distinctList);
	   //Output -> [Java, C, Python, Go]
	}
	 



	
	
	
	
	//Interview
	//from list of integers..create list that contains elements that start with number 1
	static void prog1() {
       
        List<Integer> list = Arrays.asList(10, 15, 5, 20, 25, 100);
	
		List<Integer> list2 = list.stream()
				.filter(n -> String.valueOf(n).startsWith("1"))
				.collect(Collectors.toList());
		
		System.out.println(list2);
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
		
		int sum = list.stream()
				.filter(emp -> emp.age % 2 != 0)
				.map( emp -> emp.age * emp.age)
				.mapToInt(age2 -> age2.intValue())
				.sum();
		
		
		int sum2 = list.stream()
				.filter(emp -> emp.age % 2 != 0)
				.map( emp -> emp.age * emp.age)
				.reduce( (a,b) -> a+b)
				.get();
				
				
		System.out.println(sum);
		System.out.println(sum2);
		
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
         //prog9();
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

