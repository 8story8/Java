package step4.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
Echo 서비스를 다수의 Client에 서비스하는 Server를 구현하는 것이 목적
다수의 Client와 지속적으로 Echo 서비스를 하기 위해서는,
Client 수에 비례하는 Server측의 Thread가 필요하다.

MultiServer : 사장
Client 접속을 대기하다가 접속하면(ServerSocket)
일반 Socket(Client와 통신할)을 반환받아,
Thread(ServerWorker) 생성시 할당한 후 start()시킨다.

class MultiServer
{
	public void go()
	{
		ServerSocket
		while
		{
			accept() : Socket
			ServerWoker Thread 생성(생성시 Socket) 할당
			Thread start() -> 실행 가능 상태로 보낸다.
		}
	}
}

ServerWorker : 직원(Thread)
MultiServer(사장)으로부터 할당받은 Socket으로,
Client와 지속적으로 Echo 서비스한다.(run())

class ServerWorker implements Runnable
{
	private Socket socket;
	ServerWorker(Socket socket)
	{
		this.socket = socket;
	}
	public void run()
	{
		입력
		출력
	}
}
*/

public class MultiServer
{	
	@SuppressWarnings({ "resource", "unused" })
	public void go() throws IOException
	{
		ServerSocket serverSocket = null;
		
		try
		{
			serverSocket = new ServerSocket(5432);
			System.out.println("**MultiServer**");
			
			while(true)
			{
				Socket socket = serverSocket.accept();
				new Thread(new ServerWorker(socket)).start();
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
			new MultiServer().go();
		} 
		catch (IOException ie) 
		{
			ie.printStackTrace();
		}
	}
}
