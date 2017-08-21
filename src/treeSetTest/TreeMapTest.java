package treeSetTest;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
		
		/*TreeMap<Integer, String> tMap = new TreeMap<Integer, String>();
		tMap.put(6, "Orange");
		tMap.put(5, "Apple");
		tMap.put(3, "Dog");
		tMap.put(10, "Individual");
		
		//NavigableSet<Integer> tSet = tMap.navigableKeySet();
		
		Set<Integer> tSet = tMap.keySet();
		
		Iterator<Integer> it = tSet.iterator();
		while(it.hasNext()) {
			System.out.println(tMap.get(it.next()));
		}*/

		TreeMap<String, Integer> tMap = new TreeMap<String, Integer>(new StrLenComparator());
		tMap.put("Orange", 6);
		tMap.put("Apple", 5);
		tMap.put("Dog", 3);
		tMap.put("Individual", 10);
		
		Set<String> tSet = tMap.keySet();
		
		Iterator<String> it = tSet.iterator();
		while(it.hasNext()) {
			System.out.println(tMap.get(it.next()));
		}
	}

}
