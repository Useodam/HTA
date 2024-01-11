package net4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;

public class ServerFileDownloadHandler implements Handler{

	@Override
	public void handle(DataInputStream in, DataOutputStream out) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("파일서버가 파일다운로드 요청을 처리함");
		
		String filename = in.readUTF();
		System.out.println("클라이언트가 요청한 파일명 : " + filename);
		
		File file = new File(new File("c:/repo"), filename);
		if(!file.exists()) {
			out.writeInt(Cmd.RES_MESSAGE);
			out.writeUTF("파일이 존재하지 않습니다");
			return;
		}
		
		
		out.writeInt(Cmd.RES_FILE);
		out.writeUTF(filename);
		out.writeLong(file.length());
		
		FileInputStream fis = new FileInputStream(file);
		int len = 0;
		byte[] buf = new byte[1024];
		while( (len = fis.read(buf)) != -1 ) {
			out.write(buf,0,len);
		} 
		fis.close();
		System.out.println("파일서버가 파일다운로드요청을 종료함");
	}
}
