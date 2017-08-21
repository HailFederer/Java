package threadExam;

public class ThreadTest1 extends Thread{

	public void printNumber(){
		for (int i = 1; i <= 20; i++) {
			System.out.println("number = "+i);
		}
	}

	@Override
	public void run() {
		printNumber();
	}
	
	public static void main(String[] args){
		ThreadTest1 tt = new ThreadTest1();
		tt.start();
		try {
			tt.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 101; i <= 120; i++) {
			System.out.println("main number = "+i);
		}
	}
}
