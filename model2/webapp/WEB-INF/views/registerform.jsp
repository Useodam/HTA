<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initail-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
<title>모델2</title>
</head>
<body>
<c:set var="menu" value="회원가입" />
<%@include file="common/navbar.jsp" %>
	<div class="container">
		<div class="row mb-3">
			<div class="col-12">
				<h1>회원가입</h1>
				<form class="border bg-light p-3" method="post" action="register.do">
					<div class="form-group mb-3">
						<label class="form-label">아이디</label>
						<input type="text" class="form-control" name="id" />
					</div>
					
					<div class="form-group mb-3">
						<label class="form-label">비밀번호</label>
						<input type="password" class="form-control" name="password" />
					</div>
					
					<div class="form-group mb-3">
						<label class="form-label">이름</label>
						<input type="text" class="form-control" name="name" />
					</div>
					
					<div class="form-group mb-3">
						<label class="form-label">전화번호</label>
						<input type="text" class="form-control" name="tel" />
					</div>
					
					<div class="form-group mb-3">
						<label class="form-label">이메일</label>
						<input type="text" class="form-control" name="email" />
					</div>
					
					<div class="text-end">
						<button type="submit" class="btn btn-primary">회원가입</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>