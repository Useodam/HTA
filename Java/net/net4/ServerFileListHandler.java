package net4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.StringJoiner;

public class ServerFileListHandler implements Handler{

	@Override
	public void handle(DataInputStream in, DataOutputStream out) throws IOException {
		System.out.println("파일서버가 파일목록요청을 처리함");
		
		File directory = new File("c:/repo");
		String [] filenames = directory.list();
		
		StringJoiner joiner = new StringJoiner("___XXX___");
		
		for(String name : filenames) {
			joiner.add(name);
		}
		String text = joiner.toString();
		
		// 응답 명령어를 보낸다
		out.writeInt(Cmd.RES_FILE_LIST);
		
		// 파일명 목록을 클라이언트로 보내기
		out.writeUTF(text);	// a.txt___XXX___b.png___XXX___doc.pdf
	}
}
