package jdbc2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Scanner {
    BufferedReader reader;

    /**
     * 입력스트림을 전달받아서 Scanner객체를 초기화한다.
     * @param in
     */
    public Scanner(InputStream in) {
        reader = new BufferedReader(new InputStreamReader(in));
    }

    /**
     * 입력스트림으로 읽어들인 값을 정수로 반환한다.
     * @return 정수
     */
    public int nextInt() {
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * 입력스트림으로 읽어들인 값을 정수로 반환한다.
     * @return 정수
     */
    public long nextLong() {
        try {
            return Long.parseLong(reader.readLine());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * 입력스트림으로 읽어들인 값을 실수로 반환한다.
     * @return 실수
     */
    public double nextDouble() {
        try {
            return Double.parseDouble(reader.readLine());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * 입력스트림으로 읽어들인 값을 문자열로 반환한다.
     * @return 문자열
     */
    public String nextString() {
        try {
            return reader.readLine();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
