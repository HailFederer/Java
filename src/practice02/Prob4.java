package practice02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob4 {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			
			System.out.println("거꾸로 출력할 문장을 입력하세요.");
			
			String sentence = null;
			try {
				sentence = br.readLine();
			} catch (Exception e) {
				System.out.println(e);
			}
			
			printCharArray(reverse(sentence));
		}
	}
	
	public static char[] reverse(String str){
		
		char[] rev_Array = new char[str.length()];
		
		for(int i=0; i<str.length(); i++){
			rev_Array[i] = str.charAt(str.length()-i-1);
		}
		
		return rev_Array;
	}
	
	public static void printCharArray(char[] array){
		
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]);
		}
		System.out.println();
		System.out.println();
	}
}
