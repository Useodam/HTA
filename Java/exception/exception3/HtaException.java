package exception3;

public class HtaException extends RuntimeException{

	public HtaException(String message) {
		super(message);
	}
	
	public HtaException (Throwable cause) {
		super(cause);
	}
	
	public HtaException (String message, Throwable cause) {
		super(message,cause);
	}
}
