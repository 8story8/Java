package step4.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MultiClient 
{
	public void go() throws UnknownHostException, IOException
	{
		Scanner sc = null;
		Socket socket = null;
		PrintWriter pw = null;
		BufferedReader br = null;
	
		try
		{
			sc = new Scanner(System.in);
			socket = new Socket(common.IP.SAIDEN, 5432);
			pw = new PrintWriter(socket.getOutputStream(), true);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(true)
			{
				String message = sc.nextLine();
				pw.println(message);
				
				if(message.equals(null) || message.equals("종료"))
				{
					System.out.println("Client가 종료되었습니다!");
					break;
				}
				
				message = br.readLine();
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
			new MultiClient().go();
		} 
		catch (IOException ie) 
		{
			ie.printStackTrace();
		}
	}
}
