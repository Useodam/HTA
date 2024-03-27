package net3;

/**
 * 상수를 정의하는 클래스다
 */
public class Command {
	
	/**
	 * 파일 업로드 요청
	 */
	public static final int REQ_UPLOAD = 1; 
	
	/**
	 *  파일 다운로드 요청
	 */
	public static final int REQ_DOWNLOAD = 2;
	
	/**
	 * 파일 목록 요청 
	 */
	public static final int REQ_FILES = 3;
	
	/**
	 * 텍스트 메세지 응답
	 */
	public static final int RES_MESSAGE = 4;
	
	/**
	 * 파일 다운로드 응답
	 */
	public static final int RES_FILE = 5;
	
	/**
	 * 파일 목록응답
	 */
	public static final int RES_FILE_LIST = 6;
}
