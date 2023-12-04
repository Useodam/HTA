package inner;

public class PainterApp {

	public static void main(String[] args) {
		
		Painter painter = new Painter();
		
		Shape shape1 = new  Shape() {
			
			@Override
			public void draw() {
				System.out.println("동그라미 그리기");
			}
		};
		
		Shape shape2 = new Shape() {
			
			@Override
			public void draw() {
				System.out.println("삼각형 그리기");
			}
		};
		
		painter.drawShape(shape1);
		painter.drawShape(shape2);
		painter.drawShape(new Shape() {
			public void draw() {
				System.out.println("사각형 그리기");
			}
		});
		
		painter.drawShape(new Shape() {
			
			@Override
			public void draw() {
				System.out.println("오각형 그리기");
				
			}
		});
		
		// 람다식
		// 익명객체를 정의할때 람다식으로 정의하는게 더 편하다
		painter.drawShape(()->System.out.println("육각형 그리기"));
	}
}
