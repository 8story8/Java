package step3.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient
{
	public void go() throws UnknownHostException, IOException
	{
		Socket socket = new Socket(common.IP.SAIDEN, 5432);
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
		
		try
		{
			while(true)
			{
				String message = sc.nextLine();
				pw.println(message);
				
				message = br.readLine();
				
				if(message.equals("종료"))
				{
					System.out.println("Client 종료");
					break;
				}
				
				System.out.println(message);
			}
		}
		finally
		{
			if(sc != null)
			{
				sc.close();
			}
			
			if(pw != null)
			{
				pw.close();
			}
			
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
			new EchoClient().go();
		} 
		catch (IOException ie) 
		{
			ie.printStackTrace();
		}
	}
}
