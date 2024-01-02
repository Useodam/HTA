package io2;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.IOUtils;

public class App4 {

	public static void main(String[] args) throws Exception{
		
		String src = "C:\\Users\\ftisa\\Downloads\\live.mp4";
		String dest = "C:\\Users\\ftisa\\Downloads\\live_backup_4.mp4";
		
		// apache-commons-io 라이브러리를 사용해서 읽고 쓰기 
		FileInputStream in = new FileInputStream(src);
		FileOutputStream out = new FileOutputStream(dest);
		
		IOUtils.copy(in,out);
	}
}
