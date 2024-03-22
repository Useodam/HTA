package com.sample.reply;

import java.util.Set;

import com.sample.common.BaseDateTimeEntity;
import com.sample.post.Post;
import com.sample.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "board_post_replies")
@SequenceGenerator(
		name = "reply_pk_generator",
		sequenceName = "board_post_replies_seq",
		initialValue = 1,
		allocationSize = 1
		)
@Getter
@Setter
public class Reply extends BaseDateTimeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reply_pk_generator")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "post_id", nullable = false)
	private Post post;
	
	@OneToMany(mappedBy = "reply", cascade = CascadeType.REMOVE)
	private Set<ReplyVoter> replyVoters;

}
