package step1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import common.IP;

public class NetClient 
{
	public void go() throws IOException
	{
		Socket socket = null;
		BufferedReader br = null;
		
		try
		{
			socket = new Socket(IP.FRIEND, 5432);
			System.out.println("**********Client ����**********");
			/*
			socket.getInputStream()�� ByteStream�̹Ƿ�,
			BufferedReader�� �̿��ϱ� ���ؼ��� CharacterStream(2 Byte ����)���� �����ؾ� �Ѵ�.
			 */
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("Server���� ���� Message : " + br.readLine());
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
