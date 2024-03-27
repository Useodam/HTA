package io6;

import java.io.File;

public class FileApp4 {

	public static void main(String[] args) {
		
		/*
		 * String[] list()
		 * 	- 하위 폴더명 및 파일명을 배열에 담아서 반환한다
		 * 
		 * File[] listFiles()
		 * 	- 하위 폴더 및 파일을 표현한 File 객체를 전부 생성해서 배열에 담아 반환한다 
		 */
		
		File root = new File("c:/");
		
		// 하위 폴더명 및 파일명을 배열에 담아서 반환한다
//		String[] list= root.list();
//		
//		for(String s : list) {
//			System.out.println(s);
//		}
		
		File[] items = root.listFiles();
		for(File item : items) {
			// 숨김파일인지 조사하고, 숨김파일을 출력되지 않게 한다
			if(item.isHidden()) {
				continue;
			} 
			
			// 디렉토리 혹은 파일명을 조회한다
			String name = item.getName();
			
			// item이 표현하는 것이 디렉토리인지 확인한다
			if(item.isDirectory()) {
				System.out.println("[" + name + "]"); 
			} else {
				System.out.println(name);
			}
		}
	}
}
