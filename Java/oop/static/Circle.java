package static1;

public class Circle {
	
	double r;
	double pi;
	
	public Circle(double r, double pi) {
		this.r = r;
		this.pi = pi;
	}
	
	/**
	 * 원의 둘레 길이를 반환한다
	 * @return 원의 둘레길이
	 */
	public double round() {
		return 2*pi*r;
	}
	
	/**
	 * 원의 넓이를 반환한다
	 * @return 원의 넓이
	 */
	public double area() {
		return pi*r*r;
	}
}
