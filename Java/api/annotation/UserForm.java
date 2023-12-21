package annotation;

public class UserForm {

	@NotBlank(message = "이름은 필수입력값입니다.")
	private String name;
	
	@NotBlank(message = "아이디는 필수입력값입니다.")
	@Min(value = 5)
	private String id;
	

	@Min(length = 8, message = "비밀번호는 최소 8글자 이상입니다")
	@Max(length = 16, message = "비밀번호는 최대 16글자 이하입니다")
	private String password;
	
	public UserForm(String name, String id, String password) {
		this.name = name;
		this.id = id;
		this.password = password;
	}
}
