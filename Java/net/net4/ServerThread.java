package net4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;

public class ServerThread extends Thread{

	private Map<Integer, Handler> map;
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	
	public ServerThread(Map<Integer, Handler> map, Socket socket) throws IOException {
		this.map = map;
		this.socket = socket;
		
		in = new DataInputStream(socket.getInputStream());
		out = new DataOutputStream(socket.getOutputStream());
		
	}
	
	public void run() {
		try {
			while(true)	{
				// 이 스레드가 사용하는 소켓으로 클라이언트가 보낸 메세지 읽기
				// 클라이언트가 서버로 보낸 요청명령을 읽어온다
				int reqCmd = in.readInt();
				// Map 객체에서 요청명령에 맞는 Handler 구현객체를 조회한다
				Handler handler = map.get(reqCmd);
				System.out.println("ServerThread [" + reqCmd + "][" + handler.getClass().getName()+"]");
				// 획득된 Handler 객체의 handle(in, out) 메소드를 실행한다
				handler.handle(in, out);
			} 
		}catch (IOException e) {
				// TODO: handle exception
			}
		
	}
}
