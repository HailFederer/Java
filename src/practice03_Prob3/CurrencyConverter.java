package practice03_Prob3;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CurrencyConverter {
		
	private static double rate;
	
	private static DecimalFormat df = new DecimalFormat("#.00");

	public static double  toDollar(double won) {
		   // 한국 원화를 달러로 변환
		return won/rate;
	}
	public static double  toKRW(double dollar) {
		   // 달러를 한국 원화로 변환
		return dollar*rate;
	}
	public static void setRate(double r) {
		    // 환율 설정(KRW/$1)
		rate = r;
	}
	
	public static void main(String[] args){
		
		setRate(1130.50);
		
		String toDollar =  df.format(toDollar(1000000));
		String toKRW = df.format(toKRW(100));
		
		System.out.println("백만원은 "+toDollar+"달러 입니다.");
		System.out.println("백달러는 "+toKRW+"원 입니다.");
	}
}
