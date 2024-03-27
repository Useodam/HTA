package com.sample.user;

/*
 * UserRole 열거형 객체
 * 		- 사용자가 보유가능한 권한을 표현하는 상수데이터가 정의된 객체다
 * 		- 상수데이터는 UserRole 타입이다.
 * 		- 상수데이터는 UserRole.ROLE_USER, UserRole.USER_ADMIN으로 사용할 수 있다
 * 		- 상수데이터는 0부터 시작해서 순번과 상수데이터의 이름("ROLE_USER", "ROLE_ADMIN")이 상수데이터의 주요한 값이다 
 * 		- 상수데이터에서 상수데이터의 이름이 데이터베이스에서 관리할 값이다
 */
public enum UserRole {

	ROLE_USER, ROLE_ADMIN
}
