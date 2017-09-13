package kakao;

import java.util.HashSet;

public class Prob_02 {

	public static void main(String[] args) {
		
		int[] arr = {4,1,3,-1};
		
		System.out.println(solution(arr));
	}
	
	public static boolean solution(int[] arr) {

		boolean answer = true;
		
		HashSet<Integer> hs = new HashSet<Integer>();
		int length = arr.length;
		
		for(int i=0; i<length; i++) {
			int x = arr[i];
			if(x<1 || x>length || hs.contains(x)) {
				answer = false;
				break;
			} else {
				hs.add(x);
			}
		}
		
		return answer;
	}
}






