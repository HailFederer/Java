package baekJoon;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class League_LinkedList {
	
	static int[][] array;
	static LinkedList<Integer> biggestList;
	static int n;
    
	static LinkedList<Integer> rowLinkedList;
	static LinkedList<Integer> colLinkedList;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		array = new int[n][n];
	    
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < n; j++) {
	        	array[i][j] = sc.nextInt();
	        }
	    }
	    
	    biggestList = new LinkedList<Integer>();
	    biggestList.add(0);
		
	    rowLinkedList = new LinkedList<Integer>();
	    colLinkedList = new LinkedList<Integer>();
	    rowLinkedList.add(0);
	    colLinkedList.add(0);
		
		tailBack();
		
		System.out.println(biggestList.size());
		Iterator<Integer> it = biggestList.iterator();
		while(it.hasNext()) {
			System.out.print((it.next()+1) + " ");
		}
	}
	
	public static void tailBack() {
		
		int row = 0;
		int col = 0;
		
		while(true) {
			
			int valueOfArray = array[row][col];
			
			if(!colLinkedList.contains(col) && valueOfArray == 1) {
				
				rowLinkedList.add(row);
				colLinkedList.add(col);
				if(colLinkedList.size() > biggestList.size()) {
					biggestList.removeAll(biggestList);
					Iterator<Integer> it = colLinkedList.iterator();
					while(it.hasNext()) {
						biggestList.add(it.next());
					}
				}
				
				if(colLinkedList.size() == n) {
					return;
				}
				
				row = col;
				col = 0;
				continue;
			}
			
			if(col < n-1) {
				col++;
				continue;
			} else if(col == n-1) {
				if(row != 0) {
					row = rowLinkedList.getLast();
					rowLinkedList.removeLast();
					col = colLinkedList.getLast() + 1;
					colLinkedList.removeLast();
					
					if(col == n) {
						row = rowLinkedList.getLast();
						rowLinkedList.removeLast();
						col = colLinkedList.getLast() + 1;
						colLinkedList.removeLast();
					}
					continue;
				} else {
					return;
				}
			}
		}
	}
}