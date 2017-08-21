package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class FileOutputStreamExam {

	public static void main(String[] args) throws IOException{
		
		char ch1='가';
		char ch2='나';
		
		Writer out=new FileWriter("hyper.txt");
		out.write(ch1);
		out.write(ch2);
		out.close();
		
		char[] cbuf=new char[10];
		int readCnt;
		
		Reader in=new FileReader("hyper.txt");
		readCnt=in.read(cbuf, 0, cbuf.length);
		for (int i = 0; i < readCnt; i++) {
			System.out.println(cbuf[i]);
		}
		in.close();
	}

}
