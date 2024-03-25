package com.sample.reply;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.sample.post.PostService;
import com.sample.user.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {

	private final ReplyService replyService;
	private final PostService postService;
	private final UserService userService;
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/created/{postId}")
	public String created(@PathVariable("postId") Long postId, @RequestParam("content") String content, Principal principal) {
		
		Reply reply = replyService.createReply(content, postId, principal.getName());
		
		return String.format("redirect:/post/detail?id=%d#reply_%d", postId, reply.getId());
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/delete/{replyId}")
	public String delete(@PathVariable("replyId") Long replyId, Principal principal) {
		Reply reply = replyService.getReply(replyId);
		if(!reply.getUser().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "다른 작성자의 게시글은 수정할 수 없습니다");
		}
		replyService.deleteReply(reply);
		
		return String.format("redirect:/post/detail?id=%d", reply.getPost().getId());
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/vote/{replyId}")
	public String vote(@PathVariable("replyId") Long replyId, Principal principal) {
		Reply reply = replyService.getReply(replyId);
		replyService.vote(replyId, principal.getName());
		
		return String.format("redirect:/post/detail?id=%d#reply_%d", reply.getPost().getId(), reply.getId());
	}
	
	
}
