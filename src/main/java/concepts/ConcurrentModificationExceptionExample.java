package concepts;

import java.util.*;

public class ConcurrentModificationExceptionExample {

	static void removeUsingItr(){
		//List<String> list = List.of("Noida", "Gurugram", "Kanpur"); //it creates immutable list

		List<String> list = new ArrayList<>();
		list.add("One");
		list.add("Two");
		list.add("Three");

		System.out.println("List before removal : "+ list);
		for(Iterator<String > itr = list.iterator(); itr.hasNext();  ){
			String element =  itr.next();
			//System.out.println("List Element : "+ element);
			if(element.equals("Two") ){
				itr.remove();
			}
		}
       System.out.println("List after removal : "+ list);
	}

	static void directStructuralModification(){
		List<String> list = new ArrayList<>();
		list.add("Noida");
		list.add("Gurugram");
		list.add("Kanpur");
		//It will throw ConcurrentModificationException by method next()
		for (String element : list) {
			System.out.println(" element = " + element);

			if (element.equals("Gurugram")) {
				list.remove("Gurugram");
				list.add("Gurgaon");
			}
		}
	}

	static void noStructuralModification(){
		List<StringBuilder> list = new ArrayList<>();
		list.add(new StringBuilder("Noida"));
		list.add(new StringBuilder("Gurugram"));
		list.add(new StringBuilder("Kanpur"));

		//It will not throw ConcurrentModificationException as we haven't change size
		// or Structurally modified list but modify elements itself.
		Iterator<StringBuilder> itrList = list.iterator();
		while(itrList.hasNext()) {
			StringBuilder element = itrList.next();
			element.append("City");
			System.out.println(" element = "+ element);
		}
		System.out.println("list ="+list);

	}

	public static void main(String[] args) {
		//removeUsingItr();
		//directStructuralModification();
		noStructuralModification();

		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Noida");
		map.put(2, "Gurugram");
		map.put(3, "Kanpur");
		

	}

}
