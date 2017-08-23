package UVa;

import java.util.Iterator;
import java.util.LinkedList;

public class OddTimeNumber {

	public static void main(String[] args) {

		int[] intArray = { 1, 2, 3, 4, 2, 3, 2, 2, 4 };

		LinkedList<Integer> intList = new LinkedList<Integer>();

		for (int i = 0; i < intArray.length; i++) {
			if (!intList.contains(intArray[i])) {
				intList.add(intArray[i]);
			} else {
				intList.remove(new Integer(intArray[i]));
			}
		}

		intList.get(0);

		Iterator<Integer> it = intList.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}
}
