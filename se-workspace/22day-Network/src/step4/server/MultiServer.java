package step4.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
Echo ���񽺸� �ټ��� Client�� �����ϴ� Server�� �����ϴ� ���� ����
�ټ��� Client�� ���������� Echo ���񽺸� �ϱ� ���ؼ���,
Client ���� ����ϴ� Server���� Thread�� �ʿ��ϴ�.

MultiServer : ����
Client ������ ����ϴٰ� �����ϸ�(ServerSocket)
�Ϲ� Socket(Client�� �����)�� ��ȯ�޾�,
Thread(ServerWorker) ������ �Ҵ��� �� start()��Ų��.

class MultiServer
{
	public void go()
	{
		ServerSocket
		while
		{
			accept() : Socket
			ServerWoker Thread ����(������ Socket) �Ҵ�
			Thread start() -> ���� ���� ���·� ������.
		}
	}
}

ServerWorker : ����(Thread)
MultiServer(����)���κ��� �Ҵ���� Socket����,
Client�� ���������� Echo �����Ѵ�.(run())

class ServerWorker implements Runnable
{
	private Socket socket;
	ServerWorker(Socket socket)
	{
		this.socket = socket;
	}
	public void run()
	{
		�Է�
		���
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
