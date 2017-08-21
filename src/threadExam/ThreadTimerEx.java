package threadExam;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

class ThreadTimer extends Thread{

	JLabel timerLabel;
	
	public ThreadTimer(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}
	
	@Override
	public void run() {
		int n = 0;
		while(true){
			
			timerLabel.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				return;
			}
		}
	}
}

public class ThreadTimerEx extends JFrame{

	public ThreadTimerEx(){
		setTitle("ThreadTimerEx 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		
		ThreadTimer th = new ThreadTimer(timerLabel);
		add(timerLabel);
		
		setSize(300,150);
		setVisible(true);
		
		th.start();
	}

	public static void main(String[] args) {
			
		new ThreadTimerEx();
	}
}
