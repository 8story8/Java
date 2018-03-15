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
		System.out.println(user + "님 입장하셨습니다!");
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
				if(message.equals(null) || message.equals("종료"))
				{
					System.out.println(user + "님이 나가셨습니다!");
					pw.println("종료");
					break;
				}
				
				System.out.println(user + "님 메세지 : " + message);
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
			System.out.println(user + "님이 예의없이 강제로 종료하였습니다!");
		}
	}
}
