<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initail-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
<title>모델2</title>
</head>
<body>
<c:set var="menu" value="게시판" />
<%@include file="../common/navbar.jsp" %>
<div class="container">
	<div class="row mb-3">
		<div class="col-12">
			<h1>게시글 등록폼</h1>
			
			<form class="border bg-light p-3" method="post" action="insert.do"
				onsubmit="checkBoardform(event)">
				<div class="form-group mb-3">
					<label class="form-label">제목</label>
					<input type="text" class="form-control" name="title"	/>
				</div>
				<div class="form-group mb-3">
					<label class="form-label">내용</label>
					<textarea rows="5" class="form-control" name="content"></textarea>
				</div>
				<div class="text-end">
					<a href="list.do" class="btn btn-secondary">취소</a>
					<button class="btn btn-primary" type="submit">등록</button>
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
	function checkBoardform(event) {
		let answer = confirm("등록하시겠습니까?");
		// 취소 버튼을 클릭한 경우 폼 입력값이 제출되지 않게한다
		if(!answer){
			event.preventDefault();
			return;
		}
		// 확인 버튼을 클릭한 경우 폼 입력값 유효성을 검사한다
		let titleInput = document.querySelector("input[name=title]");
		let title = titleInput.value;
		if(!title){
			event.preventDefault();
			alert("제목은 필수 입력값입니다.");
			titleInput.focus();
			return;
		}
		
		let contentTextarea = document.querySelector("textarea[name=content]");
		let content = contentTextarea.value;
		if(!content){
			event.preventDefault();
			alert("내용은 필수 입력값입니다.");
			contentTextarea.focus();
			return;
		}
		
	}
</script>
</body>
</html>