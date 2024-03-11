<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="tags.jsp" %>
<div class="card">
	<div class="card-header">상품 카테고리</div>
	<div class="list-group">
		<c:forEach var="category" items="${productCategories }">
			<a href="/product/list?catNo=${category.no }" 
			   class="list-group-item list-group-item-action">
			   ${category.name }
			</a>
		</c:forEach>
	</div>
</div>