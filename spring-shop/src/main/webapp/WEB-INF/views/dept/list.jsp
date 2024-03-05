<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			<h1 class="fs-3">부서관리 - 부서 목록 정보</h1>
			<table class="table">
				<thead>
					<tr>
						<th>부서번호</th>
						<th>부서명</th>
						<th>전화번호</th>
						<th>팩스번호</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dept" items="${deptList }">
						<tr>
							<td>${dept.no }</td>
							<td>${dept.name }</td>
							<td>${dept.tel }</td>
							<td>${dept.fax }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div>
				<a href="add" class="text-end btn btn-primary">신규 부서 등록</a>
			</div>
		</div>
	</div><!-- row -->
</div>
</body>
</html>