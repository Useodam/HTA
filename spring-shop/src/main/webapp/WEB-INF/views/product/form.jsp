<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/tags.jsp" %>
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
			<h1 class="fs-3">상품관리 - 상품등록</h1>
			
			<form class="border bg-light p-3" method="post" action="create" enctype="multipart/form-data">
				<div class="form-group mb-3">
					<label class="form-label">제조회사</label>
					<select class="form-select" name="companyNo">
						<c:forEach var="company" items="${companyList }">
							<option value="${company.no }">${company.name }</option>					
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group mb-3">
					<label class="form-label">상품명</label>
					<input type="text" class="form-control" name="name" />
				</div>
				<div class="form-group mb-3">
					<label class="form-label">상품가격</label>
					<input type="text" class="form-control" name="price" />
				</div>
				<div class="form-group mb-3">
					<label class="form-label">입고수량</label>
					<input type="text" class="form-control" name="stock" />
				</div>
				<div class="form-group mb-3">
					<label class="form-label">상품사진</label>
					<input type="file" class="form-control" name="photofile" />
				</div>
				<div class="form-group mb-3">
					<label class="form-label">상품설명</label>
					<input type="text" class="form-control" name="description" />
				</div>
				<div class="text-end">
					<button type="submit" class="btn btn-primary">등록</button>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>