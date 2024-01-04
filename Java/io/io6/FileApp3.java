package io6;

import java.io.File;

public class FileApp3 {

	public static void main(String[] args) {
		
		File file = new File("src/io6/app.txt");
		
		boolean isExists = file.exists();
		System.out.println("파일이 존재하는가? : " + isExists);
	}
}
