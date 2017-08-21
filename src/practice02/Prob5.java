package practice02;

import java.util.Random;
import java.util.Scanner;

public class Prob5 {

	public static void main(String[] args) {

		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		String answer = null;
		do {
			int ranNum = r.nextInt(100)+1;
			int min=1, max=100;
			int tryNum;
			int repeatNum=1;
			
			System.out.println(ranNum);
			
			System.out.println("숫자를 맞춰보세요.(1~100)");
			while(true){
				
				System.out.print(repeatNum+">> ");
				
				boolean valid = true;
				do {
					tryNum = sc.nextInt();
					
					if(tryNum<min || tryNum>max){
						System.out.println("범위 내의 값으로 다시 입력해주세요.");
						valid = false;
					}else{
						valid =true;
					}
				} while (valid==false);
				
				if(ranNum == tryNum){
					System.out.println("정답입니다!");
					break;
				}else{
					if(ranNum < tryNum){
						System.out.println("더 낮게");
						max = tryNum-1;
					}else{
						System.out.println("더 높게");
						min = tryNum+1;
					}
					
					System.out.println(min+"~"+max);
				}
				
				repeatNum++;
				
			}
			
			System.out.print("다시 하시겠습니까?(y/n)");
			answer = sc.next();
			
		} while (answer.equals("y") || answer.equals("Y"));
	}

}
