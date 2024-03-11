<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%--
	<%@page isErrorPage="true" %>
		+ isErrorPage는 이 JSP 페이지를 에러 페이지로 지정하는 속성이다
		+ isErrorPage 속성의 기본값은 false다
		+ 에러 페이지로 사용되는 JSP는 isErrorPage 속성값을 true로 설정한다
		+ isErrorPage를 true로 설정하면 이 JSP의 내장객체에 exception 내장객체가 추가된다
--%>

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
<%@ include file="../common/navbar.jsp" %>
<div class="container">
	<div class="row mb-3">
		<div class="col-12">
			<h1>오류 페이지</h1>
			<p>데이터베이스 엑세스 작업 중 오류가 발생하였습니다</p>
			<p>오류 메세지 : <%=exception.getMessage() %></p>
		</div>
	</div>
</div>
</body>
</html>