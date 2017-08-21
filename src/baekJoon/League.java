package baekJoon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class League {
	
	static int[][] array;
	static LinkedList<Integer> list;
	static ArrayList<Integer> biggestList;
	static int n;
	static int valueOfArray;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		array = new int[n][n];
	    
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < n; j++) {
	        	array[i][j] = sc.nextInt();
	        }
	    }
	    
	    biggestList = new ArrayList<Integer>();
	    biggestList.ensureCapacity(2000);
	    biggestList.add(0);
	    list = new LinkedList<Integer>();
	    list.add(0);
		
		tailBack(0, 0);
		
		System.out.println(biggestList.size());
		Iterator<Integer> it = biggestList.iterator();
		while(it.hasNext()) {
			System.out.print((it.next()+1) + " ");
		}
	}
	
	public static void tailBack(int row, int col) {

		System.out.println((row+1) +" "+ (col+1));
		if(list.size() == n) {
			return;
		}
		valueOfArray = array[row][col];
		
		if(!list.contains(col) && valueOfArray == 1) {
			list.add(col);
			if(list.size() > biggestList.size()) {
				biggestList.removeAll(biggestList);
				Iterator<Integer> it = list.iterator();
				while(it.hasNext()) {
					biggestList.add(it.next());
				}
			}
			if(list.size() == n) {
				return;
			}
			tailBack(col, 0);
			if(list.size() == n) {
				return;
			}
		}
		if(col < n-1) {
			tailBack(row, col+1);
		} else if(col == n-1 && row != 0) {
			list.remove(new Integer(row));
		}
	}
}