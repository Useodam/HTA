package net4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 클라이언트가 보낸 메세지
 * [REQ_UPLOAD][파일명][파일크기][파일데이터]
 */
public class ServerFileUploadHandler implements Handler{

	@Override
	public void handle(DataInputStream in, DataOutputStream out) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("파일서버가 파일업로드 요청을 시작함");
		
		String filename = in.readUTF();
		long size = in.readLong();
		
		File file = new File("c:/repo", filename);
		FileOutputStream fos = new FileOutputStream(file);
		long readBytes = 0;
		int len = 0;
		byte[] buf = new byte[1024];
		
		while((len = in.read()) != -1) {
			fos.write(buf,0,len);
			readBytes += len;
			
			if(readBytes == size) {
				break;
			}
		}
		fos.close();
		
		out.writeInt(Cmd.RES_MESSAGE);
		out.writeUTF("[" + filename + "] 파일의 업로드가 완료되었습니다");
		
	}
}
