package practice03_Prob3;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class test {
	static DecimalFormat df;

	public static void main(String[] args) {
		
		double n = 12345.6789;
	
	//결과:12346
	df = new DecimalFormat("0");
	System.out.println(df.format(n));
	
	//결과:12345.7
	df = new DecimalFormat("0.0");
	System.out.println(df.format(n));
	
	//결과:012345.67890
	df = new DecimalFormat("000000.00000");
	System.out.println(df.format(n));
	
	//결과:12346
	df = new DecimalFormat("#");
	System.out.println(df.format(n));
	
	//결과:12345.6789
	df = new DecimalFormat("######.#####");
	System.out.println(df.format(n));
	
	//결과 : 1234567.89%
	df = new DecimalFormat("#,## %");
	System.out.println(df.format(n));
	}

}
