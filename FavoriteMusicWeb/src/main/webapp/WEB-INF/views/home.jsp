<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<form action="login" method="post">
			<div class="id">
				<input type="text" name="userid" id="userid"
					placeholder="M!Plan 계정 (아이디)">
			</div>
			<div class="pass">
				<input type="password" name="passwd" id="passwd" placeholder="비밀번호">
			</div>
			<div class="checkbox">
				<input type="checkbox" name="checkbox" id="checkbox"> <label
					for="checkbox">로그인 상태 유지 </label>
			</div>
			<div class="button">
				<input type="submit" value="로그인" class="button" />
			</div>
			<div class="info">
				<a class="idsearch" href="#" target="_blank">M!Plan 계정찾기</a> <a
					class="passsearch" href="#" target="_blank">M!Plan 비밀번호찾기</a>
			</div>
			<p>ⓒ M!Plan Project 1997~2015</p>
			<p>ⓒ VM! Contents Labs 2009~2015</p>
		</form>
</body>
</html>
