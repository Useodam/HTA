package io6;

import java.io.File;

public class FileApp2 {

	public static void main(String[] args) throws Exception {
		
		/*
		 * File 객체 생성하기
		 * 	- File(String path)
		 * 	- File(String parent, String child)
		 * 	- File(File parent, String child)
		 * 
		 * 	+ 현재 존재하지 않는 파일에 대해서 File 객체를 생성할 수 있다
		 * 	+ createNewFile() 메소드는 사이즈가 0인 파일을 생성한다
		 * 	+ mkdir() 메소드는 디렉토리를 생성한다
		 * 	+ mkdir() 메소드는 한번에 하위 디렉토리까지 포함시켜서 생성할 수 있다
		 * 	+ delete() 메소드는 파일, 디렉토리를 삭제한다
		 * 	  디렉토리는 디렉토리 안에 파일이나 하위 디렉토리가 있으면 삭제가 안된다
		 */
		
		File file1 = new File("src/io6/sample1.txt");
		File file2 = new File("src/io6", "sample2.txt");
		File file3 = new File(new File("src/io6"), "sample3.txt");
		
		// 새 파일 만들기 
		file1.createNewFile();
		file2.createNewFile();
		file3.createNewFile();
		
		// 디렉토리 만들기
		File dir1 = new File("src/io6/app");
		File dir2 = new File("src/io6/app2/sample/files");
		dir1.mkdir();
		dir2.mkdirs();
		
		// 파일 삭제하기
		file1.delete();	// sample1.txt가 삭제됨
		
		// 디렉토리 삭제하기
		dir2.delete();	// src/io6/app2/sample/files 경로에서
						// files가 삭제되고, src/io6/app2/sample가 남았다
		dir1.delete();	// 디렉토리를 삭제하기 위해서는 디렉토리 내부에 아무것도 없어야한다
		
	}
}
