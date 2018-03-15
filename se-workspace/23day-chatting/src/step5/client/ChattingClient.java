package step5.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
Chatting Client
Thread 2���� Multi-Threading�Ǿ�� �Ѵ�.
main Thread : Console���� �Է¹޾� Server�� Message ��µǴ� Thread
ClientWorker Thread : Server���� ���� Message�� �Է¹޾� Console�� ����ϴ� Thread
ref) cd C:\java-kosta\se-workspace\23day-chatting\bin 
	  java step5.client.ChattingClient
*/

public class ChattingClient{
	private Socket socket;
	private Scanner sc;
	private PrintWriter pw;
	private BufferedReader br;
	
	public void go() throws UnknownHostException, IOException {
			socket = new Socket(common.IP.INST, 5432);
			sc = new Scanner(System.in);
			pw = new PrintWriter(socket.getOutputStream(), true);
			
			Thread t = new Thread(new ClientWorker());
			t.setDaemon(true);
			t.start();
			
			while(true){
				String message = sc.nextLine();
				pw.println(message);
				if(message.equals("����")){
					break;
				}
			}
	}
	
	public void closeAll() throws IOException {
		if(sc != null){
			sc.close();
		}
		
		if(pw != null){
			sc.close();
		}
		
		if(br != null){
			sc.close();
		}
		
		if(socket != null){
			socket.close();
		}
	}
	
	class ClientWorker implements Runnable{
		public void run(){
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while(true){
					String message = br.readLine();
					if(message == null){
						break;
					}
					
					System.out.println(message);
				}
			} 
			catch (IOException ie) {
				ie.printStackTrace();
			}
			finally{
				try {
					closeAll();
				} 
				catch (IOException ie) {
					ie.printStackTrace();
				}
			}	
		}
	}
	
	public static void main(String[] args) {
		try {
			new ChattingClient().go();
		} 
		catch (IOException ie) {
			System.out.println("����");
		}
	}
}
