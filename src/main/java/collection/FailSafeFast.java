package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeFast {

		static void failSafeCopyOnWriteArrList(){
			List<String> arrList = new CopyOnWriteArrayList<>();
			arrList.add("1");
			arrList.add("2");

			Iterator<String> itr =arrList.iterator();
			while (itr.hasNext()){
				String str = itr.next();
				System.out.println("failSafeCopyOnWriteArrList element -- "+ str);
				if(str.equals("2")){
					arrList.add("3");
				}
			}
			System.out.println("CopyOnWriteArrayList after iteration ==> "+ arrList);
		}

		static void failFastArrayListIterator(){
			List<String> arrList = new ArrayList<>();
			arrList.add("1");
			arrList.add("2");

			Iterator<String> itr =arrList.iterator();
			while (itr.hasNext()){
				String str = itr.next(); //ConcurrentModificationException
				System.out.println("failFastArrayListIterator element -- "+ str);
				if(str.equals("2")){
					arrList.add("3");
				}
			}
		}

		static void failFastArrayListForEach(){
			List<String> arrList = new ArrayList<>();
			arrList.add("1");
			arrList.add("2");

			for(String str : arrList){    //will throw ConcurrentModificationException
				System.out.println("element -- "+ str);
				if(str.equals("2")){
					arrList.add("3");
				}
			}
		}

		static void failSafeConcurrHashMap(){
			ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
			map.put("ONE", 1);
			map.put("TWO", 2);
			map.put("THREE", 3);

			Iterator<String> it = map.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				System.out.println("failSafeConcurrHashMap   key:value -- " + key+" : "+map.get(key));
				map.put("FOUR", 4);     //This will not be reflected in the Iterator
			}
			System.out.println("  map  ="+map);
		}

	    public static void main(String[] args) {

			//failFastArrayListForEach();
			//failFastArrayListIterator();
			//failSafeCopyOnWriteArrList();
			failSafeConcurrHashMap();


	    }    
	}

