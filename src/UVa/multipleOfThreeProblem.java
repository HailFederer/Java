package UVa;

import java.util.Scanner;
import java.util.StringTokenizer;

public class multipleOfThreeProblem {
	
	static int[] resultArray;
	
	static int max_Num = 1000000;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		resultArray = new int[max_Num];
		
		int biggestNum = 1;
		
		String str;
		StringTokenizer st;
		int init_startNum;
		int init_endNum;
		int startNum;
		int endNum;
		int maxLength;
		int temp;
		int length;
		
		while(sc.hasNextLine()) {

			str = sc.nextLine();
			st = new StringTokenizer(str, " ");
			init_startNum = Integer.parseInt(st.nextToken());
			init_endNum = Integer.parseInt(st.nextToken());
			startNum = init_startNum;
			endNum = init_endNum;
			maxLength = 1;
			
			if(startNum > endNum) {
				temp = startNum;
				startNum = endNum;
				endNum = temp;
			}
			
			if(endNum > biggestNum) {
				storingNum(biggestNum, endNum);
				biggestNum = endNum;
			}
			
			for(int j=startNum; j<endNum+1; j++) {
				
				length = resultArray[j-1];
				
				if(length > maxLength) {
					maxLength = length;
				}
			}
		
			System.out.println(init_startNum+" "+init_endNum+" "+maxLength);
		}
	}

	public static long algorithm(long n) {
		
		if(n%2 == 1) {
			n = 3*n + 1;
		} else if(n%2 == 0) {
			n = n/2;
		}
		
		return n;
	}
	
	public static void storingNum(int biggestNum, int endNum) {
		
		for( ; biggestNum<endNum+1; biggestNum++) {
			
			int length = 1;
			long param = biggestNum;
			
			while(param != 1){
				param = algorithm(param);
				if(param <= biggestNum) {
					length += resultArray[(int)param-1];
					break;
				}
				length++;
			}
			resultArray[biggestNum-1] = length;
		}
	}
}



