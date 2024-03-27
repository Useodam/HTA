package com.sample.member;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.rest.RestResponse;

import lombok.RequiredArgsConstructor;


/*
 * @RestController
 * 		@Controller + @ResponseBody가 합쳐진 어노테이션이다
 * 		이 어노테이션이 지정된 컨트롤러의 모든 요청핸들러메소드는
 * 		요청핸들러 메소드가 반환하는 값이 응답메세지의 바디부에 포함되어 클라이언트로 전달된다
 * 		ResponseBody은 요청핸들러 메소드가 반환하는 값이 View 사용하지 않고,
 * 		HttpMessageConvertor로 응답 컨텐츠로 변환된다 
 * 
 * @ResponseEntity<T>
 *		HTTP 응답을 표현하는 객체다
 *		HTTP 상태코드와 HTTP 응답데이터를 한번에 표현할 수 있는 객체다
 *		T는 ResponseEntity객체에 담기는 응답에이터의 타입이다 
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	
	@GetMapping("/members")
	public RestResponse<Member> getMembers(){
		List<Member> members = memberService.getAllMembers();
		return RestResponse.getResponse(members);
	}
	
	@PostMapping("/members")
	public RestResponse<Member> createMember(@RequestBody MemberRequest request){
		Member member = memberService.createMember(request);
		
		return RestResponse.getResponse(member);
	}
	
	@GetMapping("/members/{id}")
	public RestResponse<Member> getMember(@PathVariable("id") Long id) {
		
		Member member = memberService.getMember(id);
		return RestResponse.getResponse(member);
		// return ResponseEntity.ok().body(member);
		// return ResponseEntity.ok(member);
		
	}
	
	@DeleteMapping("/members/{id}")
	public RestResponse<Void> deleteMember(@PathVariable("id") Long id) {
		memberService.removeMember(id);
		return RestResponse.getResponse("[" + id + "] 회원정보를 삭제하였습니다");
	}
	
	@PutMapping("/members/{id}")
	public RestResponse<Member> modifyMember(@PathVariable("id") Long id, 
			@RequestBody MemberRequest request){
		Member member = memberService.modifyMember(id, request);
		return RestResponse.getResponse(member);
	}

}
