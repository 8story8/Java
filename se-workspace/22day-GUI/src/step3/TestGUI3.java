package step3;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
Java GUI
Frame�� �⺻ Layout : BorderLayout(��, ��, ��, ��, �߾�)
Panel�� �⺻ Layout : FlowLayout(������� ��ġ)
*/

public class TestGUI3 
{
	private Frame f;
	private Button eastBtn, westBtn, southBtn, northBtn, centerBtn;
	
	public void go()
	{
		f = new Frame("Layout Test");
		eastBtn = new Button("��");
		westBtn = new Button("��");
		southBtn = new Button("��");
		northBtn = new Button("��");
		centerBtn = new Button("�߾�");
		
		f.setSize(300, 300);
		f.setLocation(300, 200);
		f.setVisible(true);
		
		// Anonymous Ŭ������ Frame ���� �̺�Ʈ ó��
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
