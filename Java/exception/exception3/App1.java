package exception3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App1 {

	// 이 메소드에서 발생하는 FileNotFoundException, IOException을
	// try ~ catch 구문을 이용해서 잡고, 대신 HtaException을 발생시켰다
	public static String readfile() {
		try (BufferedReader reader = new BufferedReader(new FileReader("sample.txt"))){
			String text = reader.readLine();	
			
			return text;
		} catch (FileNotFoundException e) {
			throw new HtaException("sample.txt",e);
		} catch (IOException e) {
			throw new HtaException(e);
		}
	}
	
	// 이 메소드에서 발생한 ParseException을 try ~ catch 구문을 이용해서 잡고
	// 대신 HtaException을 발생시켰다.
	public static Date toDate(String text) {
		try {
			SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
			Date date = simple.parse(text);
			return date;
		} catch (ParseException e) {
			throw new HtaException(text,e);
		}
		
	}
	
	public static void main(String[] args) {
		try {
			String str = readfile();
			System.out.println("읽어온 텍스트 : "+ str);
			
			toDate("dfasfd");
		} catch (HtaException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
