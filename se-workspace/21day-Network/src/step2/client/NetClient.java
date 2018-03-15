package step2.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import common.IP;

/*
Server에 접속하여 메세지를 전송하고 접속을 해제한다.
*/

public class NetClient 
{

	public void go() throws IOException
	{
		Scanner sc = null;
		Socket socket = null;
		PrintWriter pw = null;
		
		try
		{
			socket = new Socket(IP.FRIEND, 5432);
			
			sc = new Scanner(System.in);
			
			pw = new PrintWriter(socket.getOutputStream(), true);
			System.out.println("**Client가 Server로 메세지 전송**");
			
			
			pw.println(sc.nextLine());
		}
		finally
		{
			if(sc != null)
			{
				sc.close();
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
	
	public static void main(String[] args) 
	{
		try 
		{
			new NetClient().go();
		} 
		catch (IOException ie) 
		{
			ie.printStackTrace();
		}
	}

}
