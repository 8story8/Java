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
		int count = 1;   // ������ ��
		try
		{
			serverSocket=new ServerSocket(5432);
			System.out.println("**********Server ����**********");;
		
		// ����ϴٰ� Client�� �����ϸ� �����Ѵ�.
		// accept()�� ���� �� return�ϴ� ���� Socket�� Client�� ����� ��ü�̴�.
		// ex) ����� ��ȭ��
			while(true)
			{
				Socket socket = serverSocket.accept();
		
				System.out.println(count +" ���� IP : " + socket.getInetAddress());
		
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
		
				pw.println("�氡�氡 " + count);
				System.out.println("Server�� Client���� Message ����");
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
