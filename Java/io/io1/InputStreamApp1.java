package io1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class InputStreamApp1 {

	public static void main(String[] args) throws Exception{
	/*
	 * FileInputStream
	 * 	- 파일의 내용을 1byte씩 읽어오는 스트림객체다
	 */

		// src/io1/app1.txt을 읽어오는 FileInputStream 객체를 생성 
		FileInputStream in = new FileInputStream("src/io1/app1.txt");
		
		// 스트림이 읽어오는 데이터를 1바이트씩 읽어오기
		int value = 0;
		
		while((value = in.read()) != -1) {
			System.out.println((char)value);
		}
		in.close();
	}
}
