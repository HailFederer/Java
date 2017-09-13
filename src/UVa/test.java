package UVa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class test {

	public static void main(String[] args) {

		HashSet<HashSet<String>> hm = new HashSet<HashSet<String>>();
		
		HashSet<String> hs = new HashSet<String>();
		
		hs.add("aa");
		hs.add("bb");
		hs.add("");
		hm.add(hs);
		
		hs = new HashSet<String>();
		hs.add("cc");
		hm.add(hs);
		
		hm.remove(hs);
		
		Iterator<HashSet<String>> it = hm.iterator();
		while(it.hasNext()) {
			
		}
		
	}
}
