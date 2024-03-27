package net3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.Socket;

public class FileClient2 {

	public static void main(String[] args) throws Exception {
		
		System.out.println("파일 클라이언트가 기동됨");
		Socket socket = new Socket("192.168.0.7", 30000);
		System.out.println("파일서버와 연결이 완료됨");
		
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		DataInputStream in = new DataInputStream(socket.getInputStream());
		
		// 파일 다운로드 요청을 서버로 보내기
		out.writeInt(Command.REQ_DOWNLOAD);
		out.writeUTF("doc.pdf");
		
		// 파일서버가 보낸 응답 받기 - [커맨드][파일명][파일사이즈][xxxxxxxxxxxxxxxxx]
		int command = in.readInt();
		if(Command.RES_MESSAGE == command) {
			System.out.println("파일서버가 보낸 메세지를 수신함");
			
		} else if(Command.RES_FILE == command) {
			System.out.println("파일서버가 보낸 다운로드파일 정보를 수신함");
			String filename = in.readUTF();
			long size = in.readLong();
			System.out.println("파일서버에서 보낸 파일명 : " + filename);
			System.out.println("파일서버에서 보낸 파일 크기 : " + size );
			
			FileOutputStream fos = new FileOutputStream("C:\\Users\\ftisa\\Downloads\\" + filename);
			long readBytes = 0;
			int len = 0;
			byte[] buf = new byte[1024];
			
			while ((len = in.read(buf)) != -1) {
				fos.write(buf,0,len);
				readBytes += len;
				
				if(size == readBytes) {
					break;
				}
			}
			fos.close();
			
		} else if(Command.RES_FILE_LIST == command) {
			System.out.println("파일서버가 보낸 파일목록 정보를 수신함");
		}
	}
}
