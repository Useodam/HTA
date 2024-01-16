package jdbc2;

public class BookDaoApp {
    public static void main(String[] args) throws Exception {

        Book b1 = new Book();
        b1.setNo(101);
        b1.setTitle("자바의 정석 기초편");
        b1.setWriter("남궁성");
        b1.setPrice(28000);
        b1.setStock(30);

        Book b2 = new Book();
        b2.setNo(102);
        b2.setTitle("개발자를 위한 DevOps");
        b2.setWriter("진명조");
        b2.setPrice(25000);
        b2.setStock(5);

        BookDao dao = new BookDao();
        dao.insertBook(b1);
        dao.insertBook(b2);
    }
}
