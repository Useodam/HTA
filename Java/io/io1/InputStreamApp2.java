package io1;

import java.io.FileInputStream;

public class InputStreamApp2 {

	public static void main(String[] args) throws Exception{
		
		FileInputStream in = new FileInputStream("src/io1/app2.txt");
		
//		int value = 0;
//		
//		while((value = in.read()) != -1) {
//			System.out.print((char)value);
//		}
//		
//		in.close();
		
		byte[] buf = new byte[1024];
		int len = 0;
		
		while( (len = in.read(buf))!= -1) {
			String text = new String(buf,0,len);
			System.out.println(text);
		}
		
		in.close();
	}
}
