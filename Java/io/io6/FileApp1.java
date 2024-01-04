package io6;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.comparator.LastModifiedFileComparator;

public class FileApp1 {

	public static void main(String[] args) {
		
		File file = new File("src/io6/FileApp1.java");
		
		String filename = file.getName();
		String path = file.getPath();
		long length = file.length();
		String path2 = file.getParent();
		String absolute = file.getAbsolutePath();
		
		System.out.println("파일명 : " + filename);
		System.out.println("경로 : " + path);
		System.out.println("길이 : " + length);
		System.out.println("최종수정일자 : " + new Date(lastModifiedUnixTime());
		System.out.println("경로 : " + path2);
		
	}
}
