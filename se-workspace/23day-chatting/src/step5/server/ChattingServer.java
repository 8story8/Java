package step5.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*
Chatting Server
�ټ��� Client�� ���������� ���
Client�� ���� Message�� �Է¹޾� ������ ��� Client���� Message�� ����Ѵ�.
ref) cd C:\java-kosta\se-workspace\23day-chatting\bin 
	  java step5.server.ChattingServer
*/

public class ChattingServer{
	// private ArrayList<ServerWorker> list = new ArrayList<ServerWorker>();   // ArrayList�� �ټ��� ServerWorker Thread�� ���� �����Ǵ� �ڿ��̴�.
																								   // Thread-Safe�ϰ� ����� ���� Collections.synchronized()�� �̿��Ͽ� ����ȭ ó���Ѵ�.
	
	private List<ServerWorker> list = Collections.synchronizedList(new ArrayList<ServerWorker>());
	
	public void go() throws IOException {
		ServerSocket serverSocket = null;
		
		try{
			serverSocket = new ServerSocket(5432);
			System.out.println("**ChattingServer**");
			
			while(true){
				Socket socket = serverSocket.accept();
				ServerWorker serverWorker = new ServerWorker(socket);
				
				list.add(serverWorker);
				
				Thread t = new Thread(serverWorker);
				t.start();
			}
		}
		finally{
			if(serverSocket != null){
				serverSocket.close();
			}
		}
	}
	
	public void broadcast(String message){
		for(int i = 0; i < list.size(); i++){
			list.get(i).pw.println(message);
		}
	}
	
	class ServerWorker implements Runnable{
		private Socket socket;
		private String clientIp;
		private BufferedReader br;
		private PrintWriter pw;
		
		ServerWorker(Socket socket){
			this.socket = socket;
			this.clientIp = "[" + socket.getInetAddress() + "]" ;
			System.out.println(clientIp + "�� �����ϼ̽��ϴ�!");
			broadcast(clientIp + "�� �����ϼ̽��ϴ�!");
		}
		
		public void chatting() throws IOException{
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream(), true);
			
			while(true){
				String message = br.readLine();
				if(message == null || message.equals(null) || message.equals("����")){
					break;
				}
				
				broadcast(clientIp + "�� : " + message);
			}
		}
		
		public void closeAll() throws IOException{
			if(br != null){
				br.close();
			}
			
			if(pw != null){
				pw.close();
			}
			
			if(socket != null){
				socket.close();
			}
		}
		
		public void run(){
			try {
				chatting();
			} 
			catch (IOException ie) {
				System.out.println(clientIp + "���� ���Ǿ��� ���� �����ϼ̽��ϴ�!");
			}
			finally{
				list.remove(this);
				System.out.println(clientIp + "���� �����̽��ϴ�!");
				broadcast(clientIp + "���� �����̽��ϴ�!");
				
				try {
					closeAll();
				} 
				catch (IOException ie){
					ie.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args){
		try {
			new ChattingServer().go();
		} 
		catch (IOException ie) {
			ie.printStackTrace();
		}
	}
}
