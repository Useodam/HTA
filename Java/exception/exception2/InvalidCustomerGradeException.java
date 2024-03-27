package exception2;

public class InvalidCustomerGradeException extends RuntimeException{

	public InvalidCustomerGradeException () {}
	
	public InvalidCustomerGradeException (String message) {
		// super(message)는 RuntimeException의 생성자 메소드다
		super(message);
	}
}
