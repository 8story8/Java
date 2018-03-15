package step4.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerWorker implements Runnable
{
	private Socket socket;
	private String user;

	public ServerWorker(Socket socket) 
	{
		super();
		this.socket = socket;
		this.user = "[" + this.socket.getInetAddress() + "]";
		System.out.println(user + "�� �����ϼ̽��ϴ�!");
	}
	
	public void echo() throws IOException
	{
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try
		{
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream(), true);
			
			while(true)
			{
				String message = br.readLine();
				if(message.equals(null) || message.equals("����"))
				{
					System.out.println(user + "���� �����̽��ϴ�!");
					pw.println("����");
					break;
				}
				
				System.out.println(user + "�� �޼��� : " + message);
				pw.println(message + " Server^^");
			}
		}
		finally
		{
			if(br != null)
			{
				br.close();
			}
			
			if(pw != null)
			{
				pw.close();
			}
			
			if(socket != null)
			{
				socket.close();
			}
		}
	}
	
	public void run()
	{
		try 
		{
			echo();
		} 
		catch (IOException ie) 
		{
			System.out.println(user + "���� ���Ǿ��� ������ �����Ͽ����ϴ�!");
		}
	}
}
