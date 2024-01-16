package jdbc2;

import oracle.jdbc.proxy.annotation.Pre;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookDao {

    // 책정보를 저장하는 기능
    // 반환타입 : void
    // 메소드이름 : insertBook
    // 매개변수 : Book book
    public void insertBook(Book book) throws SQLException {
        String sql = """
                insert into sample_books
                (book_no, book_title, book_writer, book_price, book_stock)
                values
                (?,?,?,?,?)
        """;

        Connection connection = getConnection();

        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1,book.getNo());
        pstmt.setString(2, book.getTitle());
        pstmt.setString(3, book.getWriter());
        pstmt.setInt(4,book.getPrice());
        pstmt.setInt(5,book.getStock());

        pstmt.executeUpdate();

        pstmt.close();
        connection.close();
    }

    // 책정보를 수정하는 기능
    // 반환타입 : void
    // 메소드이름 : updateBook
    // 매개변수 : Book book
    public void updateBook(Book book) throws SQLException {

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

        Connection connection = getConnection();

        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,book.getTitle());
        pstmt.setString(2, book.getWriter());
        pstmt.setInt(3,book.getPrice());
        pstmt.setInt(4,book.getStock());
        pstmt.setInt(5,book.getNo());

        pstmt.executeUpdate();

        pstmt.close();
        connection.close();

    }

    // 책정보를 삭제하는 기능
   // 반환타입 : void
   // 메소드명 : deleteBookByNo
   // 매개변수 : int bookNo
   public void deleteBookByNo(int bookNo) throws SQLException {
        String sql = """
            delete from sample_books
            where book_no = ?        
        """;

        Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1,bookNo);

        pstmt.executeUpdate();

        pstmt.close();
        connection.close();

   }


    // 모든 책정보를 조회하는 기능
    // 반환타입 : List<Book>
    // 메소드명 : getAllBooks
    // 매개변수 : 없음
    public List<Book> getAllBooks() throws SQLException {
       String sql = """
               select 
                    book_no, book_title, book_writer, book_price,
                    book_stock, book_reg_date
               from
                    sample_books
               order by
                    book_no desc
               """;

        List<Book> bookList = new ArrayList<>();

        Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            int no = rs.getInt("book_no");
            String title = rs.getString("book_title");
            String writer = rs.getString("book_writer");
            int price = rs.getInt("book_price");
            int stock = rs.getInt("book_stock");
            Date regDate = rs.getDate("book_reg_date");

            Book book = new Book();
            book.setNo(no);
            book.setTitle(title);
            book.setWriter(writer);
            book.setPrice(price);
            book.setStock(stock);
            book.setRegDate(regDate);

            bookList.add(book);
        }

        rs.close();
        pstmt.close();
        connection.close();

       return bookList;
    }



    // 책정보 하나를 조회하는 기능
    // 반환타입 Book
    // 메소드명 : getBookByNo
    // 매개변수 : int bookNo
    public Book getBookNo(int bookNo) throws SQLException {
        String sql = """
                    select 
                    book_no, book_title, book_writer, book_price,
                    book_stock, book_reg_date
               from
                    sample_books
               where
                    book_no = ?
        """;

        Book book = null;
        Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1,bookNo);

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            int no = rs.getInt("book_no");
            String title = rs.getString("book_title");
            String writer = rs.getString("book_writer");
            int price = rs.getInt("book_price");
            int stock = rs.getInt("book_stock");
            Date regDate = rs.getDate("book_reg_date");

            book = new Book();
            book.setNo(no);
            book.setTitle(title);
            book.setWriter(writer);
            book.setPrice(price);
            book.setStock(stock);
            book.setRegDate(regDate);


        }

        rs.close();
        pstmt.close();
        connection.close();

        return book;
    }

    private Connection getConnection() throws SQLException{
        try{
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex.getMessage(),ex);
        }
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "hr";
        String password = "zxcv1234";

        return DriverManager.getConnection(url,user,password);
    }
}
