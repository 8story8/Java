package step2;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestGUI2 
{
	private Frame f;
	private Button b1, b2;
	
	public void go()
	{
		f = new Frame("Event Practice");
		b1 = new Button("Odd");
		b2 = new Button("Even");
	
		f.setLayout(new FlowLayout());
		f.setBackground(Color.orange);
		// f.setSize(300, 100);
		f.setLocation(500, 200);
		
		f.add(b1);
		f.add(b2);
		f.setVisible(true);
		f.pack();
		
		// Anonymous 클래스로 Frame 종료 이벤트 처리
		f.addWindowListener(new WindowAdapter() 
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				super.windowClosing(e);
				System.exit(0);
			}
		});
		
		b1.addActionListener(new ButtonHandler());
		b2.addActionListener(new ButtonHandler());
	}
	
	class ButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			System.out.println(e.getActionCommand());
		}
	}
	
	public static void main(String[] args) 
	{
		new TestGUI2().go();
	}
}
