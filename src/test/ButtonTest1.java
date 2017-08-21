package test;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ButtonTest1 extends Frame implements WindowListener{
	
	public ButtonTest1(String str){
		super(str);
		addWindowListener(this);
	}

	public static void main(String[] args) {

		ButtonTest1 bt = new ButtonTest1("Button Test");
		bt.setVisible(true);
		Button b = new Button("Push this button!!");
		b.addActionListener(new ButtonHandler());
		bt.add(b, BorderLayout.CENTER);
		bt.pack();
	}


	@Override
	public void windowClosing(WindowEvent e) {
		setVisible(true);
		dispose();
		System.exit(0);
	}

	@Override
	public void windowOpened(WindowEvent e) {}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}
}

class ButtonHandler implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Button was pushed..");
		System.out.println("Message on the button : "+e.getActionCommand());
		
	}
}
