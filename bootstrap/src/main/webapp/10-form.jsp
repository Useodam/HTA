<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" ></script>
<title>bootstrap</title>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-6">
			<h3>다양한 폼 컨트롤(폼입력 양식 태그)</h3>
			
			<form class="border p-3 bg-light">
				<div class="mb-3">
					<label class="form-label">텍스트 입력필드</label>
					<input type="text" class="form-control" name="a"/>
				</div>
				<div class="mb-3">
					<label class="form-label">비밀번호 입력필드</label>
					<input type="password" class="form-control" name="b"/>
				</div>
				<div class="mb-3">
					<label class="form-label">첨부파일 입력필드</label>
					<input type="file" class="form-control" name="c"/>
				</div>
				<div class="mb-3">
					<label class="form-label">멀티라인 입력필드</label>
					<textarea rows="5" class="form-control" name="d"></textarea>
				</div>
				<div class="mb-3">
					<label class="form-label">셀렉트 박스</label>
					<select class="form-select" name="e">
						<option value="" selected disabled> 선택하세요</option>
						<option value="10"> 서울</option>
						<option value="20"> 부산</option>
						<option value="30"> 인천</option>
						<option value="40"> 대구</option>
					</select>
				</div>
				<div class="mb-3">
					<label class="form-label">체크박스</label>
					<div>
						<div class="form-check form-check-inline">
	  						<input class="form-check-input" type="checkbox" name="f" value="java">
	  						<label class="form-check-label" >자바</label>
						</div>
						<div class="form-check form-check-inline">
	  						<input class="form-check-input" type="checkbox" name="f" value="python">
	  						<label class="form-check-label" >파이썬</label>
						</div>
						<div class="form-check form-check-inline">
	  						<input class="form-check-input" type="checkbox" name="f" value="kotlin">
	  						<label class="form-check-label" >코틀린</label>
						</div>
					</div>
				</div>
				<div class="mb-3">
					<label class="form-label">라디오 박스</label>
					<div>
						<div class="form-check form-check-inline">
	  						<input class="form-check-input" type="radio" name="g" value="male">
	  						<label class="form-check-label" >남자</label>
						</div>
						<div class="form-check form-check-inline">
	  						<input class="form-check-input" type="radio" name="g" value="female">
	  						<label class="form-check-label" >여자</label>
						</div>
						<div class="form-check form-check-inline">
	  						<input class="form-check-input" type="radio" name="g" value="etc">
	  						<label class="form-check-label" >기타</label>
						</div>
					</div>
				</div>
			</form>
		</div>
		<div class="col-6"></div>
	</div><!-- row -->
</div><!-- container -->
</body>
</html>


