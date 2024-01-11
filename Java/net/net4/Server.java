package net4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {

	private Map<Integer, Handler> map = new HashMap<Integer, Handler>();
	
	
	public Server() {
		map.put(Cmd.REQ_UPLOAD, new ServerFileUploadHandler());
		map.put(Cmd.REQ_DOWNLOAD, new ServerFileDownloadHandler());
		map.put(Cmd.REQ_FILE_LIST, new ServerFileListHandler());
	}
	
	public void startup() throws IOException {
		// 클라이언트의 연결요청을 접수받는 ServerSocket을 생성하고, 포트번호를 지정한다
		ServerSocket serverSocket = new ServerSocket(30000);
		System.out.println("파일서버가 시작됨...");
		
		while(true) {
			System.out.println("파일서버가 클라이언트의 연결요청을 기다림...");
			Socket socket = serverSocket.accept();
			System.out.println("파일서버에 클라이언트의 연결요청이 접수됨...");
			System.out.println("파일서버는 클라이언트와 통신할 소켓을 생성함...");
			
			// 제공된 소켓과 연결된 클라이언트와의 통신을 담당하는 스레드 객체를 생성한다
			ServerThread thread = new ServerThread(map,socket);
			thread.start();
			
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		Server server = new Server();
		server.startup();
	}
	
}
