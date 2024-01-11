package net4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ClientFileListHandler implements Handler {

	@Override
	public void handle(DataInputStream in, DataOutputStream out) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("<< 파일서버의 파일목록을 요청함 >>");
		out.writeInt(Cmd.REQ_FILE_LIST);
		
		int cmd = in.readInt();
		if(cmd != Cmd.RES_FILE_LIST) {
			return;
		}
		
		String text = in.readUTF();
		String[] items = text.split("___XXX___");
		
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("파일서버의 파일목록");
		System.out.println("--------------------------------------------------------------------------------");
		
		for(String item : items) {
			System.out.println(item);
		}
		System.out.println("--------------------------------------------------------------------------------");
	}
}
