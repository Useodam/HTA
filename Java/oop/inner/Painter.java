package inner;

/**
 * 그림판 클래스
 */
public class Painter {

	// 전달받은 Shape 구현객체의 도형그리기
	public void drawShape(Shape shape) {
		shape.draw();
	}
}
