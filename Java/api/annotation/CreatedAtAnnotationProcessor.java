package annotation;

import java.lang.reflect.Field;
import java.util.Date;

public class CreatedAtAnnotationProcessor {

	/**
	 * 대상 객체에 지정된 어노테이션이 적용되어 있으면
	 * 해당 필드에 현재 날짜와 시간 정보를 표현하는 Date 객체를 생성해서
	 * 대입시킨다
	 * @param target
	 */
	public void process(Object target) {
		// 대상객체의 설계도 정보가 포함된 Class 객체를 획득한다
		Class<?> clazz = target.getClass();
		// 설계도 정보에서 모든 필드 정보를 획득한다.
		Field[] fields = clazz.getDeclaredFields();
		
		// 조회된 모든 필드를 반복하면서 해당 필드에 @CreatedAt 어노테이션이 
		// 지정되어 있는지 조회한다
		for(Field f : fields) {
//			String fieldName = f.getName();
			 boolean isAnnotated = f.isAnnotationPresent(CreatedAt.class);
//			 System.out.println("(" + fieldName + "]" + isAnnotated);
			 if(isAnnotated) {
				 try {
					 // 해당 필드에 현재 날짜정보를 표현하는 Date 객체를 설정한다
					 f.setAccessible(true);
					 f.set(target, new Date());
				 } catch (IllegalAccessException e) {
					// TODO: handle exception
				}
			 }
		}
		
	}
}
