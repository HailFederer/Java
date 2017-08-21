package treeSetTest;

import java.util.Iterator;
import java.util.TreeSet;

public class StrLenComparatorTest {

	public static void main(String[] args) {
		
		TreeSet<String> tSet = new TreeSet<String>(new StrLenComparator());
		tSet.add("Orange");
		tSet.add("Apple");
		tSet.add("Dog");
		tSet.add("Individual");
		
		Iterator<String> it = tSet.descendingIterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

