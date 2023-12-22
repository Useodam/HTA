package annotation2;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * 필드에 지정된 어노테이션을 활용해서 필드값의 유효성을 체크한다
 */
public class FormValidator {

	/**
	 * 지정된 객체의 필드에 대한 유효성 체크를 수행하고, 체크결과를 반환한다
	 * @param target 유효성 체크를 수행할 객체
	 * @return 유효성체크를 통과하지 못한 필드 및 에러 메세지 정보가 저장된 Set 객체 
	 * @throws Exception
	 */
	public Set<FieldError> validate(Object target) throws Exception{
		// 필드유효성 체크를 통과하지 못한 필드에 대한 정보를 저장하는 Set 객체다
		Set<FieldError> errors = new HashSet<FieldError>();
		
		// 대상객체의 설계도를 획득한다
		Class<?> clazz = target.getClass();
		// 대상객체의 모든 필드 정보를 획득한다 
		Field[] fields = clazz.getDeclaredFields();
		// 조회된 모든 필드를 순환하면서 유효성 체크를 수행한다 
		for (Field field : fields) {
			// @Min 어노테이션에 대한 유효성 체크를 수행한다
			// 유효성체크를 통과하지 못한 경우 FiledError 객체가 반환된다
			// 유효성체크를 통과한 경우 null이 반환된다
			FieldError error = checkMin(target, field);
			if (error != null) {
				errors.add(error);
			}
			error = checkMax(target, field);
			if (error != null) {
				errors.add(error);
			}
			error = checkNotBlank(target, field);
			if (error != null) {
				errors.add(error);
			}
		}
		
		return errors;
	}
	/*
	 * Field
	 * 	- 객체의 필드정보를 표현하는 클래스다
	 *  - 필드정보에 포함되는 것
	 *    @NotBlank(message = "이름은 필수입력값입니다")
	 *    private String name;
	 *    
	 *     1. 어노테이션 정보
	 *     2. 접근제한자
	 *     3. 타입
	 *     4. 이름(필드명)
	 *     5. 필드의 값을 조회하고, 변경할 수 있는 메소드
	 *     		조회메소드
	 *     			Object get(Object target)
	 *     		변경메소드
	 *     			void set(Object target, Object value)
	 */
	
	// 문자열의 최소 길이를 검증한다.
	private FieldError checkMin(Object target, Field field) throws Exception {
		// 필드의 이름을 획득한다
		String fieldName = field.getName();
		
		// 지정된 어노테이션 객체를 조회한다
		// 어노테이션이 지정되어 있지 않으면 null을 반환하고,
		// 어노테이션이 지정되어 있으면 어노테이션객체가 반환된다
		Min min = field.getDeclaredAnnotation(Min.class);
		if (min == null) {
			return null;
		}
		
		// @Min 어노테이션의 속성 정보를 조회한다
		int length = min.length();
		
		// 필드에 설정된 값을 조회한다
		// 필드의 접근제한자 private인 경우에도 엑세스가 가능하다록 한다 
		field.setAccessible(true);	
		String value = (String) field.get(target);
		// 값이 null이면 유효성 체크를 하지 않음
		if (value == null) {
			return null;
		}
		// 값이 null이 아니고, 값의 길이가 지정된 길이도 크거나 같으면 null을 반환한다
		// 유효성 체크 통과다
		if (value.length() >= length) {
			return null;
		}
		
		// 유효성 체크를 통과하지 못했기 때문에 Field 객체를 반환한다 
		return new FieldError(fieldName, min.message());		
	}
	
	private FieldError checkMax(Object target, Field field) throws Exception {
		String fieldName = field.getName();
		
		Max max = field.getDeclaredAnnotation(Max.class);
		if (max == null) {
			return null;
		}
		
		int length = max.length();
		
		field.setAccessible(true);
		String value = (String) field.get(target);
		if (value == null) {
			return null;
		}
		
		if (value.length() <= length) {
			return null;
		}
		
		return new FieldError(fieldName, max.message());	
	}
	private FieldError checkNotBlank(Object target, Field field) throws Exception {
		String fieldName = field.getName();
		
		NotBlank notBlank = field.getDeclaredAnnotation(NotBlank.class);
		if (notBlank == null) {
			return null;
		}
		
		field.setAccessible(true);
		String value = (String) field.get(target);
		if (value != null) {
			return null;
		}
		
		return new FieldError(fieldName, notBlank.message());	
	}
}
