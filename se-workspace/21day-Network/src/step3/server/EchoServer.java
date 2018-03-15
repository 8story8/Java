package step3.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
EchoServer
Client�� �����Ͽ� �����͸� �����ϸ�
�����͸� �Է¹޾� �ֿܼ� ����ϰ�,
�ٽ� �� �����͸� Ŭ���̾�Ʈ�� ����ϴ� �޾Ƹ� ����

ServiceSocket ��ǥ ��ȭ
accept() ����
IOStream ����
while()
{
	�Է�
	���
}
close();
*/

public class EchoServer
{
	public void go() throws IOException
	{
		ServerSocket serverSocket = new ServerSocket(5432);
		System.out.println("**�޾Ƹ� ����**");
		
		Socket socket = serverSocket.accept();
		System.out.println(socket.getInetAddress() + " �����߽��ϴ�!");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
		
		try
		{
			while(true)
			{
				String message = br.readLine();
				if(message.equals(null) || message.equals("����"))
				{
					System.out.println("Client�� ����Ǿ� Server�� ����!");
					pw.println("����");
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
