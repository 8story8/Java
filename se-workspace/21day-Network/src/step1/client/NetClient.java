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
			System.out.println("**********Client 실행**********");
			/*
			socket.getInputStream()이 ByteStream이므로,
			BufferedReader를 이용하기 위해서는 CharacterStream(2 Byte 단위)으로 변경해야 한다.
			 */
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("Server에서 보낸 Message : " + br.readLine());
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
