package treeSetTest;

public class MyString implements Comparable<MyString>{
	
	private String string;

	public MyString(String string) {
		this.string = string;
	}
	
	public int getLength() {
		return string.length();
	}
	
	public String toString() {
		return string;
	}

	@Override
	public int compareTo(MyString o) {
		return o.getLength() - getLength();
	}
}
