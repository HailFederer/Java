package practice01;

import java.util.Scanner;

public class Prob3 {

	public static void main(String[] args) {
		
		System.out.print("숫자를 입력하세요 : ");
		Scanner scanner = new Scanner(System.in);
			
		int sum=0;
		int num = scanner.nextInt();
		for( ; num>0; num=num-2){
				
			sum += num;
		}
			
		System.out.println("결과 값 : "+sum);
		System.out.println();
		
		scanner.close();
	}
}
