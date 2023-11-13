package day1;

public class Car {
	
	/*
	 * 멤버변수(필드, 프로퍼티, 인스턴스변수) 정의
	 * 형식
	 * 	자료형 변수명;
	 * 	자료형 변수명 = 값;
	 * 
	 * 	+ 생성된 객체의 고유한 정보를 표현한다.
	 */
	int maxSpeed = 200;
	int currentSpeed;
	
	/*
	 * 멤버메소드(인스턴스 메소드) 정의
	 * 형식
	 * 	반환타입 메소드명(매개변수타입 변수명, 매개변수타입 변수명, ...) {
	 * 		수행문;
	 * 		수행문;
	 * 		
	 * 		return 값;;	// 반환타입이 void인 경우에는 필요없다.
	 * 	}
	 * 	+ 반환타입 : 메소드를 호출한 측에게 제공하는 반환값의 타입이다.
	 * 				 반환값이 없는 경우 void로 지정한다.
	 * 				 반환값이 있는 경우 반환값의 타입을 지정한다
	 * 				 반환타입은 이 메소드를 호출하는 측에게 이 메소드 실행 결과로
	 * 				 획득되는 값의 타입을 알려줌으로써 반환값을 저장할 변수의 타입을
	 * 				 결정할 수 있게 한다.
	 * 	+ 메소드명 : 메소드가 수행하는 기능을 표현하는 적절한 이름으로 지정한다.
	 * 				 식별자 작성 규칙을 따른다.
	 * 	+ 매개변수 : 메소드를 호출하는 측이 인자로 전달한 값을 저장하는 변수다.
	 * 				 매개변수의 타입과 이름을 통해서 인자로 전달할 값과 값의 타입을
	 * 				 유추할 수 있게 한다
	 * 	+ 수행문 : 메소드의 고유 기능을 수행한다.
	 * 	+ return 문 : 메소드의 최종 반환값을 메소드를 호출한 측에게 반환한다
	 * 				  반환타입이 void 가 아닌 경우에는 반드시 값을 반환하는
	 * 				  return 문이 정의되어 있어야 한다
	 */
	
	/**
	 * 자동차의 현재 속도를 10만큼 증가시킨다.
	 */
	void speedUp() {
		System.out.println("현재 속도를 증가시킨다");
		currentSpeed += 10;
		if (currentSpeed > maxSpeed) {
			currentSpeed = maxSpeed;
		}
	}
	
	/**
	 * 자동차의 현재 속도를 10만큼 감소시킨다
	 */
	void speedDown() {		
		System.out.println("현재 속도를 감소시킨다");
		currentSpeed -= 10;
		if(currentSpeed < 0) {
			currentSpeed = 0;
		}
	}
	
	/**
	 * 자동차의 현재 속도를 콘솔창에 출력한다
	 */
	void printCurrentSpeed() {
		System.out.println("현재 속도는 " + currentSpeed + "km/h");
		
	}
	
	/**
	 * 자동차의 현재 속도를 반환한다
	 * @return 자동차의 현재 속도
	 */
	int getCurrentSpeed() {
		System.out.println("현재 속도를 반환한다");
		
		return currentSpeed;
	}
	
	/**
	 * 지정된 속도로 자동차의 현재 속도를 변경한다.
	 * @param speed 변경할 속도값
	 */
	void changeCurrentSpeed(int speed) {
		System.out.println("현재 속도를 변경한다");
		
		currentSpeed = speed;
	}
	
}
