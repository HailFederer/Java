package UVa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, HashSet<String>> hm = new HashMap<Integer, HashSet<String>>();
		
		HashSet<String> hs1 = new HashSet<String>();
		HashSet<String> hs = new HashSet<String>();
		hs1.add("기모2");
		hs1.add("기모");
		
		if(hs1.contains("기모")){
			System.out.println("-------------");
		}
		
		hm.put(3, hs1);
		hm.put(4, hs);
		
		HashSet<String> hs3 = hm.get(3);
		hs3.add("기모3");

		HashSet<String> hs4 = hm.get(3);
		Iterator<String> it = hs4.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
