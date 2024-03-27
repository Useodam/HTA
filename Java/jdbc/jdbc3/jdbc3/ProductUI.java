package jdbc3;

import java.sql.SQLException;
import java.util.List;

public class ProductUI {

	private productDao productDao = new productDao();
	private scanner scanner = new scanner(System.in);
	
	public void showMenu() {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("1.전체조회 2.상세조회 3.검색(가격) 4.신규등록 5.삭제 6.가격수정 7.재고수정 0.종료");
		System.out.println("----------------------------------------------------------------------------------");
		
		System.out.print("### 메뉴번호: ");
		int menuNo = scanner.nextInt();
		
		try {
			switch(menuNo)  {
			case 1: 전체조회(); break;
			case 2: 상세조회(); break;
			case 3: 검색(); break;
			case 4: 신규등록(); break;
			case 5: 삭제(); break;
			case 6: 가격수정(); break;
			case 7: 재고수정(); break;
			case 0: 종료(); break;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println();
		System.out.println();
		showMenu();
	}
	
	private void 전체조회() throws SQLException {
		System.out.println("<< 상품 전체 조회 >>");
		List<Product> productList = productDao.getAllProduct();

		if (productList.isEmpty()){
			System.out.println("에러. 상품정보가 존재하지 않습니다");
			return;
		}

		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("상품번호\t상품이름\t브랜드\t가격\t할인가격\t수량\t판매여부\t등록일\t수정일");
		System.out.println("-----------------------------------------------------------------------------");

		for(Product p : productList){
			System.out.print(p.getNo() + "\t");
			System.out.print("\t" + p.getName() + "\t");
			System.out.print(p.getMaker() + "\t");
			System.out.print(p.getPrice() + "\t");
			System.out.print("\t" + p.getDiscountPrice() + "\t");
			System.out.print("\t" +p.getStock() + "\t");
			System.out.print("\t" +p.getSoldOut() + "\t");
			System.out.print("\t" +p.getCreateDate() + "\t");
			System.out.println(p.getUpdateDate() + "\t");

		}
		System.out.println();
		System.out.println();
	}
	
	private void 상세조회() throws SQLException {
	
		System.out.println("<< 상품 상세 조회 >>");
		System.out.print("상품번호를 입력하세요 : ");
		int no = scanner.nextInt();

		Product prod = productDao.getProductByNo(no);
		if(prod == null){
			System.out.println("상품번호 [" + no + "]가 존재하지 않습니다");
			return;
		}
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("상품이름 : " + prod.getName());
		System.out.println("브랜드 : " + prod.getMaker());
		System.out.println("상품가격 : " + prod.getPrice());
		System.out.println("할인가격 : " + prod.getDiscountPrice());
		System.out.println("상품수량 : " + prod.getStock());
		System.out.println("판매여부 : " + prod.getSoldOut());
		System.out.println("등록일 : " + prod.getCreateDate());
		System.out.println("수정일 : " + prod.getUpdateDate());
		System.out.println("-----------------------------------------------------------------------------");

	}
	
	private void 검색() throws SQLException {

		System.out.println("<< 가격 범위 안에 있는 상품 검색 >>");
		System.out.print("가격의 최소값을 입력하세요 : ");
		int min = scanner.nextInt();
		System.out.print("가격의 최대값을 입력하세요 : ");
		int max = scanner.nextInt();

		List<Product> product = productDao.getPriceBetween(min, max);

		if(product.isEmpty()){
			System.out.println("해당 가격 범위내의 있는 상품이 없습니다");
			return;
		}

		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("상품번호\t상품이름\t브랜드\t가격\t할인가격\t수량\t판매여부\t등록일\t수정일");
		System.out.println("-----------------------------------------------------------------------------");

		for(Product p : product){
			System.out.print(p.getNo() + "\t");
			System.out.print("\t" + p.getName() + "\t");
			System.out.print(p.getMaker() + "\t");
			System.out.print(p.getPrice() + "\t");
			System.out.print("\t" + p.getDiscountPrice() + "\t");
			System.out.print("\t" +p.getStock() + "\t");
			System.out.print("\t" +p.getSoldOut() + "\t");
			System.out.print("\t" +p.getCreateDate() + "\t");
			System.out.println(p.getUpdateDate() + "\t");

		}
	}
	
	private void 신규등록() throws SQLException {

		System.out.println("<< 상품 신규 등록 >>");
		System.out.print("신규 상품 번호를 입력하세요 : ");
		int no = scanner.nextInt();
		System.out.print("신규 상품 이름을 입력하세요 : ");
		String name = scanner.nextString();
		System.out.print("신규 상품 브랜드를 입력하세요 : ");
		String maker = scanner.nextString();
		System.out.print("신규 상품 가격을 입력하세요 : ");
		int price = scanner.nextInt();
		System.out.print("신규 상품 할인가격을 입력하세요 : ");
		int discountPrice = scanner.nextInt();
		System.out.print("신규 상품 재고수량을 입력하세요 : ");
		int stock = scanner.nextInt();

		Product p = new Product();
		p.setNo(no);
		p.setName(name);
		p.setMaker(maker);
		p.setPrice(price);
		p.setDiscountPrice(discountPrice);
		p.setStock(stock);


		productDao.insertProduct(p);
		System.out.println("신규 상품 등록을 완료했습니다");

	}
	
	private void 삭제() throws SQLException {
		System.out.println("<< 상품 삭제 >>");
		System.out.print("삭제하고자 하는 상품 번호를 입력하세요 :");
		int no = scanner.nextInt();

		productDao.deleteProduct(no);

		System.out.println("해당 상품이 삭제되었습니다");
	}
	
	private void 가격수정() throws SQLException {
		System.out.println("<< 상품 가격 수정 >>");
		System.out.print("상품 가격을 수정하고자 하는 상품 번호를 입력하세요 : ");
		int no = scanner.nextInt();
		System.out.print("해당 상품의 가격 변경 값을 입력하세요 : ");
		int price = scanner.nextInt();
		System.out.print("해당 상품의 할인가격 변경 값을 입력하세요 :");
		int discountPrice = scanner.nextInt();

		productDao.changePrice(price,discountPrice, no);

		System.out.println("상품 가격이 바뀌었습니다");
	}
	
	private void 재고수정() throws SQLException {
		System.out.println("<< 상품 재고 수정 >>");
		System.out.print("재고 수정할 상품의 상품 번호를 입력하세요 : ");
		int no = scanner.nextInt();
		System.out.print("상품의 재고값을 입력하세요 : ");
		int stock = scanner.nextInt();

		productDao.changeStock(stock,no);

		System.out.println("상품 재고가 바뀌었습니다");
	}
	
	private void 종료() {
		System.out.println("프로그램을 종료합니다");
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new ProductUI().showMenu();
	}
	
}
