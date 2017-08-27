package UVa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class test {

	public static void main(String[] args) {

		HashMap<Integer, HashSet<String>> hm = new HashMap<Integer, HashSet<String>>();
		
		HashSet<String> hs = new HashSet<String>();
		
		hs.add("aa");
		hs.add("bb");
		hs.add("");
		hm.put(hm.size(), hs);
		
		Set<Integer> set = hm.keySet();
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			HashSet<String> set2 = hm.get(it.next());
			set2.remove("aa");
		}
		
		Set<Integer> set2 = hm.keySet();
		Iterator<Integer> it2 = set2.iterator();
		while(it2.hasNext()) {
			HashSet<String> set3 = hm.get(it2.next());
			Iterator<String> it3 = set3.iterator();
			while(it3.hasNext()) {
				System.out.println(it3.next()+"11");
			}
		}
	}
}
