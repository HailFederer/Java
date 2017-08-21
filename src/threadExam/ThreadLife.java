package threadExam;

public class ThreadLife implements Runnable{
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" start!!");
		for (int i = 1; i < 11; i++) {
			System.out.println(Thread.currentThread().getName()+" : "+i);
		}
	}

	public static void main(String[] args) {

		ThreadLife ts = new ThreadLife();
		Thread t1 = new Thread(ts, "first");
		//t1.setPriority(Thread.MAX_PRIORITY);
		
		Thread t2 = new Thread(ts, "second");
		//t2.setPriority(Thread.MAX_PRIORITY);
		

		t1.start();
		try {
			t1.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		t2.start();
		
		System.out.println("main thread end");
	}

}
