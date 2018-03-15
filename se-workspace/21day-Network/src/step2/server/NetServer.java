package step2.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
Server는 Client가 보낸 Message를 받아
아래와 같이 메세지를 출력한 후 다음 Client를 기다린다.
127.0.0.1님의 메세지 : 안녕
192.168.0.74님의 메세지 : 방가
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
			System.out.println("**step2.NetServer 실행**");
			
			while(true)
			{
				socket = serverSocket.accept();
				
				try
				{
					br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
					System.out.println(socket.getInetAddress()+ "님의 메세지 : " + br.readLine());
				}
				catch(Exception e)
				{
					System.out.println(socket.getInetAddress() + " 통신 예외 발생");
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
