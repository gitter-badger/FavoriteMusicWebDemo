<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>

<head>
<title>Home</title>
<script type="text/javascript">
	function login() {
		var user_id = document.login3.userid.value;
		var passwd = document.login3.passwd.value;
		if (user_id == "" || user_id == null) {
			alert("아이디를 다시 입력해 주세요");
			document.getElementById("userid").focus();
		} else if (passwd == "" || passwd == null) {
			alert("비밀번호 다시 입력해 주세요");
			document.getElementById("passwd").focus();
		} else {
			alert("완료");
			document.login3.action = "/web/user/login";
			document.login3.submit();
		}
	}
</script>

</head>
<body>
	<form name="login3" method="post">
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
			<input type="button" value="로그인" class="button" onclick="javascript:login();" />
		</div>
		<div class="info">
			<a class="idsearch" href="#" target="_blank">M!Plan 계정찾기</a> <a
				class="passsearch" href="#" target="_blank">M!Plan 비밀번호찾기</a>
		</div>
	</div>
	</form>
	<p>ⓒ M!Plan Project 1997~2015</p>
	<p>ⓒ VM! Contents Labs 2009~2015</p>

</body>
</html>
