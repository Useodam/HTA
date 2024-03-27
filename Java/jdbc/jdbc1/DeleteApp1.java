package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteApp1 {
    public static void main(String[] args) throws  Exception{

        String sql = """
            
            delete from sample_books
            where book_no = ?                
        """;

        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","zxcv1234");
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setInt(1,10);
        
        int rowCount = pstm.executeUpdate();
        System.out.println(rowCount + "개의 행이 삭제되었습니다");

        pstm.close();
        con.close();
    }
}
