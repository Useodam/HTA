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
			<h1>내 주문내역</h1>
			
			<table class="table">
				<colgroup>
					<col width="15%">
					<col width="15%">
					<col width="45%">
					<col width="15%">
					<col width="15%">
				</colgroup>
				<thead>
					<tr>
						<th>순번</th>
						<th>주문내용</th>
						<th>주문날짜</th>
						<th>주문금액</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty dtos }">
							<tr>
								<td colspan="5" class="text-center">주문내역이 없습니다</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="dto" items="${dtos }" varStatus="status">
								<tr>
									<td>${dto.orderNo }</td>
									<td>${dto.description }</td>
									<td><fmt:formatDate value="${dto.orderDate }"/></td>
									<td><fmt:formatNumber value="${dto.totalPrice }"/> 원</td>
									<td><a href="/order/detail${dto.orderNo }" class="btn btn-outline-primary btn-sm">상세보기</a></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>