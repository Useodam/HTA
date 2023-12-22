package annotation2;

public class FieldError {
	
	/**
	 * 유효성 체크를 통과하지 못한 필드의 이름과 에러 메세지를 포함한다
	 */
	private String name;
	private String message;
	
	public FieldError(String name, String message) {
		this.name = name;
		this.message = message;
	}
	
	public String getName() {
		return name;
	}
	public String getMessage() {
		return message;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "FieldError [name=" + name + ", message=" + message + "]";
	}
	
}
