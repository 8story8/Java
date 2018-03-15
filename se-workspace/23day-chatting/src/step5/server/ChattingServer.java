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
다수의 Client와 지속적으로 통신
Client가 보낸 Message를 입력받아 접속한 모든 Client에게 Message를 출력한다.
ref) cd C:\java-kosta\se-workspace\23day-chatting\bin 
	  java step5.server.ChattingServer
*/

public class ChattingServer{
	// private ArrayList<ServerWorker> list = new ArrayList<ServerWorker>();   // ArrayList는 다수의 ServerWorker Thread에 의해 공유되는 자원이다.
																								   // Thread-Safe하게 만들기 위해 Collections.synchronized()를 이용하여 동기화 처리한다.
	
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
			System.out.println(clientIp + "님 입장하셨습니다!");
			broadcast(clientIp + "님 입장하셨습니다!");
		}
		
		public void chatting() throws IOException{
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream(), true);
			
			while(true){
				String message = br.readLine();
				if(message == null || message.equals(null) || message.equals("종료")){
					break;
				}
				
				broadcast(clientIp + "님 : " + message);
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
				System.out.println(clientIp + "님이 예의없이 강제 종료하셨습니다!");
			}
			finally{
				list.remove(this);
				System.out.println(clientIp + "님이 나가셨습니다!");
				broadcast(clientIp + "님이 나가셨습니다!");
				
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
