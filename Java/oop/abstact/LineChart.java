package abstraction;

// 구현클래스 정의하기
// 추상 메소드를 보유할 수 없다
// 만약 부모로부터 추상 메소드를 상속받았으면, 반드시 메소드 재정의해야 한다
public class LineChart extends Chart{
	
	// 오버라이드 어노테이션
	// 부모의 메소드를 재정의 하는 것을 나타낸다
	@Override
	public void draw() {
		System.out.println("꺾은선 그래프를 그립니다");
		
	}
}
