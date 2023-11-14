package myConstructor;

import constructor.Scanner;

public class ProductManager {
	public static void main(String[] args) {
		
		// 기존 constructor 패키지에 만들어놓은 Scanner 클래스 사용
		Scanner sc = new Scanner(System.in);
		
		// 신규 제품정보를 저장하기 위한 변수
		int savePoint = 0;
		
		// Product 객체를 50개 저장할 수 있는 객체배열 생성 
		Product[] group = new Product[50];
		
		// public Product(int number, String name, String maker, int price)
		group[savePoint++] = new Product(100, "Z Flip5","Samsung",160);
		group[savePoint++] = new Product(101, "A24","Samsung",35);
		group[savePoint++] = new Product(102, "A34","Samsung",45);
		group[savePoint++] = new Product(103, "S23 Ultra","Samsung",140);
		group[savePoint++] = new Product(104, "S23 plus","Samsung",113);
		
		while(true) {
			System.out.println("-----------------------------------------------------------------");
			System.out.println("1.전체조회   2.신규등록   3.검색   4.수정   5.삭제   0.종료");
			System.out.println("-----------------------------------------------------------------");
			
			System.out.println("메뉴를 선택하시오");
			int menu = sc.nextInt();
			
			if(menu == 1) {
				System.out.println("전체조회 메뉴를 선택하셨습니다.");
				
				for(Product p : group) {
					if(p == null) {
						break;
					}
					System.out.printf("%5d %-20s %-10s %5d만원 \n", p.number, p.name, p.maker, p.price);
				}
				
			} else if(menu == 2) {
				System.out.println("신규등록 메뉴를 선택하셨습니다");
				System.out.println("### 신규 제품 정보를 입력하세요");
				
				System.out.println("### 제품번호 입력 : ");
				int number = sc.nextInt();
				
				System.out.println("### 제품명 입력 : ");
				String name = sc.nextString();
				
				System.out.println("### 브랜드 입력 : ");
				String maker = sc.nextString();
				
				System.out.println("### 제품가격 입력 : ");
				int price = sc.nextInt();
				
				System.out.println("### 입고된 수량 입력 : ");
				int stock = sc.nextInt();
				
				Product product = new Product(number, name, maker, price, stock);
				group[savePoint++] = product;
				
				System.out.println("신규 제품이 등록되었습니다");
				
			} else if(menu == 3) {
				System.out.println("상품검색 메뉴를 선택하셨습니다");
				
				System.out.println("### 검색옵션을 선택하세요 (1.상품번호  2.상품이름  3.가격) : " );
				// 검색옵션을 받기 위한 option
				int option = sc.nextInt();
				
				switch(option) {
				case 1 :
					System.out.println("### 상품번호로 검색하기");
					System.out.println("### 검색할 상품의 번호를 입력하세요 : ");
					int productNumber = sc.nextInt();
					
					for(Product p : group) {
						if(p==null) {
							break;
						}
						if (p.number == productNumber	) {
							p.printProduct();
						} 
					}
					break;
					
				case 2 :
					System.out.println("### 상품명으로 검색하기");
					System.out.println("### 검색할 상품의 이름을 입력하세요 : ");
					String productName = sc.nextString();
					
					for(Product p : group) {
						if(p == null){
							break;
						}
						if(p.name.equals(productName)) {
							p.printProduct();
						}
					}
					break;
					
				case 3 :
					System.out.println("### 원하는 가격의 범위로 검색하기");
					System.out.println("### 원하는 최소가격을 입력하세요 : ");
					int minPrice = sc.nextInt();
					System.out.println("### 원하는 최고가격을 입력하세요 : ");
					int maxPrice = sc.nextInt();
					
					for(Product p : group) {
						if(p == null) {
							break;
						}
						if (minPrice <= p.price && p.price <= maxPrice) {
							p.printProduct();
						}
					}
					break;
					
				}	// switch의 끝
			} else if(menu == 4) {
				System.out.println("상품정보 수정 메뉴를 선택하셨습니다.");
				System.out.println("### 수정할 상품의 번호를 입력하세요");
				int productNumber = sc.nextInt();
				
				Product newProduct = null;
				for(Product p : group) {
					if(p==null) {
						break;
					}
					if(p.number == productNumber) {
						newProduct = p;
						break;
					}
				}
				
				if(newProduct == null) {
					System.out.println("### 상품번호에 해당하는 상품정보가 없습니다.");
				} else {
					System.out.println("### 수정할 상품정보를 확인하세요.");
					newProduct.printProduct();
					
					System.out.println("### 이름, 가격, 수량정보를 입력해서 상품정보를 변경하세요.");
					System.out.print("### 상품이름 입력 : ");
					String name = sc.nextString();
					System.out.print("### 상품가격 입력 : ");
					int price = sc.nextInt();
					System.out.print("### 상품수량 입력 : ");
					int stock = sc.nextInt();
					
					newProduct.name = name;
					newProduct.price = price;
					newProduct.stock = stock;
				}
				
			} else if(menu == 5) {
				System.out.println("아직 구현되지 않았습니다. 프로그램을 강제 종료합니다");
				break;
				
			} else if(menu == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		} // while문의 끝
	}
}
