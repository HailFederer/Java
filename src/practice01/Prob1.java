package practice01;

import java.util.Scanner;

public class Prob1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int i;
		while(true){
			
			System.out.print("수를 입력하시오 : ");
			i = sc.nextInt();
			
			if(i%3 == 0)
				System.out.println("3의 배수입니다.\n");
			else
				System.out.println("3의 배수가 아닙니다.\n");
		}
	}
}
