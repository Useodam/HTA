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
         <h3>신규 상품 등록</h3>
         <form class="border bg-light p-3" method="post" action="create">
            <sec:csrfInput/>
            <div class="row">
               <div class="col-6">
                  <div class="form-group mb-3">
                     <label class="form-label">상위 카테고리</label>
                     <select class="form-select" name="parentCategoryNo" onchange="changeCategory()">
                        <option value="" selected disabled> 카테고리를 선택하세요</option>                        
                        <c:forEach var="cat" items="${productCategories }">
                           <option value="${cat.no }"> ${cat.name }</option>
                        </c:forEach>
                     </select>
                  </div>
               </div>
               <div class="col-6">
                  <div class="form-group mb-3">
                     <label class="form-label">하위 카테고리</label>
                     <select class="form-select" name="categoryNo">
                        <option value=""> 먼저 상위카테고리를 선택하세요 </option>
                     </select>
                  </div>
               </div>
            </div>
            <div class="row">
               <div class="col-6">
                  <div class="form-group mb-3">
                     <label class="form-label">상품명</label>
                     <input type="text" class="form-control" name="name"/>
                  </div>
               </div>
               <div class="col-6">
                  <div class="form-group mb-3">
                     <label class="form-label">제조회사</label>
                     <select class="form-select" name="companyNo">
                        <option value="" selected disabled>제조회사를 선택하세요</option>
                        <c:forEach var="company" items="${companies }">
                           <option value="${company.no }">${company.name }</option>
                        </c:forEach>
                     </select>
                  </div>
               </div>
            </div>
            <div class="row">
               <div class="col-6">
                  <div class="form-group mb-3">
                     <label class="form-label">상품가격</label>
                     <input type="text" class="form-control" name="price"/>
                  </div>
               </div>
               <div class="col-6">
                  <div class="form-group mb-3">
                     <label class="form-label">입고수량</label>
                     <input type="text" class="form-control" name="amount"/>
                  </div>
               </div>
            </div>
            <div class="form-group mb-3">
               <label class="form-label">상세설명</label>
               <textarea rows="3" class="form-control" name="description"></textarea>
            </div>
            <div class="text-end">
               <button type="submit" class="btn btn-primary">등록</button>
            </div>
         </form>
      </div>
   </div>
</div>
<script type="text/javascript">
   function changeCategory() {
      let parentSelect = document.querySelector("select[name=parentCategoryNo]");
      let sublSelect = document.querySelector("select[name=categoryNo]");
      
      let currentParentCategoryNo = parentSelect.value;
      
      let xhr = new XMLHttpRequest();
      xhr.onreadystatechange = function() {
         if (xhr.readyState == 4 && xhr.status == 200) {
            
            let categories = JSON.parse(xhr.responseText);
            
            let html = "";
            for (let index = 0; index < categories.length; index++) {
               let cat = categories[index];
               
               html += `<option value="\${cat.no}"> \${cat.name}</option>`;
            }
            sublSelect.innerHTML = html;
         }
      }
      xhr.open("GET", "/admin/category?catNo=" + currentParentCategoryNo)
      xhr.send();
   }
</script>
</body>
</html>