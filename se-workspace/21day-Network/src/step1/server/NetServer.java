package step1.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NetServer 
{
	public void go() throws IOException
	{
		ServerSocket serverSocket = null;
		int count = 1;   // 접속자 수
		try
		{
			serverSocket=new ServerSocket(5432);
			System.out.println("**********Server 실행**********");;
		
		// 대기하다가 Client가 접속하면 실행한다.
		// accept()는 실행 후 return하는 개별 Socket이 Client와 통신할 주체이다.
		// ex) 담당자 전화기
			while(true)
			{
				Socket socket = serverSocket.accept();
		
				System.out.println(count +" 접속 IP : " + socket.getInetAddress());
		
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
		
				pw.println("방가방가 " + count);
				System.out.println("Server가 Client에게 Message 전송");
				pw.close();
				socket.close();
				count++;
			}
		}
		finally
		{
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
