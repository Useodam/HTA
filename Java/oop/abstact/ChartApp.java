package abstraction;

public class ChartApp {
	
	public static void main(String[] args) {
		
		// Chart 추상 클래스를 구현한 다양한 구현 클래스로 객체 만들기
		// Chart 추상 클래스를 상속받은 구현클래스들은 전부 차트그리기 기능을
		// draw()라는 메소드명으로 재정의하고 있다
		// 즉, Chart 추상 클래스를 상속받은 구현클래스들은 차트그리기 기능이
		// 동일하다.
		Chart c1 = new LineChart();
		Chart c2 = new BarChart();
		
		// 차트그리기 실행
		c1.draw();
		c2.draw();
	}
}
