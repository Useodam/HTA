<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initail-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
<title>bootstrap</title>
</head>
<body>
<!-- 
	.card
		+ 카드는 유연하고 확장이 가능한 컨테이너다
		+ 카드는 Header, Body, Footer를 포함한다
		+ 카드의 Body는 다양한 컨텐츠를 포함할 수 있다
 -->
	<div class="container">
		<div class="row">
			<div class="col-3">
				<div class="card">
					<img src="resources/sample/KakaoTalk_20231229_151509174.jpg" class="card-img-top" alt="상품표시">
					<div class="card-body">
						<h5 class="card-title">지구를 사랑하자</h5>
						<p class="card-text">사라져 가는 지구의 마지막 색깔들을 찾아서</p>
						<a href="" class="btn btn-primary">상세정보</a>
					</div>
				</div>
			</div>
			
			<div class="col-3">
			<div class="card">
				<div class="card-body">
					입사 후에 코딩 외 업무를 많이하다 보니 프로그래밍 많이 잊어가는 것 같아서.. 
					공부하려고 어떤 강의가 좋은지 찾다가 패스트 캠퍼스 바이트 디그리 : Java&SpringBoot Essential 1기
					 과정이 있길래 마침 필요하고 공부하고 싶던 과정이 있어서 신청해서 지금까지 3주하고 3일차 듣고 있습니다. 
				</div>
			</div>
		</div> <!-- col-3 -->
		
		<div class="col-6">
			<div class="card">
				<div class="card-header">
					교육내용
				</div>
				<div class="card-body">
					<h5 class="card-title">2023년 4분기 교육 내용</h5>
					<p class="card-text">입사 후에 코딩 외 업무를 많이하다 보니 프로그래밍 많이 잊어가는 것 같아서.. </p>
				</div>
				<div class="card-footer text-end">
					<a href="" class="btn btn-outline-primary btn-sm">추가정보</a>
				</div>
			</div>
		</div><!-- col-6 -->
		</div> <!-- row -->
		
		<div class="row mt-3">
			<div class="col-6">
				<div class="card">
					<div class="card-header">직원 현황</div>
					<table class="table">
						<thead>
							<tr>
								<th>번호</th>
								<th>이름</th>
								<th>연락처</th>
								<th>이메일</th>
								<th>부서명</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>100</td>
								<td>고길동</td>
								<td>010-1111-2222</td>
								<td>go@gamil.com</td>
								<td>신기술 연구소</td>
							</tr>
							<tr>
								<td>100</td>
								<td>고길동</td>
								<td>010-1111-2222</td>
								<td>go@gamil.com</td>
								<td>신기술 연구소</td>
							</tr>
							<tr>
								<td>100</td>
								<td>고길동</td>
								<td>010-1111-2222</td>
								<td>go@gamil.com</td>
								<td>신기술 연구소</td>
							</tr>
							<tr>
								<td>100</td>
								<td>고길동</td>
								<td>010-1111-2222</td>
								<td>go@gamil.com</td>
								<td>신기술 연구소</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div> <!-- row mt-3 -->
		
	</div> <!-- container -->
</body>
</html>