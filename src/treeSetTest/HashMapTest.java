package treeSetTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {

		HashMap<Integer, String> hMap = new HashMap<Integer, String>();
		hMap.put(1, "탕웨이");
		hMap.put(2, "박보영");
		hMap.put(3, "이보영");
		
		Set<Integer> set = hMap.keySet();
		
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(hMap.get(it.next()));
		}
	}

}
