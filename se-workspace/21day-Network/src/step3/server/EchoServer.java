package step3.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
EchoServer
Client가 접속하여 데이터를 전송하면
데이터를 입력받아 콘솔에 출력하고,
다시 그 데이터를 클라이언트로 출력하는 메아리 서버

ServiceSocket 대표 전화
accept() 접수
IOStream 생성
while()
{
	입력
	출력
}
close();
*/

public class EchoServer
{
	public void go() throws IOException
	{
		ServerSocket serverSocket = new ServerSocket(5432);
		System.out.println("**메아리 서버**");
		
		Socket socket = serverSocket.accept();
		System.out.println(socket.getInetAddress() + " 접속했습니다!");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
		
		try
		{
			while(true)
			{
				String message = br.readLine();
				if(message.equals(null) || message.equals("종료"))
				{
					System.out.println("Client가 종료되어 Server도 종료!");
					pw.println("종료");
					break;
				}
				System.out.println("Client Message : " + message);
				pw.println(message + " Server^^"); 
			}
			
			br.close();
			pw.close();
			socket.close();
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
			new EchoServer().go();
		} 
		catch (IOException ie) 
		{
			ie.printStackTrace();
		}
	}
}
