package com.sample.reply;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	
}
