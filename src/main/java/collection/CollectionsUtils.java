package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsUtils {




	public static void m(){
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");

		List<String> unmodList = Collections.unmodifiableList(list);
		List<String> newList = new ArrayList<>(list);
		System.out.println("newList ====="+ newList);
		System.out.println("unmodList ====="+ unmodList);

		Object[] objArr = list.toArray();
		System.out.println("objArr ====="+ objArr);


		list.add("4");
		System.out.println("newList2 ====="+ newList);
		System.out.println("unmodList2 ====="+ unmodList);


	}






	public static void main(String[] args) {
		
		List list =  Collections.emptyList();
		
		Collections.sort(list);

		m();
		

	}

}
