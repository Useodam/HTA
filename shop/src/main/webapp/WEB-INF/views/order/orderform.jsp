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
			<h1>주문 - 1단계 (주문정보 입력)</h1>
		</div>
	</div>
	<div class="row-mb3">
		<div class="col-3">
		
		</div>
		<div class="col-9">
			<form class="border bg-light p-3"method="post" action="step2">
				<sec:csrfInput/>
				<input type="hidden" name="productNo" value="${product.no }" />
				<div class="form-groub mb-3">
					<label class="form-label">상품이름</label>
					<input type="text" class="form-control" name="name" value="${product.name }" readonly="readonly" />
				</div>
				<div class="form-groub mb-3">
					<label class="form-label">상품가격</label>
					<input type="text" class="form-control" name="price" value="${product.price }"  readonly="readonly" />
				</div>
				<div class="form-groub mb-3">
					<label class="form-label">구매수량</label>
					<input type="text" class="form-control" name="amount" value="1"  />
				</div>
				<div class="form-groub mb-3">
					<label class="form-label">총 구매금액</label>
					<input type="text" class="form-control" name="totalPrice" value="${product.price }"  readonly="readonly" />
				</div>
				<div class="text-end">
					<button type="submit" class="btn btn-primary">다음</button>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>