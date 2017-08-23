package baekJoon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class League_ArrayList {
	
	static int[][] array;
	static ArrayList<Integer> biggestList;
	static int n;
    
	static ArrayList<Integer> rowArrayList;
	static ArrayList<Integer> colArrayList;

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
		
	    rowArrayList = new ArrayList<Integer>();
	    colArrayList = new ArrayList<Integer>();
	    rowArrayList.add(0);
	    colArrayList.add(0);
		
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
			
			if(!colArrayList.contains(col) && valueOfArray == 1) {
				
				rowArrayList.add(row);
				colArrayList.add(col);
				if(colArrayList.size() > biggestList.size()) {
					biggestList.removeAll(biggestList);
					Iterator<Integer> it = colArrayList.iterator();
					while(it.hasNext()) {
						biggestList.add(it.next());
					}
				}
				
				if(colArrayList.size() == n) {
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
					int size = rowArrayList.size();
					row = rowArrayList.get(size-1);
					rowArrayList.remove(size-1);
					col = colArrayList.get(size-1) + 1;
					colArrayList.remove(size-1);
					
					if(col == n) {
						size = rowArrayList.size();
						row = rowArrayList.get(size-1);
						rowArrayList.remove(size-1);
						col = colArrayList.get(size-1) + 1;
						colArrayList.remove(size-1);
					}
					continue;
				} else {
					return;
				}
			}
		}
	}
}