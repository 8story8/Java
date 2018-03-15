package step4;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestGUI4 
{
	private Frame f;
	private Panel p;
	private Button b1, b2, b3;
	private TextField t;
	
	public void go()
	{
		f = new Frame("Event Practice");
		p = new Panel();
		b1 = new Button("±Ë±‘¿Õ");
		b2 = new Button("±Ë∫∏∞‚");
		b3 = new Button("»≤¿±ªÛ");
		
		// f.setSize(300, 300);
		f.setLocation(500, 200);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() 
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				super.windowClosing(e);
				System.exit(0);
			}
		});
		
		p.setBackground(Color.yellow);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		
		b1.addActionListener(new ButtonHandler());
		b2.addActionListener(new ButtonHandler());
		b3.addActionListener(new ButtonHandler());
		
		t = new TextField();
		
		f.add(p, BorderLayout.CENTER);
		f.add(t, BorderLayout.SOUTH);
		f.pack();
	}
	
	// Button Event √≥∏Æ
	class ButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getActionCommand().equals("±Ë±‘¿Õ"))
			{
				t.setText("π›¿Â");
			}
			
			if(e.getActionCommand().equals("±Ë∫∏∞‚"))
			{
				t.setText("∞£µ");
			}
			
			if(e.getActionCommand().equals("»≤¿±ªÛ"))
			{
				t.setText("æ’¿‚¿Ã");
			}
		}
	}
	
	public static void main(String[] args) 
	{
		new TestGUI4().go();
	}
}
