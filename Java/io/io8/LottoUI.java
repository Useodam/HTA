package io8;

import java.util.List;
import java.util.Set;

public class LottoUI {

	private LottoService service = new LottoService();
	private Scanner scanner = new Scanner(System.in);
	
	private void showMenu() {
		System.out.println("---------------------------------------------------------------------");
		System.out.println("1.구매 2.구매내역조회 3.당첨확인 4.추첨 0.종료");
		System.out.println("---------------------------------------------------------------------");
		
		System.out.print("메뉴선택 :");
		int menuNo = scanner.nextInt();
		System.out.println();
		
		switch(menuNo) {
		case 1: 구매(); break;
		case 2: 구매내역조회(); break;
		case 3: 당첨확인(); break;
		case 4: 추첨(); break;
		case 0: 종료(); break;
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		
	}
	
	
	private void 구매() {
		System.out.println("<< 구매하기 >>");
		
		System.out.println("구매금액을 입력하세요");
		System.out.print("구매금액 : ");
		int orderAmount = scanner.nextInt();
		
		Order order = service.buy(orderAmount);
		
		System.out.println("---------------------------------------------------------------------");
		System.out.println("구매내역");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("회차번호 :" + order.getLottoNo());
		System.out.println("주문번호 :"+ order.getOrderNo());
		System.out.println("---------------------------------------------------------------------");
		List<Set<Integer>> numberList = order.getNumbers();
		
		for(Set<Integer> i : numberList) {
			System.out.println(i);
		}
		System.out.println("---------------------------------------------------------------------");
		
	}
	
	private void 구매내역조회() {
		System.out.println("<< 구매 내역 조회 >>");
		
		System.out.println("회차번호와 주문번호를 입력하세요");
		System.out.print("회차번호 : ");
		int lottoNo = scanner.nextInt();
		System.out.print("주문번호 : ");
		long orderNo = scanner.nextLong();
		
		Order order = service.getOrder(lottoNo, orderNo);
		
		System.out.println("---------------------------------------------------------------------");
		System.out.println("구매내역");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("회차번호 :" + order.getLottoNo());
		System.out.println("주문번호 :"+ order.getOrderNo());
		System.out.println("---------------------------------------------------------------------");
		List<Set<Integer>> numberList = order.getNumbers();
		
		for(Set<Integer> i : numberList) {
			System.out.println(i);
		}
		System.out.println("---------------------------------------------------------------------");
		
	}
	
	private void 당첨확인() {
		System.out.println("<< 당첨 확인 >>");
		
		System.out.println("회차번호와 주문번호를 입력하세요");
		System.out.print("회차번호 :");
		int lottoNo = scanner.nextInt();
		System.out.print("주문번호 :");
		long orderNo = scanner.nextLong();
		
		List<Winning> winnings = service.check(lottoNo, orderNo);
		
		System.out.println("---------------------------------------------------------------------");
		System.out.println("당첨 정보");
		System.out.println("---------------------------------------------------------------------");
		for(Winning w : winnings) {
			System.out.println("로또번호 : " + w.getNumbers());
			System.out.println("당첨여부 : " + w.isWin());
			System.out.println("맞은갯수 : " + w.getCount());
			System.out.println("당첨순위 : " + w.getRank());
			System.out.println("---------------------------------------------------------------------");
		}
		System.out.println("---------------------------------------------------------------------");
	}
	
	private void 추첨() {
		System.out.println("<< 추첨 >>");
		
		System.out.println("### 이번 회차 로또 당첨번호를 추첨합니다.");
		Lotto lotto = service.lotto();
		
		System.out.println("----------------------------------------------");
		System.out.println("["+lotto.getNo()+"] 회차 당첨번호");
		System.out.println(lotto.getNumbers());
		System.out.println("보너스 번호 : " + lotto.getBonus());
		System.out.println("----------------------------------------------");
		
	}
	
	private void 종료() {
		
	}
	
	public static void main(String[] args) {
		LottoUI ui = new LottoUI();
		ui.showMenu();
	}
}
