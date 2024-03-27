package io2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class App3 {

	public static void main(String[] args) throws Exception{
		
		System.out.println("백업 파일 생성 시작 ....");
		long startTime = System.currentTimeMillis();
		
		String src = "C:\\Users\\ftisa\\Downloads\\live.mp4";
		String dest = "C:\\Users\\ftisa\\Downloads\\live_backup_3.mp4";
		
		
		// 버퍼링 기능을 제공하는
		// BufferedInputStream, BufferedOutputStream을 사용해서 읽고 쓰기
		
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest));
		
		
		
		// 1byte씩 읽은 값을 저장하는 변수수
		int value = 0;
		// 입력 스트림의 끝에 도달하기 전까지
		// in.read() 메소드를 1byte를 읽어서 value에 저장한다
		while( (value = in.read())!= -1) {
			// value에 저장된 값을 출력 스트림으로 기록한다
			out.write(value);
		}
	
		in.close();
		out.close();
		
		System.out.println("백업 파일 생성 완료 ....");
		long endTime = System.currentTimeMillis();
		
		long runningTime = endTime - startTime;
		System.out.println("소요시간 : " + runningTime + "밀리초");
	}
}
