package test;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class PrintWriterTest {

	public static void main(String[] args){

		MyInfo mi = new MyInfo("저는 자바 프로그래머입니다.");
		PrintWriter pw = null;
		
		try {
			pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("./println.txt"), StandardCharsets.UTF_8), true);
			
			pw.println("제 소개를 하겠습니다.");
			pw.println(mi);
			pw.printf("나이 %d, 몸무게 %dkg입니다.", 31, 58);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(pw != null) {
				pw.close();
			}
		}
	}		
}

class MyInfo
{
	String info;
	
	public MyInfo(String info) {
		this.info = info;
	}
	
	public String toString() {
		return info;
	}
}




