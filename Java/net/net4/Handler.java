package net4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * 서버측과 클라이언트측에서 요청과 응답을 처리하는 핸들러
 */
public interface Handler {
	
	/**
	 * 서버측과 클라이언트측에서 요청과 응답을 처리하는 메소드다.
	 * @param in
	 * @param out
	 * @throws IOException
	 */
	void handle(DataInputStream in, DataOutputStream out) throws IOException;
}
