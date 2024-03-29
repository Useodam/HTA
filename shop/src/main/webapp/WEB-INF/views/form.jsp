<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/tags.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" ></script>
<title>bootstrap</title>
</head>
<body>
<%@ include file="common/navbar.jsp" %>
<div class="container">
	<div class="row mb-3">
		<div class="col-12">
			<h1>회원가입</h1>
			
			<%--
				<form:form />
					스프링에서 제공하는 <form> 태그다
					<form:form />은 <form /> 태그로 변경된다
					폼 입력값 유효성 체크와 관련된 태그를 포함한다
					- 속성
						modelAttribute
							+ 입력폼의 입력필드에 표현한 값을 가지고 있는 Form 객체의 modelAttribute 이름이다.
							+ 예시
								@GetMapping("/register")
								public String form(Model model) {
									// form.jsp에 "userRegisterForm"이라는 이름으로 UserRegisterForm 객체를 Model에 담아서 전달한다
									// "userRegisterForm"이 modelAttribute name이다.
									model.addAttribute("userRegisterForm", new UserRegisterForm());
									return "form";
								}
								
				<form:checkbox />
               	<form:checkboxes />
               	<form:hidden />
               	<form:input />
	            <form:option />
	            <form:options />
	            <form:password />
	            <form:radiobutton />
	            <form:radiobuttons />
	            <form:select />
	            <form:textarea />
					- 스프링에서 제공하는 폼 입력 필드다
					- 입력필드의 path 속성은 name 속성에 해당한다
					- 입력필드의 path 속성명과 Form 클래스의 필드명이 일치해야 한다
					
				<form:errors />
					- 유효성 체크 오류 메세지를 출력시킨다
					- path 속성은 Form 클래스의 필드명이다
					- path 속성에서 지정한 필드에 저장된 값이 유효성 체크를 위반했을 경우 해당 제약조건에 지정한 오류 메세지를 출력시킨다
					 
			 --%>
			<form:form class="border bg-light p-3" method="post" action="register" modelAttribute="userRegisterForm">
				<%--
				<form:errors path="*" cssClass="text-danger" />
				 --%>
				<div class="form-group mb-3">
					<label class="form-label">아이디</label>
					<form:input class="form-control" path="id" onkeyup="checkUserId()" />
					<form:errors path="id" cssClass="text-danger"></form:errors>
					<span id="id-check-message"></span>
				</div> 
				<div class="form-group mb-3">
					<label class="form-label">비밀번호</label>
					<form:password class="form-control" path="password" />
					<form:errors path="password" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group mb-3">
					<label class="form-label">이름</label>
					<form:input class="form-control" path="name" />
					<form:errors path="name" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group mb-3">
					<label class="form-label">이메일</label>
					<form:input class="form-control" path="email" />
					<form:errors path="email" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group mb-3">
					<label class="form-label">전화번호</label>
					<form:input class="form-control" path="tel" />
					<form:errors path="tel" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group mb-3">
					<label class="form-label">생일</label>
					<form:input type="date" class="form-control" path="birth" />
					<form:errors path="birth" cssClass="text-danger"></form:errors>
				</div>
				
				<div class="text-end">
					<button type="submit" class="btn btn-primary">회원가입</button>
				</div>
			</form:form>
		</div>
	</div>
</div>
<script type="text/javascript">
/*
 * 아이디 입력필드에서 아이디를 입력할 때 마다 실행되는 함수를 정의한다
 * 처리내요
 		1. 아이디 입력필드를 선택한다				<-- let input = document.getElementById("id";)
 		2. 아아디 입력필드에 입력된 값을 조회한다	<-- let userId = input.value
 		3. AJAX 통신에 필요한 XMLHttpRequest 객체를 생성하고, 서버로 요청을 보낸다
 		4. Ajax 요청에 대한 응답을 확인하고, 아이디 중복 여부를 화면에 표시한다
 */
function checkUserId() {
	let sapn = document.getElementById("id-check-message");
	let input = document.getElementById("id");
	let userId = input.value;
	
	if(userId.length<3){
		return;
	}
	
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			let result = xhr.responseText;
			if(result == 'none'){
				span.textContent = "사용가능한 아이디입니다";
			} else if(result == 'exist') {
				span.textContent = "사용할 수 없는 아이디입니다";
			}
		}
	}
	xhr.open("GET", "/user/check?id=" + userId);
	xhr.send(null);
}
</script>
</body>
</html>