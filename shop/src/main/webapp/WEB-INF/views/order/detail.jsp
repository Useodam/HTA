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
			<h1>주문 상세 정보</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-3">
		
		</div>
		<div class="col-9">
			<h3>주문정보 - <small>${dto.description }</small></h3>
			<div class="border p-3 mb-3">
				<table class="table">
					<colgroup>
						<col width="15%">
						<col width="35%">
						<col width="15%">
						<col width="35%">
					</colgroup>
					<tbody>
						<tr>
							<th>주문번호</th>
							<td>${dto.order.no }</td>
							<th>주문날짜</th>
							<td><fmt:formatDate value="${dto.order.orderDate }" pattern="yyyy-MM-dd"/></td>
						</tr>
						<tr>
							<th>주문상태</th>
							<td>${dto.order.status }</td>
							<th>총주문금액</th>
							<td><fmt:formatNumber value="${dto.order.totalPrice }"/> 원</td>
						</tr>
					</tbody>
				</table>
			</div>
			
			<h3>주문상품 정보</h3>
			<div class="border p-3 mb-3">
				<table class="table">
					<colgroup>
						<col width="15%">
						<col width="40%">
						<col width="15%">
						<col width="15%">
						<col width="15%">
					</colgroup>
					<thead>
						<tr>
							<th>순번</th>
							<th>상품명</th>
							<th>가격</th>
							<th>구매수량</th>
							<th>구매가격</th>
						</tr>
					</thead>
					<c:forEach var="item" items="${dto.orderItems }" varStatus="status">
						<tr>
							<td>${status.count }</td>
							<td>${item.product.name }</td>
							<td><fmt:formatNumber value="${item.price }" /> 원</td>
							<td><fmt:formatNumber value="${item.amount }" /> 개</td>
							<td><fmt:formatNumber value="${item.price*item.amount }" /> 원</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			
			
			<h3>결재정보</h3>
			<div class="border p-3 mb-3">
				<table class="table">
					<colgroup>
						<col width="15%">
						<col width="35%">
						<col width="15%">
						<col width="35%">
					</colgroup>
					<tbody>
						<tr>
							<th>결재번호</th>
							<td>${dto.payment.no }</td>
							<th>결재일자</th>
							<td><fmt:formatDate value="${dto.payment.createdDate }" pattern="yyyy-MM-dd"/></td>
						</tr>
						<tr>
							<th>결재금액</th>
							<td><fmt:formatNumber value="${dto.payment.amount }"/> 원</td>
							<th>할부개월수</th>
							<td>${dto.payment.months }</td>
						</tr>
						<tr>
							<th>결재수단</th>
							<td>${dto.payment.type }</td>
							<th>카드번호</th>
							<td>${dto.payment.accNo }</td>
						</tr>
						<tr>
							<th>결재상태</th>
							<td>${dto.payment.status }</td>
							<th>최종수정일</th>
							<td><fmt:formatDate value="${dto.payment.updatedDate }" pattern="yyyy-MM-dd"/></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
</body>
</html>