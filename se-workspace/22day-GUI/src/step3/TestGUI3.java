package step3;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
Java GUI
Frame의 기본 Layout : BorderLayout(동, 서, 남, 북, 중앙)
Panel의 기본 Layout : FlowLayout(순서대로 배치)
*/

public class TestGUI3 
{
	private Frame f;
	private Button eastBtn, westBtn, southBtn, northBtn, centerBtn;
	
	public void go()
	{
		f = new Frame("Layout Test");
		eastBtn = new Button("동");
		westBtn = new Button("서");
		southBtn = new Button("남");
		northBtn = new Button("북");
		centerBtn = new Button("중앙");
		
		f.setSize(300, 300);
		f.setLocation(300, 200);
		f.setVisible(true);
		
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
		
		f.add(eastBtn, BorderLayout.EAST);
		// f.add(westBtn, BorderLayout.WEST);
		f.add(southBtn, BorderLayout.SOUTH);
		// f.add(northBtn, BorderLayout.NORTH);
		f.add(centerBtn, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) 
	{
		new TestGUI3().go();
	}
}
