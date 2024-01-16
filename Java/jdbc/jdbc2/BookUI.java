package jdbc2;

import java.sql.SQLException;
import java.util.List;

public class BookUI {

    private BookDao bookDao = new BookDao();
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() throws SQLException {
        System.out.println("----------------------------------------------------------------");
        System.out.println("1.전체조회 2.상세조회 3.등록 4.수정 5.삭제 0.종료");
        System.out.println("----------------------------------------------------------------");

        System.out.print("메뉴선택 : ");
        int menuNo = scanner.nextInt();
        try{

            switch (menuNo){
                case 1: 전체조회(); break;
                case 2: 상세조회(); break;
                case 3: 등록(); break;
                case 4: 수정(); break;
                case 5: 삭제(); break;
                case 0: 종료(); break;
            }
        } catch (SQLException e){
            System.out.println("데이터베이스 작업중 오류가 발생하였습니다");
        }
        System.out.println();
        System.out.println();
        System.out.println();

        showMenu();
    }

    private void 전체조회() throws SQLException{
        System.out.println("<< 전체 도서 조회 >>");
         List<Book> books = bookDao.getAllBooks();

         if(books.isEmpty()){
             System.out.println("-- 도서 정보가 존재하지 않습니다 --");
             return;
         }

        System.out.println("----------------------------------------------------------------");
        System.out.println("번호\t가격\t저자\t제목");
        System.out.println("----------------------------------------------------------------");


        for(Book b : books){
            System.out.print(b.getNo() + "\t");
            System.out.print("\t"+b.getPrice());
            System.out.print("\t"+b.getWriter());
            System.out.println("\t"+b.getTitle());
        }
        System.out.println("----------------------------------------------------------------");
    }

    private void 상세조회()throws SQLException{
        System.out.println("<< 도서 정보 상세 조회 >>");

        System.out.print("책번호를 입력하세요 : ");
        int bookNo = scanner.nextInt();

        Book b = bookDao.getBookNo(bookNo);
        if (b == null){
            System.out.println("[" + bookNo + "] 책정보가 존재하지 않습니다");
            return;
        }

        System.out.println("----------------------------------------------------------------");
        System.out.println("번호 : " +b.getNo());
        System.out.println("제목 : " +b.getTitle());
        System.out.println("저자 : " +b.getWriter());
        System.out.println("가격 : " +b.getPrice());
        System.out.println("수량 : " +b.getStock());
        System.out.println("등록일 : " +b.getRegDate());
        System.out.println("----------------------------------------------------------------");

    }

    private void 등록()throws SQLException{
        System.out.println("<< 신규 도서 등록 >>");
        System.out.println("-- 신규 도서 정보를 입력하세요 --");
        System.out.print("번호 : ");
        int no = scanner.nextInt();
        System.out.print("제목 : ");
        String title = scanner.nextString();
        System.out.print("저자 : ");
        String writer = scanner.nextString();
        System.out.print("가격 : ");
        int price = scanner.nextInt();
        System.out.print("수량 : ");
        int stock = scanner.nextInt();

        Book bo = new Book();
        bo.setNo(no);
        bo.setTitle(title);
        bo.setWriter(writer);
        bo.setPrice(price);
        bo.setStock(stock);

        bookDao.insertBook(bo);
        System.out.println("신규 도서를 등록하였습니다");
    }

    private void 수정()throws SQLException{

    }

    private void 삭제() throws SQLException{
        System.out.println("<< 도서 정보 삭제 >>");
        System.out.println("-- 책번호를 입력받아서 책정보를 삭제합니다");

        System.out.print("책번호 입력 : ");
        int no = scanner.nextInt();

        bookDao.deleteBookByNo(no);

        System.out.println("책번호 : [" + no + "] 책정보가 삭제되었습니다");
    }
    private void 종료(){
        System.out.println("프로그램을 종료합니다");
        System.exit(0);
    }
    public static void main(String[] args) throws Exception {
        new BookUI().showMenu();
    }

}
