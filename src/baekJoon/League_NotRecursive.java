package baekJoon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class League_NotRecursive {
	
	static int[][] array;
	static ArrayList<Integer> biggestList;
	static int n;
    
	static Stack<Integer> rowStack;
	static Stack<Integer> colStack;

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
		
		rowStack = new Stack<Integer>();
		colStack = new Stack<Integer>();
		rowStack.push(0);
		colStack.push(0);
		
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
			
			if(!colStack.contains(col) && valueOfArray == 1) {
				
				rowStack.push(row);
				colStack.push(col);
				if(colStack.size() > biggestList.size()) {
					biggestList.removeAll(biggestList);
					Iterator<Integer> it = colStack.iterator();
					while(it.hasNext()) {
						biggestList.add(it.next());
					}
				}
				
				if(colStack.size() == n) {
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
					row = rowStack.pop();
					col = colStack.pop() + 1;
					
					if(col == n) {
						row = rowStack.pop();
						col = colStack.pop() + 1;
					}
					continue;
				} else {
					return;
				}
			}
		}
	}
}