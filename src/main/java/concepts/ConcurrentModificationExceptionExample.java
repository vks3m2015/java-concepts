package concepts;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentModificationExceptionExample {

    public static void main(String[] args) {
        //removeUsingItr();
        //directStructuralModification();
        //noStructuralModification();
        directStructuralModificationAndExit();
        //failSafe();
    }


    static void removeUsingItr(){
		//List<String> list = List.of("Noida", "Gurugram", "Kanpur"); //it creates immutable list
		List<String> list = new ArrayList<>(List.of("One", "Two", "Three"));

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

    //It will throw ConcurrentModificationException by method next()
	static void directStructuralModification(){
		ArrayList<String> list = new ArrayList<>();
		list.add("Noida");
		list.add("Gurugram");
		list.add("Kanpur");

		for (String element : list) {
			System.out.println(" element = " + element);
			if (element.equals("Gurugram")) {
				list.remove("Gurugram");
				//list.add("Gurgaon");
			}
		}
	}

    //It will not throw ConcurrentModificationException by method next()
	static void directStructuralModificationAndExit(){
		ArrayList<String> list = new ArrayList<>();
		list.add("Noida");
		list.add("Gurugram");
		list.add("Kanpur");

		for (String element : list) {
			System.out.println(" element = " + element);
			if (element.equals("Gurugram")) {
				list.remove("Gurugram");
				break;
			}
		}
		System.out.println("List after modification - "+ list);
	}

    //It will not throw ConcurrentModificationException as we haven't change size
    // or Structurally modified list but modify elements itself.
	static void noStructuralModification(){
		List<StringBuilder> list = new ArrayList<>();
		list.add(new StringBuilder("Noida"));
		list.add(new StringBuilder("Gurugram"));
		list.add(new StringBuilder("Kanpur"));

		Iterator<StringBuilder> itrList = list.iterator();
		while(itrList.hasNext()) {
			StringBuilder element = itrList.next();
			element.append(" City");
			System.out.println(" element = "+ element);
		}
		System.out.println("list ="+list);
	}

	static void failSafe(){
		ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");

		Iterator<Integer> iterator = map.keySet().iterator();

		while (iterator.hasNext()) {
			Integer key = iterator.next();
			map.put(5, "Fifth");
		}
		System.out.println(" ConcurrentHashMap after modification - "+ map);
	}
}
