package practice02;

import java.util.Scanner;

public class Prob1 {

	public static void main(String[] args) {
		
		System.out.print("금액 : ");
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		
		if(money >= 50000){
			System.out.println("50000원  : "+money/50000+"개");
			money = money%50000;
		}
		if(money >= 10000){
			System.out.println("10000원  : "+money/10000+"개");
			money %= 10000;
		}
		if(money >= 5000){
			System.out.println("5000원  : "+money/5000+"개");
			money %= 5000;
		}
		if(money >= 1000){
			System.out.println("1000원  : "+money/1000+"개");
			money %= 1000;
		}
		if(money >= 500){
			System.out.println("500원  : "+money/500+"개");
			money %= 500;
		}
		if(money >= 100){
			System.out.println("100원  : "+money/100+"개");
			money %= 100;
		}
		if(money >= 50){
			System.out.println("50원  : "+money/50+"개");
			money %= 50;
		}
		if(money >= 10){
			System.out.println("10원  : "+money/10+"개");
			money %= 10;
		}
		if(money >= 5){
			System.out.println("5원  : "+money/5+"개");
			money %= 5;
		}
		System.out.println("1원  : "+money/1+"개");
	}
}
