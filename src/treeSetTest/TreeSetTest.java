package treeSetTest;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {

		TreeSet<Person> sTree = new TreeSet<Person>();
		sTree.add(new Person("Lee", 24));
		sTree.add(new Person("Hong", 29));
		sTree.add(new Person("Choi", 21));
		
		Iterator<Person> it = sTree.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
