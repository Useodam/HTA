package com.sample.common;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

/*
 * @MappedSuperclass
 * 		- 모든 엔터티가 공통으로 가지는 매핑정보가 정의된 부모 엔티티 클래스임을 나타내는 어노테이션이다
 * 		- 공통 매핑정보가 필요한 엔티티 클래스들은 이 클래스를 상속받는다
 * 		- 이 어노테이션이 정의된 클래스에 대해서는 별도의 테이블이 생성되지 않는다
 * @EntityListeners
 * 		- JPA auditing을 적용할 엔티티 클래스에 이 어노테이션을 적용한다
 * 			* Auditing은 Spring Data JPA에서 제공하는 기능이다
 * 			* Auditing은 엔티티가 생성되고, 변경되는 시점을 감지하여 생성시각, 수정시각, 생성한 사람, 수정한 사람을 기록할 수 있다
 * 		- 이 어노테이션은 엔티티의 변화를 감지하여 엔티티와 매핑된 테이블의 데이터를 조작할 이벤트 리스너를 등록시킨다
 * 		- AuditingEntityListener 클래스는 Spring Data JPA에서 제공하는 이벤트 리스너 클래스다. 엔티티의 영속, 수정 이벤트를 감지한다
 */

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class BaseDateTimeEntity {
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createdDate;
	
	@LastModifiedDate
	private LocalDateTime updatedDate;
	
}
