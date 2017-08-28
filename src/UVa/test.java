package UVa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class test {

	public static void main(String[] args) {

		TreeMap<Integer, HashSet<String>> hm = new TreeMap<Integer, HashSet<String>>();
		
		HashSet<String> hs = new HashSet<String>();
		
		hs.add("aa");
		hs.add("bb");
		hs.add("");
		hm.put(hm.size(), hs);
		
		hs = new HashSet<String>();
		hs.add("cc");
		hm.put(hm.size(), hs);
		
		Set<Integer> set = hm.keySet();
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			int key = it.next();
			System.out.println(key);
		}
		
		hm.remove(0);
		
		Set<Integer> set2 = hm.keySet();
		Iterator<Integer> it2 = set2.iterator();
		while(it2.hasNext()) {
			int key = it2.next();
			System.out.println(key);
		}
	}
}
