package practice01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		while(true){
			
			System.out.print("문자열을 입력하세요 : ");
			//String st = sc.nextLine();
			String st;
			try {
				st = br.readLine();
				
				for(int i=0; i<st.length(); i++){
					System.out.println(st.substring(0, i+1));
				}
				System.out.println();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
