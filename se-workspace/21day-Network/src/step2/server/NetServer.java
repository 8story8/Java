package step2.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
Server�� Client�� ���� Message�� �޾�
�Ʒ��� ���� �޼����� ����� �� ���� Client�� ��ٸ���.
127.0.0.1���� �޼��� : �ȳ�
192.168.0.74���� �޼��� : �氡
*/
public class NetServer 
{
	public void go() throws IOException
	{
		ServerSocket serverSocket = null;
		Socket socket = null;
		BufferedReader br = null;
		
		try
		{
			serverSocket=new ServerSocket(5432);
			System.out.println("**step2.NetServer ����**");
			
			while(true)
			{
				socket = serverSocket.accept();
				
				try
				{
					br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
					System.out.println(socket.getInetAddress()+ "���� �޼��� : " + br.readLine());
				}
				catch(Exception e)
				{
					System.out.println(socket.getInetAddress() + " ��� ���� �߻�");
				}
			}
		}
		finally
		{
			if(br != null)
			{
				br.close();
			}
			
			if(socket != null)
			{
				socket.close();
			}
			
			if(serverSocket != null)
			{
				serverSocket.close();
			}
		}
	}
	
	public static void main(String[] args) 
	{
		try 
		{
			new NetServer().go();
		} 
		catch (IOException ie) 
		{
			ie.printStackTrace();
		}
	}
}
