package net4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;



public class ClientFileDownloadHandler implements Handler{
	
	private Scanner scanner;
	
	public ClientFileDownloadHandler (Scanner scanner) {
		this.scanner = scanner;
	}

	@Override
	public void handle(DataInputStream in, DataOutputStream out) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("파일서버에서 파일다운로드를 요청함");
		
		// 파일서버에서 파일다운로드 요청을 보냄
		out.writeInt(Cmd.REQ_DOWNLOAD);
		
		System.out.print("다운로드할 파일명  입력 : ");
		String filename = scanner.nextString();
		out.writeUTF(filename);
		
		// 파일서버가 파일다운로드 요청에 대해서 보낸 응답을 처리함
		int resCmd = in.readInt();
		if(resCmd == Cmd.RES_MESSAGE) {
			String message = in.readUTF();
			System.out.println("서버 메세지 : "+message);
		} else if (resCmd == Cmd.RES_FILE) {
			String downloadFilename = in.readUTF();
			long size = in.readLong();
			System.out.println("다운로드할 파일이름 : " + downloadFilename);
			System.out.println("다운로드할 파일크기 : " + size);
			
			File file = new File(new File("C:\\Users\\ftisa\\Downloads"), downloadFilename);
			FileOutputStream fos = new FileOutputStream(file);
			
			long readBytes = 0;
			int len = 0;
			byte[] byf = new byte[1024];
			while( (len = in.read(byf)) != -1 ) {
				fos.write(byf,0,len);
				readBytes += len;
				if(readBytes == size) {
					break;
				}
			}
			fos.close();
			System.out.println("파일다운로드가 완료되었습니다");
		}
	}
}
