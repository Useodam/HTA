<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/tags.jsp" %>
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
<%@ include file="../../common/navbar.jsp" %>
<div class="container">
	<div class="row mb-3">
		<div class="col-12">
			<h1>상품 관리</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-3">
			<div class="card">
				<div class="card-header">관리자 메뉴</div>
				<div class="list-group list-group-flush">
					<a href="/admin/user/list" class="list-group-item list-group-item-action">사용자 관리</a>
					<a href="/admin/product/list" class="list-group-item list-group-item-action active">상품 관리</a>
					<a href="" class="list-group-item list-group-item-action">주문 관리</a>
					<a href="" class="list-group-item list-group-item-action">결재 관리</a>
					<a href="" class="list-group-item list-group-item-action">공지사항 관리</a>
				</div>
			</div>
		</div>
		<div class="col-9">
			<h3>상품 목록 <a href="create" class="btn btn-primary btn-sm float-end">신규 상품 등록</a></h3>
			<table class="table">
				<colgroup>
					<col width="10%">
					<col width="15%">
					<col width="45%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
				</colgroup>
				<thead>
					<tr>
						<th>순번</th>
						<th>카테고리</th>
						<th>상품이름</th>
						<th>제조사</th>
						<th>가격</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="product" items="${products}" varStatus="status">
						<tr>
							<td>${status.count }</td>
							<td>${product.category.name }</td>
							<td>${product.name }</td>
							<td>${product.company.no }</td>
							<td><fmt:formatNumber value="${product.price }" /> 원</td>
							<td><button class="btn btn-outline-primary btn-sm" onclick="showProductInfo(${product.no})">상세보기</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>


<!-- 부트스트랩 팝업 -->
<div class="modal" tabindex="-1" id="modal-product-info">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <h5 class="modal-title">사용자 상세정보</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
         </div>
         <div class="modal-body">
            <table class="table">
               <tbody>
                  <tr>
                     <th>번호</th>
                     <td><span id="product-no"></span></td>
                     <th>카테고리명</th>
                     <td><span id="category-name"></span></td>
                  </tr>
                  <tr>
                     <th>이름</th>
                     <td><span id="product-name"></span></td>
                     <th>제조사명</th>
                     <td><span id="company-name"></span></td>
                  </tr>
                  <tr>
                     <th>가격</th>
                     <td><span id="product-price"></span></td>
                     <th>수량</th>
                     <td><span id="product-stock"></span></td>
                  </tr>
                  <tr>
                     <th>상태</th>
                     <td colspan="3"><span id="product-status"></span></td>
                  </tr>
                  <tr>
                     <th>제품설명</th>
                     <td colspan="3"><span id="product-description"></span></td>
                  </tr>
               </tbody>
            </table>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
         </div>
      </div>
   </div>
</div>
<script type="text/javascript">
		
		const Modal = new bootstrap.Modal(document.getElementById('modal-product-info'));
		
	function showProductInfo(no){
		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200 ){
				let text = xhr.responseText;
				console.log(text);
				
				let product = JSON.parse(text);
				
				document.getElementById("product-no").textContent = product.no;
				document.getElementById("category-name").textContent = product.category.name;
				document.getElementById("product-name").textContent = product.name;
				document.getElementById("company-name").textContent = product.company.name;
				document.getElementById("product-price").textContent = product.price.toLocaleString();
				document.getElementById("product-stock").textContent = product.stock;
				document.getElementById("product-status").textContent = product.status;
				document.getElementById("product-description").textContent = product.description;
				
				Modal.show();
			}
		}
		xhr.open("GET", "/admin/product/" + no);
		xhr.send(null);
	}
</script>
</body>
</html>