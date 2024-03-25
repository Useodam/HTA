package com.sample.reply;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sample.post.Post;
import com.sample.post.PostRepository;
import com.sample.post.PostVoter;
import com.sample.user.User;
import com.sample.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyService {

	private final PostRepository postRepository;
	private final ReplyRepository replyRepository;
	private final ReplyVoterRepository replyVoterRepository;
	private final UserRepository userRepository;
	
	/**
	 * 댓글 내용, 게시글번호, 사용자 아이디를 전달받아서 새 댓글을 추가한다
	 * @param content 댓글내용
	 * @param postId 게시글번호
	 * @param username 사용자 아이디
	 */
	public Reply createReply(String content, Long postId, String username) {
		
		Post post = postRepository.findById(postId).orElseThrow();
		User user = userRepository.findByUsername(username).orElseThrow();
		
		Reply reply = new Reply();
		reply.setContent(content);
		reply.setPost(post);
		reply.setUser(user);
		
		return replyRepository.save(reply);
		
	}
	
	
	public Reply getReply(Long replyId) {
		return replyRepository.findById(replyId).orElseThrow();
	}
	
	public void deleteReply(Reply reply) {
		replyRepository.delete(reply);
	}


	public void vote(Long replyId, String username) {
		Reply reply = replyRepository.findById(replyId).orElseThrow();
		User user = userRepository.findByUsername(username).orElseThrow();
		
		// 댓글정보와 사용자정보로 이 댓글에 추천한 정보를 조회한다
		Optional<ReplyVoter> optional = replyVoterRepository.findByReplyAndUser(reply, user);
		if(optional.isEmpty()) {	// 추천정보가 존재하지 않다면
			ReplyVoter voter = new ReplyVoter();	// 새 댓글 추천 엔티티정보를 생성하고, 댓글정보와 사용자정보를 저장한 다음 저장시킨다
			voter.setReply(reply);
			voter.setUser(user);
			replyVoterRepository.save(voter);
			
		} else {					// 추천정보가 존재하면
			ReplyVoter voter = optional.get();	// 위에서 조회한 Optional<ReplyVoter>에서 조회되 ReplyVoter에서 꺼내고, 그 ReplyVoter를 전달해서 삭제시킨다
			replyVoterRepository.delete(voter);
		}
	}
}
