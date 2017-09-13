package UVa;

import java.util.Stack;

public class test3 {

	public static void main(String[] args) {
		
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		
		Stack<Integer> preCol = new Stack<Integer>();

		int sum = 0;
		for(int j=0; j<4; j++) {
			sum = 0;
			preCol.push(j);
			for(int i=0; i<land.length; i++) {
				
				sum += land[i][j];
			}
		}
		
		System.out.println(sum);
	}
}
