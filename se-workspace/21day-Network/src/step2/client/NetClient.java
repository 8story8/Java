package step2.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import common.IP;

/*
Server�� �����Ͽ� �޼����� �����ϰ� ������ �����Ѵ�.
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
			System.out.println("**Client�� Server�� �޼��� ����**");
			
			
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
