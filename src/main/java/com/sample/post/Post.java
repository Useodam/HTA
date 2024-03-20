package com.sample.post;

import java.time.LocalDateTime;

import com.sample.common.BaseDateTimeEntity;
import com.sample.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

/*
 * @ManyToOne
 * 		- N:1(다대일) 연관관계를 표현하는 어노테이션이다 (개발자와 사용자는 다대일 관계다)
 * 		- @ManyToOne 어노테이션이 붙어있는 엔티티가 N이고, 반대 엔티티가 1이다
 * 		  즉, Post 엔티티가 N이고, User 엔티티가 1이다
 * 		- 가장 많이 사용되는 연관관계 표현 어노테이션이다
 * 
 * 		- 추가로 @JoinColumn(name = "N쪽 테이블의 외래컬럼명")
 * 		 본 예시에서는 Boards_POSTS 테이블의 USER_ID 컬럼이다
 */

@Entity
@Table(name="board_posts")
@SequenceGenerator(
		name="post_pk_generator",
		sequenceName = "board_posts_seq",
		initialValue = 1000,
		allocationSize = 1
)
@Data
public class Post extends BaseDateTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_pk_generator")
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable = false)
	private User user;
	
	@Column(nullable = false)
	private String content;
	
	
	
	
}
