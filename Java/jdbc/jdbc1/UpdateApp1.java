package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateApp1 {
    public static void main(String[] args) throws Exception {

        String sql = """
                update sample_books
                set
                    book_title = ?,
                    book_writer = ?,
                    book_price = ?,
                    book_stock = ?
                where
                    book_no = ?        
        """;

        // jdbc driver를 메모리에 로딩한다
        Class.forName("oracle.jdbc.OracleDriver");
        // 데이터베이스와 연결을 담당하는 Connection 객체를 획득한다
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","zxcv1234");
        // SQL 전송을 담당하는 PreparedStatemant 객체를 획득한다
        PreparedStatement pstm = con.prepareStatement(sql);
        // SQL의 ?에 바인딩할 값을 순서대로 설정한다
        pstm.setString(1, "이것이 자바다");
        pstm.setString(2, "신용권");
        pstm.setInt(3,31000 );
        pstm.setInt(4, 2);
        pstm.setInt(5, 11);
        // SQL을 데이터베이스 보내서 실행시키고 결과를 반환받는다
        int rowCount = pstm.executeUpdate();
        System.out.println(rowCount + "개의 행이 변경되었습니다");

        // 사용했던 자원을 반납한다.

        pstm.close();
        con.close();


    }
}
