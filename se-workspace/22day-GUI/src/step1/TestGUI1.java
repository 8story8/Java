package step1;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestGUI1 
{
	private Frame f;
	private Button b;
	
	public void go()
	{
		f = new Frame("GUI");
		f.setLayout(new FlowLayout());
		b = new Button("Submit");
		b.addActionListener(new ButtonHandler());
		f.add(b);
		f.setBackground(Color.yellow);
		f.addWindowListener(new FrameHandler());
		f.setSize(400, 200);
		f.setLocation(500, 200);
		f.setVisible(true);
	}
	
	class FrameHandler extends WindowAdapter
	{
		@Override
		public void windowClosing(WindowEvent e) 
		{
			super.windowClosing(e);
			System.exit(0);
		}
	}
	
	// Button 이벤트를 처리하는 Inner 클래스
	class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			System.out.println("Submit Complete");
		}
	}
	
	public static void main(String[] args) 
	{
		new TestGUI1().go();
	}
}
