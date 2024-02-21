<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-light">
	<div class="container">
		<ul class="navbar-nav me-auto">
			<li class="nav-item me-auto">
				<a class="nav-link ${menu eq '홈' ? 'active' : '' }" href="/home.do">홈</a>
			</li>
			<li class="nav-item">
				<a class="nav-link ${menu eq '게시판' ? 'active' : '' }" href="/board/list.do?page=1">게시판</a>
			</li>
		</ul>
		<c:if test="${not empty LOGIN_USER }">
			<span class="navbar-text me-3"><strong>${LOGIN_USER.name }</strong>님 환영합니다</span>
		</c:if>
		
		<ul class="navbar-nav ">
		<c:if test="${empty LOGIN_USER }">
			<li class="nav-item">
				<a class="nav-link ${menu eq '로그인' ? 'active' : '' }" href="/login.do">로그인</a>
			</li>
		</c:if>
		<c:if test="${not empty LOGIN_USER }">
			<li class="nav-item">
				<a class="nav-link" href="/logout.do">로그아웃</a>
			</li>
		</c:if>
		<c:if test="${empty LOGIN_USER }">
			<li class="nav-item">
				<a class="nav-link ${menu eq '회원가입' ? 'active' : '' }" href="/register.do">회원가입</a>
			</li>
		</c:if>
		</ul>
	</div>
</nav>