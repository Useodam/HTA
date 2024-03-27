package jdbc3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class productDao {

    /*
        모든 상품정보를 제공하는 기능
        반환타입 : List<Product>
        메소드명 : getAllProduct
        매개변수 : 없음
     */
    public List<Product> getAllProduct() throws SQLException {
        String sql = """
            SELECT PROD_NO, PROD_NAME, PROD_MAKER, PROD_PRICE, PROD_DISCOUNT_PRICE,
                PROD_STOCK, PROD_SOLD_OUT, PROD_CREATED_DATE, PROD_UPDATED_DATE
            FROM SAMPLE_PRODUCTS
            ORDER BY PROD_NO asc
    """;

        List<Product> prodList = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()){
            int no = rs.getInt("prod_no");
            String name = rs.getString("prod_name");
            String maker = rs.getString("prod_maker");
            int price = rs.getInt("prod_price");
            int discountPrice = rs.getInt("prod_discount_price");
            int stock = rs.getInt("prod_stock");
            String soldOut = rs.getString("prod_sold_out");
            Date createdDate = rs.getDate("prod_created_date");
            Date updatedDate = rs.getDate("prod_updated_date");

            Product p = new Product();
            p.setNo(no);
            p.setName(name);
            p.setMaker(maker);
            p.setPrice(price);
            p.setDiscountPrice(discountPrice);
            p.setStock(stock);
            p.setSoldOut(soldOut);
            p.setCreateDate(createdDate);
            p.setUpdateDate(updatedDate);

            prodList.add(p);
        }

        rs.close();
        pstmt.close();
        connection.close();

        return prodList;

    }

    /*
        상품번호에 해당하는 상품정보를 반환하는 기능
        반환타입 : Product
        메소드명 : getProductByNo
        매개변수 : int no
     */
    public Product getProductByNo(int no) throws SQLException{
        String sql = """
             SELECT PROD_NO, PROD_NAME, PROD_MAKER, PROD_PRICE, PROD_DISCOUNT_PRICE,
                PROD_STOCK, PROD_SOLD_OUT, PROD_CREATED_DATE, PROD_UPDATED_DATE
             FROM SAMPLE_PRODUCTS
             WHERE PROD_NO = ?     
        """;

        Product prod = null;
        Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, no);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()){
            int prodNo = rs.getInt("prod_no");
            String name = rs.getString("prod_name");
            String maker = rs.getString("prod_maker");
            int price = rs.getInt("prod_price");
            int discountPrice = rs.getInt("prod_discount_price");
            int stock = rs.getInt("prod_stock");
            String soldOut = rs.getString("prod_sold_out");
            Date createdDate = rs.getDate("prod_created_date");
            Date updatedDate = rs.getDate("prod_updated_date");

            prod = new Product();

            prod.setNo(prodNo);
            prod.setName(name);
            prod.setMaker(maker);
            prod.setPrice(price);
            prod.setDiscountPrice(discountPrice);
            prod.setStock(stock);
            prod.setSoldOut(soldOut);
            prod.setCreateDate(createdDate);
            prod.setUpdateDate(updatedDate);
        }
        rs.close();
        pstmt.close();
        connection.close();

        return prod;

    }

     /*
        최저가격, 최고가격을 전달받아서 해당 가격범위에 속하는 상품정보를 반환하는 기능
        반환타입 : List<Product>
        메소드명 : getPriceBetween
        매개변수 : int min, int max
     */
    public List<Product> getPriceBetween(int min, int max) throws SQLException {

        String sql = """
             SELECT PROD_NO, PROD_NAME, PROD_MAKER, PROD_PRICE, PROD_DISCOUNT_PRICE,
                PROD_STOCK, PROD_SOLD_OUT, PROD_CREATED_DATE, PROD_UPDATED_DATE
             FROM SAMPLE_PRODUCTS
             WHERE PROD_PRICE BETWEEN ? AND ?     
        """;

        List<Product> prodList = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, min);
        pstmt.setInt(2,max);



        ResultSet rs = pstmt.executeQuery();

        while (rs.next()){
            int no = rs.getInt("prod_no");
            String name = rs.getString("prod_name");
            String maker = rs.getString("prod_maker");
            int price = rs.getInt("prod_price");
            int discountPrice = rs.getInt("prod_discount_price");
            int stock = rs.getInt("prod_stock");
            String soldOut = rs.getString("prod_sold_out");
            Date createdDate = rs.getDate("prod_created_date");
            Date updatedDate = rs.getDate("prod_updated_date");

            Product p = new Product();

            p.setNo(no);
            p.setName(name);
            p.setMaker(maker);
            p.setPrice(price);
            p.setDiscountPrice(discountPrice);
            p.setStock(stock);
            p.setSoldOut(soldOut);
            p.setCreateDate(createdDate);
            p.setUpdateDate(updatedDate);

            prodList.add(p);
        }

        rs.close();
        pstmt.close();
        connection.close();

        return prodList;

    }

      /*
        신규 상품정보를 저장하는 기능
        반환타입 : void
        메소드명 : InsertProduct
        매개변수 : Product product
     */
    public void insertProduct(Product product) throws SQLException {
        String sql = """
            INSERT INTO SAMPLE_PRODUCTS
            (PROD_NO, PROD_NAME, PROD_MAKER, PROD_PRICE, 
            PROD_DISCOUNT_PRICE, PROD_STOCK)
            VALUES (?, ?, ?, ?, ?, ?)       
    """;

        Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setInt(1,product.getNo());
        pstmt.setString(2,product.getName());
        pstmt.setString(3,product.getMaker());
        pstmt.setInt(4,product.getPrice());
        pstmt.setInt(5,product.getDiscountPrice());
        pstmt.setInt(6,product.getStock());


        pstmt.executeUpdate();

        pstmt.close();
        connection.close();
    }


    /*
        상품번호를 전달받아서 해당 상품정보를 삭제하는 기능
        반환타입 : void
        메소드명 : DeleteProduct
        매개변수 : int no
     */
    public void deleteProduct(int no) throws SQLException{

        String sql = """
              DELETE FROM SAMPLE_PRODUCTS
              WHERE PROD_NO = ?
        """;

        Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setInt(1, no);

        pstmt.executeUpdate();

        pstmt.close();
        connection.close();
    }

    /*
        상품번호, 가격, 할인가격을 전달받아서 해당 상품의 가격을 수정하는 기능
        반환타입 : void
        메소드명 : SetPriceProduct
        매개변수 : int no, int price, int discountPrice
     */
    public void changePrice(int price, int discountPrice , int no ) throws SQLException{
        String sql = """
             UPDATE SAMPLE_PRODUCTS
             SET
                PROD_PRICE = ?,
                PROD_DISCOUNT_PRICE = ?
             WHERE PROD_NO = ?       
        """;

        Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setInt(1, price);
        pstmt.setInt(2,discountPrice);
        pstmt.setInt(3,no);

        pstmt.executeUpdate();

        pstmt.close();
        connection.close();
    }


    /*
        상품번호, 수량을 전달받아서 해당상품의 수량을 변경하는 기능
        반환타입 : void
        메소드명 : SetStockProduct
        매개변수 : Product
     */
    public void changeStock(int stock, int no) throws SQLException {
        String sql = """
             UPDATE SAMPLE_PRODUCTS
             SET
                PROD_STOCK = ?
             WHERE PROD_NO = ?                  
        """;

        Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setInt(1,stock);
        pstmt.setInt(2,no);
        pstmt.executeUpdate();

        pstmt.close();
        connection.close();
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
