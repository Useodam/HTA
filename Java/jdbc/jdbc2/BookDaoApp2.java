package jdbc2;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BookDaoApp2 {

    public static void main(String[] args) throws SQLException, IOException {

        BookDao bookDao = new BookDao();
        BookDao bookDao2 = new BookDao();

        // 모든 책정보 조회하기
        List<Book> bookList = bookDao.getAllBooks();
        for (Book b : bookList){
            System.out.println(b.getNo() + ", " + b.getTitle());
        }
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.print("검색하고자 하는 책정보 번호를 입력하세요(102, 101, 12, 11) : ");
        int No = scanner.nextInt();
        Book book = bookDao2.getBookNo(No);
        System.out.print(book.getNo() + ", " + book.getTitle() + ", " + book.getWriter());

    }
}
