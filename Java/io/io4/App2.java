package io4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App2 {

	public static void main(String[] args) throws Exception{
		
		// 키보드로 입력을 한 줄씩 읽어오기
		// Application - BufferedReader - InputStreamReader - InputStream
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("입력 :");
		String text = reader.readLine();
		System.out.println("입력내용 : " + text);
	}
}
