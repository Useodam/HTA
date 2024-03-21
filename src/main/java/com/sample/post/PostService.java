package com.sample.post;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sample.user.User;
import com.sample.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;
	private final UserRepository userRepository;
	private final PostVoterRepository postVoterRepository;
	
	
	/**
	 * 지정된 페이지에 해당하는 게시글 목록을 조회해서 반환한다
	 * @param 조회할 페이지 번호 
	 * @return 전체 게시글 목록
	 */
	public Page<Post> getPosts(int page){
		Pageable pageable = PageRequest.of(page, 10, Sort.by(Sort.Order.desc("id")));
		return postRepository.findAll(pageable);
	}
	
	/**
	 * 지정된 게시글 아이디에 해당하는 게시글 정보를 반환한다
	 * @param id 게시글 아이디
	 * @return 게시글 정보가 포함된 Post 객체, 게시글 정보가 존재하지 않으면 예외를 발생시킨다
	 */
	public Post getPostDetail(Long id) {
		Optional<Post> optional = postRepository.findById(id);
		if(optional.isEmpty()) {
			throw new RuntimeException("게시글 정보가 존재하지 않습니다");
		}
		
		return optional.get();
	}

	/**
	 * 새 게시글 정보가 포함된 PostForm과 사용자 아이디를 전달받아서 게시글 정보를 저장시킨다
	 * @param postForm 새 게시글 정보가 포함된 객체
	 * @param username 사용자 아이디
	 */
	public void createPost(PostForm postForm, String username) {
		
		Optional<User> optional = userRepository.findByUsername(username);
		User user = optional.orElseThrow(() -> new RuntimeException("사용자 정보가 존재하지 않습니다"));
		
		Post post = new Post();
		post.setTitle(postForm.getTitle());
		post.setContent(postForm.getContent());
		post.setUser(user);
		
		postRepository.save(post);
		
	}

	/**
	 * 수정된 정보가 포함된 PostForm과 Post객체를 전달받아서 게시글 정보를 수정한다
	 * @param postForm 수정된 정보가 포함된 객체
	 * @param post 게시글 번호에 해당하는 수정된 정보가 포함된 객체
	 */
	public void updatePost(PostForm postForm, Post post) {
		post.setTitle(postForm.getTitle());
		post.setContent(postForm.getContent());
		
		postRepository.save(post);
	}

	/**
	 * 게시글번호와 사용자아이디를 전달받아서 추천정보를 추가한다
	 * @param id 게시글 번호
	 * @param username 사용자 아이디
	 */
	public void vote(Long id, String username) {
		Post post = getPostDetail(id);
		User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("사용자정보가 존재하지 않습니다"));
		
		// 게시글정보와 사용자정보로 추천정보를 조회한다
		Optional<PostVoter> optional = postVoterRepository.findByPostAndUser(post, user);
		if(optional.isEmpty()) {	// 추천정보가 존재하지 않으면 추천정보를 저장한다
			PostVoter voter = new PostVoter();
			voter.setPost(post);
			voter.setUser(user);
			
			postVoterRepository.save(voter);
		} else {					// 추천정보가 존재하면 
			PostVoter voter = optional.get();
			postVoterRepository.delete(voter);
			
		}
		
	}
}
