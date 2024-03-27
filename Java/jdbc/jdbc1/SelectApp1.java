package jdbc1;

import java.sql.*;
import java.util.Date;

public class SelectApp1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String sql = """
             SELECT BOOK_NO, BOOK_TITLE, BOOK_WRITER, 
             BOOK_PRICE, BOOK_STOCK, BOOK_REG_DATE
             FROM SAMPLE_BOOKS       
        """;

        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.7:1521:xe","hr","zxcv1234");
        PreparedStatement pstm = con.prepareStatement(sql);
        ResultSet rs= pstm.executeQuery();

        while(rs.next()){
            int no = rs.getInt("book_no");
            String title = rs.getString("book_title");
            String writer = rs.getString("book_writer");
            int price = rs.getInt("book_price");
            int stock = rs.getInt("book_stock");
            Date regDate = rs.getDate("book_reg_date");

            System.out.println("번호 : " + no);
            System.out.println("제목 : " + title);
            System.out.println("저자 : " + writer);
            System.out.println("가격 : " + price);
            System.out.println("재고수량 : " + stock);
            System.out.println("등록일자 : " + regDate);

        }


        rs.close();
        pstm.close();
        con.close();

    }
}
