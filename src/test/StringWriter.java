package test;

import java.io.*;

class StringWriter
{
	public static void main(String[] args) throws IOException
	{
		BufferedWriter out=
			new BufferedWriter(new FileWriter("Song.txt"));
		
		out.write("안녕 한번쯤은 날 들어봤겠지");
		out.newLine();
		out.write("너의 사랑니");
		out.newLine();
		out.write("이미 어릴 때 모두 겪었다 생각하겠지");
		out.newLine();
		out.write("Attention boys");
		out.newLine();
		out.newLine();
		out.write("나는 좀 다를걸");
		out.newLine();
		out.write("다른 애들을 다 밀어내고 자리를 잡지");
		out.close();
		System.out.println("노래 가사 입력 완료");		
	}
}