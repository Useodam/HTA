package io3;

import java.io.BufferedReader;
import java.io.FileReader;

public class App1 {

	public static void main(String[] args) throws Exception{
		
		String path = "src/io3/data.csv";
		
		/*
		 * BufferedReader
		 * 	- 다른 Reader와 연결해서 읽기 성능을 향상시키는 스트림
		 * 	- 다른 텍스트를 한 줄씩 읽어오는 readLine() 메소드를 제공한다
		 * 	- 주요 메소드
		 * 		String readLine()
		 * 			- 텍스트 내용을 한 줄씩 읽어오는 스트림이다
		 * 			- 스트림의 끝을 만나면 null을 반환한다
		 * 				- 그러나 다른 메소드들은 -1을 출력시킨다
		 * 			- 텍스트를 읽어올 때 줄바꿈문자 바로 앞까지 읽어온다
		 */
		
		
		// 텍스트 파일을 읽고싶으면 BufferedReader를 떠올려야 한다
		
		BufferedReader reader = new BufferedReader(new FileReader(path));
		
		// BufferedReader의 readLine() 메소드로 읽어온 텍스트를 대입할 변수
		String text = null;
		// (text = reader.readLine()) != null 은
		// reader.readLine()으로 읽어온 텍스트를 text 변수에 대입한다
		// text 변수에 대입된 문자열이 null 아니면 while문의 블록내 수행문을 수행한다
		while( (text = reader.readLine())!= null) {
			
			// 읽어온 문자열을 분석해서 평균점수를 계산하고 출력하는 수행문
			
			// text에 대입된 문자열은 "김유신,100,80,70"과 같은 형태다
			// ","를 구분자로 문자열을 잘라서 배열로 반환받는다
			String [] items = text.split(",");
			// 배열에 저장된 값을 조회하고, 필요한 경우 값을 변환한다
			String name = items[0];
			int kor = Integer.parseInt(items[1]);
			int eng = Integer.parseInt(items[2]);
			int math = Integer.parseInt(items[3]);
			
			int total = kor + eng + math;
			int average = total/3;
			
			System.out.println("이름 : " + name);
			System.out.println("평균 : " + average);
			System.out.println( );
		}
		
		reader.close();
	}
}
