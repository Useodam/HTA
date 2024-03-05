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
			
			<form:form class="border bg-light p-3" method="post" action="register" modelAttribute="userRegisterForm">
				<div class="form-group mb-3">
					<label class="form-label">아이디</label>
					<form:input class="form-control" path="id" />
					<form:errors path="id" cssClass="text-danger"></form:errors>
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
</body>
</html>