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
			<h1>관리자 홈</h1>
		</div>
		<div class="col-3">
			<div class="card">
				<div class="card-header">관리자 메뉴</div>
				<div class="list-group list-group-flush">
					<a href="/admin/user/list" class="list-group-item list-group-item-action">사용자 관리</a>
					<a href="/admin/product/list" class="list-group-item list-group-item-action">상품 관리</a>
					<a href="" class="list-group-item list-group-item-action">주문 관리</a>
					<a href="" class="list-group-item list-group-item-action">결재 관리</a>
					<a href="" class="list-group-item list-group-item-action">공지사항 관리</a>
				</div>
			</div>
		</div>
		<div class="col-9">
			<table class="table">
				<colgroup>
					<col width="20%">
					<col width="20%">
					<col width="20%">
					<col width="20%">
					<col width="20%">
				</colgroup>
				<thead>
					<tr>
						<th>순번</th>
						<th>사용자번호</th>
						<th>아이디</th>
						<th>이름</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${users }" varStatus="status">
						<tr>
							<td>${status.count }</td>
							<td>${user.no }</td>
							<td>${user.id }</td>
							<td>${user.name }</td>
							<td><button class="btn btn-outline-primary btn-sm" onclick="showUserInfo('${user.id}')">상세보기</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<!-- 부트스트랩 팝업 -->
<div class="modal" tabindex="-1" id="modal-user-info">
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
                     <td><span id="user-no"></span></td>
                     <th>아이디</th>
                     <td><span id="user-id"></span></td>
                  </tr>
                  <tr>
                     <th>이름</th>
                     <td><span id="user-name"></span></td>
                     <th>가입일자</th>
                     <td><span id="user-created-date"></span></td>
                  </tr>
                  <tr>
                     <th>이메일</th>
                     <td><span id="user-email"></span></td>
                     <th>전화번호</th>
                     <td><span id="user-tel"></span></td>
                  </tr>
                  <tr>
                     <th>생일</th>
                     <td colspan="3"><span id="user-birth"></span></td>
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

		// 부트스트랩 모달(팝업창) 객체를 생성한다
		const myModal = new bootstrap.Modal(document.getElementById('modal-user-info'));
		
		// async - 이 함수는 비동기 통신을 수행하는 함수다
		// await - 해당 함수가 처리를 완료할 때까지 기다린다
		
		async function showUserInfo(id){
			let response = await fetch("/admin/users/" + id);
			let user = await response.json();
			
			document.getElementById("user-no").textContent = user.no;
			document.getElementById("user-id").textContent = user.id;
			document.getElementById("user-name").textContent = user.name;
			document.getElementById("user-created-date").textContent = user.createdDate;
			document.getElementById("user-email").textContent = user.email;
			document.getElementById("user-tel").textContent = user.tel;
			document.getElementById("user-birth").textContent = user.birth;
		
			myModal.show();
		}
/*
 * 
	function showUserInfo(id){
		let xhr = new XMLHttpRequest();						// 1. 서버와 HTTP 통신을 하는 XMLHttpRequest 객체를 생성한다
		xhr.onreadystatechange = function() {				// 2. xhr객체의 readyState 값이 변경될 때 마다 실행되는 이벤트 핸들러 함수를 등록한다
			if(xhr.readyState == 4 && xhr.status == 200){	// 5. readyState=4:응답이 왔다. status=200:성공
				let text = xhr.responseText;				// 6. xhr의 responseText 프로퍼티에서 텍스트응답데이터를 조회한다
				console.log(text);
				
				let user = JSON.parse(text);				// 7. user = {no:1001, id:kane, name:해리케인, ...}
				
				document.getElementById("user-no").textContent = user.no;
				document.getElementById("user-id").textContent = user.id;
				document.getElementById("user-name").textContent = user.name;
				document.getElementById("user-created-date").textContent = user.createdDate;
				document.getElementById("user-email").textContent = user.email;
				document.getElementById("user-tel").textContent = user.tel;
				document.getElementById("user-birth").textContent = user.birth;
			
				myModal.show();
			}
			
		}
		xhr.open("GET", "/admin/users/" + id);				// 3. xhr객체를 초기화한다. 요청방식, 요청URL을 지정한다
		xhr.send(null);										// 4. 서버로 요청을 보낸다
		
	}
 */
</script>
</body>
</html>