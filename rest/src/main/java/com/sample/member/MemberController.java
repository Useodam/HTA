package com.sample.member;


import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.rest.RestResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
 *
 *
 * @Tag
 *		- REST API 그룹을 설정하는 어노테이션이다
 *		- 해당 컨트롤러 클래스의 요청핸들러 메소드가 제공하는 REST Api를 같은 그룹으로 설정한다
 *		- 속성
 *			name : REST api 그룹이름을 지정한다.
 *					해당 컨트롤러 클래스가 제공하는 REST api를 대표하는 이름을 지정한다
 *			description : REST api 그룹에 대한 간단한 설명을 추가한다
 *
 * @Operation
 *		- REST API 기능에 대한 상세 정보를 설정하는 어노테이션이다
 *		- 요청핸들러 메소드에 추가하는 어노테이션이다
 *		- 속성
 *				summary : 해당 요청핸들러 메소드가 제공하는 api에 대한 간단한 설명을 추가한다
 *				description : api에 대한 상세설명을 추가한다
 *
 * @ApiResponse
 *		- REST api의 응답 정보를 설정하는 어노테이션이다
 *		- 요청핸들러 메소드에 HTTP 상태코드별로 여러 개를 설정할 수 있다
 *		- 속성
 *			responseCode : HTTP 상태코드를 지정한다
 *			description : 응답에 대한 설명을 추가한다
 *			content : 응답 컨텐츠에 대한 구체적인 정보를 설정한다
 *						@Content 어노테이션을 이용해서 mediaType, schema 등의 정보를 추가할 수 있다
 *
 * @ApiResponses
 *		- 위에서 설명한 @ApiResponse을 여러 개 포함하는 어노테이션이다.
 *		- 요청핸들러 메소드에서 HTTP 상태코드별로 @ApiResponse를 여러 개 정의했을 때 @ApiResponse를 묶기 위한 어노테이션이다
 *
 * @Parameter
 * 		- REST api의 파라미터정보를 설정하는 어노테이션이다
 * 		- 속성
 * 			name : 파라미터 이름을 지정한다
 * 			description : 파라미터의 이름을 지정한다
 * 			required : 필수값 여부를 지정한다
 *
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "회원 API", description = "회원정보 추가, 변경, 삭제, 조회 API을 제공한다 ")
public class MemberController {
	
	private final MemberService memberService;
	
	@Operation(summary = "전체 회원 조회", description = "전체 회원정보를 조회한다")
	@ApiResponses({
		@ApiResponse(responseCode = "200", 
					description = "조회 성공", 
					content = {@Content(mediaType = "application/json", schema = @Schema(implementation = RestResponse.class))
					})
	})
	@Parameters({
		@Parameter(name = "startDate", description = "조회 시작일자", required = false),
		@Parameter(name="endDate", description = "조회 종료일자", required = false)
	})
	@GetMapping("/members")
	public RestResponse<Member> getMembers(
			@RequestParam(name="startDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam(name = "endDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
		
		List<Member> members = memberService.getAllMembers(startDate, endDate);
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
