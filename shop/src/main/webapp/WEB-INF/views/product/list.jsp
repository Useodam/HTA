<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/tags.jsp"%>
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
<%@include file="../common/navbar.jsp"%>
<div class="container">
    <div class="row mb-3">
        <div class="col-12">
            <h1>상품 목록</h1>
        </div>
    </div>
    <div class="row mb-3">
        <div class="col-3">
            <%@include file="../common/category.jsp" %>
        </div>
        <div class="col-9">
            <table class="table">
	            <colgroup>
	               	<col width="10%">
	               	<col width="45%">
	               	<col width="15%">
	               	<col width="15%">
	               	<col width="15%">
	            </colgroup>
                <thead>
                    <tr>
                        <th>순번</th>
                        <th>상품이름</th>
                        <th>제조회사</th>
                        <th>가격</th>
                        <th>상태</th>
                    </tr>
                </thead>
                <tbody>
                	<c:choose>
                		<c:when test="${empty products }">
                			<tr>
                				<td colspan="5" class="text-center">상품존재가 존재하지 않습니다</td>
                			</tr>
                		</c:when>
                		<c:otherwise>
                		<%--
                			<c:forEach var="product" items="${products }" varStatus="status">
                				속성
                					var		- items로 조회한 콜렉션, 배열 객체에 저장된 객체들을 순서대로 하나씩 꺼냈을 때
                							  그 객체가 대입되는 변수명이다
                					 itmes	- 반복처리 대상이 되는 콜렉션, 배열 객체를 컨트롤러에서 모델에 저장할 때 사용했던 이름을 지정하면,
                					 		  그 이름으로 저장된 콜렉션, 배열객체를 조회한다
                					 		  
                					 varStatus - forEach태그로 반복작업을 수행할 때 매 반복시마다 현재 반복작업의 상태정보가 저장되는 객체가 있는데
                					 			 그 객체가 대입되는 변수명이다
                					 			 해당 객체의 주요 프로퍼티
                					 			 	index : 현재 반복처리중인 아이템이나 콜렉션이나 배열에 저장된 index를 출력한다(0부터 시작하는 값)
                					 			 	count : 현재 반복처리중인 작업이 몇번째 반복작업인지를 출력한다(1부터 시작하는 값이다)
                					 			 	first : 현재 반복처리중인 작업이 첫번째 작업인 경우 true를 출력한다
                					 			 	last : 현재 반복처리중인 작업이 마지막번째 작업인 경우 true를 출력한다
                					 			 
                		 --%>
                			<c:forEach var="product" items="${products }" varStatus="status">
                				<tr>
                					<td>${status.count }</td>
                					<td><a href="detail?no=${product.no }">${product.name }</a></td>
                					<td>${product.company.name }</td>
                					<td><fmt:formatNumber value="${product.price }" /> 원</td>
                					<td>${product.status }</td>
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