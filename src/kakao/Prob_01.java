package kakao;

import java.util.Scanner;

public class Prob_01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int sum;
		int naturalNum = sc.nextInt();
		sum = solution(naturalNum);
		
		System.out.println(sum);
	}
	
	public static int solution(int n) {

		int answer = 0;
        
        String naturalNum = String.valueOf(n);
        
        for(int i=0; i<naturalNum.length(); i++){
        	answer += Integer.parseInt(naturalNum.substring(i, i+1));
        }
        
		return answer;
	}
}
