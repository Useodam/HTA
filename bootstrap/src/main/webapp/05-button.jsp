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
	<div class="container">
		<div class="row">
			<div class="col-12">
				<h3>버튼</h3>
				<div class="mb-3">
					<button class="btn btn-primary">버튼</button>
					<button class="btn btn-secondary">버튼</button>
					<button class="btn btn-success">버튼</button>
					<button class="btn btn-danger">버튼</button>
					<button class="btn btn-warning">버튼</button>
					<button class="btn btn-info">버튼</button>
					<button class="btn btn-light">버튼</button>
					<button class="btn btn-dark">버튼</button>
				</div>
				<div class="mb-3">
					<button class="btn btn-primary btn-lg">버튼</button>
					<button class="btn btn-secondary btn-lg">버튼</button>
					<button class="btn btn-success btn-lg">버튼</button>
					<button class="btn btn-danger btn-lg">버튼</button>
					<button class="btn btn-warning btn-lg">버튼</button>
					<button class="btn btn-info btn-lg">버튼</button>
					<button class="btn btn-light btn-lg">버튼</button>
					<button class="btn btn-dark btn-lg">버튼</button>
				</div>
				<div class="mb-3">
					<button class="btn btn-primary btn-sm">버튼</button>
					<button class="btn btn-secondary btn-sm">버튼</button>
					<button class="btn btn-success btn-sm">버튼</button>
					<button class="btn btn-danger btn-sm">버튼</button>
					<button class="btn btn-warning btn-sm">버튼</button>
					<button class="btn btn-info btn-sm">버튼</button>
					<button class="btn btn-light btn-sm">버튼</button>
					<button class="btn btn-dark btn-sm">버튼</button>
				</div>
				<div class="mb-3">
					<a href="" class="btn btn-primary">주문</a>
					<a href="" class="btn btn-danger">삭제</a>
					<a href="" class="btn btn-warning">수정</a>
					<input type="button" class="btn btn-primary" value="버튼">버튼
					<input type="reset" class="btn btn-secondary" value="버튼">버튼
					<input type="submit" class="btn btn-primary" value="버튼">버튼
				</div>
				<div class="mb-3">
				<!-- 
					<button>과 <input type="button">의 비활성화
						<button class="btn btn-primary> disabled>버튼</button>
						<input type="button" disabled />
					<a> 링크의 비활성화
						.disabled를 추가한다
						aria-disabled="true"를 추가한다
						tabindex="-1"를 추가한다
						<a href="" class="btn btn-primary disabled">링크</a>
				 -->
					<button class="btn btn-primary" disabled>버튼</button>
					<a href="" class="btn btn-primary disabled" aria-disabled="true" tabindex="-1">링크</a>
				</div>
				
				<div class="mb-3">
					<button class="btn btn-outline-primary">버튼</button>
					<button class="btn btn-outline-secondary">버튼</button>
					<button class="btn btn-outline-success">버튼</button>
					<button class="btn btn-outline-danger">버튼</button>
					<button class="btn btn-outline-warning">버튼</button>
					<button class="btn btn-outline-info">버튼</button>
					<button class="btn btn-outline-light">버튼</button>
					<button class="btn btn-outline-dark">버튼</button>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>