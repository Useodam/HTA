package com.sample.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * UserRepository
 * 		- 사용자 정보에 대한 데이터베이스 엑세스 작업을 담당하는 인터페이스다
 * 		- Spring Data JPA의 JpaRepository<T, ID> 인터페이스를 상속받아서 작성한다
 * 		- 사용자가 정의한 UserRepository 인터페이스의 구현은 Spring Data JPA가 담당한다
 * 		  즉, 사용자는 인터페이스만 정의하면 된다
 * 		- JpaRepository 인터페이스를 상속받아서 UserRepository 인터페이스를 작성했기 때문에
 * 		  JpaRepository -> ListCrudRepository				-> CrudRepository				-> Repository
 * 						-> ListPagingAndSortingRepository	-> PagingAndSortingRepository	-> Repository
 * 						-> QueryByExampleExecutor
 * 		  JpaRepository 인터페이스 및 그 상위 인터페이스에 정의된 모든 추상화된 메소드들이 재정의된(구현된) 구현객체를
 * 		  Spring Data JPA가 생성해서 스프링 컨테이너의 빈으로 등록한다
 * 
 * XXXRepository 인터페이스 작성방법
 * 		1. JpaRepository<T, ID> 인터페이스를 상속받아서 사용자정의 Repository 인터페이스를 정의한다
 * 		2. JpaRepository 인터페이스의 타입파라미터의 타입을 설정한다
 * 			T : Repository 인터페이스와 관련된 엔티티 클래스를 지정한다
 * 		   ID : Repository 인터페이스와 관련된 엔티티의 기본키 값의 타입을 지정한다
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	boolean existsByUsername(String username);
	boolean existsByEmail(String email);
	
	Optional<User> findByUsername(String username);
	Optional<User> findByEmail(String email);

}
