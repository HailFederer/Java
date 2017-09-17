package kakao.codingTest;

public class Prob_01 {

	public static void main(String[] args) {

		int n=5;
		int[] arr1= {9, 20, 28, 18, 11}; 
		int[] arr2 = {30, 1, 21, 17, 28};
		String[] answer = {};
		
		answer = new String[n];
		
		for(int i=0; i<n; i++) {
			int atomNum1 = arr1[i];
			int atomNum2 = arr2[i];
			String str = "";
			for(int j=0; j<n; j++) {
				int jesu1 = (int) Math.pow(2, n-1-j);
				int map1Num = atomNum1 / jesu1;
				atomNum1 = atomNum1 % jesu1;
				int jesu2 = (int) Math.pow(2, n-1-j);
				int map2Num = atomNum2 / jesu2;
				atomNum2 = atomNum2 % jesu2;
				if(map1Num==0 && map2Num==0) {
					str += " ";
				} else if(map1Num==1 || map2Num==1) {
					str += "#";
				}
			}
			answer[i] = str;
		}
		
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

}
