package com.sample.post;

import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="board_posts")
@SequenceGenerator(
		name="post_pk_generator",
		sequenceName = "board_posts_seq",
		initialValue = 1000,
		allocationSize = 1
)
@Data

public class Post {

	
	
}
