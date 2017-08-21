package synchronizedExam;

class Toilet{
	
	public synchronized void use(String name){
		System.out.println(name);
		usingTime();
		System.out.println("아 시원해");
	}
	
	public void usingTime(){
		for (int i = 0; i < 100000000; i++) {
			if(i==10000)
				System.out.println("끄으응");
		}
	}
}

class Family extends Thread{
	
	Toilet toilet;
	String who;
	
	public Family(String name, Toilet t){
		who = name;
		toilet = t;
	}
	
	public void run(){
		toilet.use(who);
	}
}

public class ManageToilet {

	public static void main(String[] args) {
		
		Toilet t = new Toilet();
		
		Family father = new Family("아버지", t);
		Family mother = new Family("어머니", t);
		Family sister = new Family("누나", t);
		Family brother = new Family("형", t);
		Family me = new Family("나", t);
		
		try {
			
			father.start();
			father.sleep(1000);
			mother.start();
			father.sleep(1000);
			sister.start();
			father.sleep(1000);
			brother.start();
			father.sleep(1000);
			me.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
