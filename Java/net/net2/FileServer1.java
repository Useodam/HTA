package net2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer1 {

	public static void main(String[] args) throws IOException {
		
		System.out.println("파일서버가 기동됨...");
		
		ServerSocket server = new ServerSocket(30000);
		while(true) {
			try {
				
			System.out.println("파일클라이언트의 연결요청을 대기중");
			Socket socket = server.accept();
			System.out.println("파일클라이언트의 연결요청을 수락함");
		
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			
			System.out.println("파일클라이언트가 첨부파일 업로드를 시작함");
			String filename= in.readUTF();
			long filesize = in.readLong();
			System.out.println("첨부파일 명 : " + filename);
			System.out.println("첨부파일크기 : " + filesize);
			
			FileOutputStream fos = new FileOutputStream("c:/repo/" + filename);
			long readBytes = 0;
			int len = 0;
			byte[] buf = new byte[1024];
			while( (len = in.read())!= -1) {
				fos.write(buf,0,len);
				readBytes += len;
				
				if(filesize == readBytes) {
					break;
				}
			}
			fos.close();
			}  catch (IOException e) {
			// TODO: handle exception
		}
		
	}
	}
}
