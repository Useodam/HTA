<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/tags.jsp" %>
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
			<h1>내 정보</h1>
			
			<table class="table">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="15%">
					<col width="35%">
				</colgroup>
				<tbody>
					<tr>
						<th>아이디</th>
						<td>${user.id }</td>
						<th>사용자번호</th>
						<td>${user.no }</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td>${user.email }</td>
						<th>전화번호</th>
						<td>${user.tel }</td>
					</tr>
					<tr>
						<th>가입일자</th>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${user.createdDate }" /></td>
						<th>수정일자</th>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${user.updatedDate }" /></td>
					</tr>
					<tr>
						<th>생일</th>
						<td colspan="3"><fmt:formatDate pattern="yyyy년 MM월 dd일" value="${user.birth }" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>