package threadExam;

import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BallEx extends JPanel implements Runnable{
	
	int x,y,diameter;
	
	public BallEx(int dia) {
		diameter=dia;
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillOval(x, y, diameter, diameter);
	}

	@Override
	public void run() {

		try {
			for (int i = 0; i < 10; i++) {
				x += 10;
				y += 10;
				repaint();
				Thread.sleep(300);
			}
		} catch (Exception e) {
			
		}	
	}

	public static void main(String[] args) {
		
		BallEx ex1 = new BallEx(10);
		JFrame f = new JFrame("Ball1");
		f.add(ex1);
		f.setSize(100, 100);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent w){
				System.exit(0);;
			}
		});
	}

}
