package treeSetTest;

import java.util.Iterator;
import java.util.TreeSet;

public class StringLengthTreeSetTest {

	public static void main(String[] args) {

		TreeSet<MyString> tSet = new TreeSet<MyString>();
		tSet.add(new MyString("Orange"));
		tSet.add(new MyString("Apple"));
		tSet.add(new MyString("Dog"));
		tSet.add(new MyString("Individual"));
		
		Iterator<MyString> it = tSet.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
