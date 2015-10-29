<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!doctype html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=euc-kr" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="stylesheet" href="resources/mplan/css/style.css">
<script
	src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="resources/mplan/js/index.js"></script>
<title>Favorite Music Admin Page</title>
</head>
<!-- login -->
<script type="text/javascript">
	function login() {
		var user_id = document.login3.j_username.value;
		var passwd = document.login3.j_password.value;
		if (user_id == "" || user_id == null) {
			alert("아이디를 다시 입력해 주세요");
			login3.getElementById("userid").focus();
		} else if (passwd == "" || passwd == null) {
			alert("비밀번호 다시 입력해 주세요");
			login3.getElementById("passwd").focus();
		} else {
			alert("완료");
			login3.submit();
		}
	}
</script>
<!--  video/195550.mp4 -->
<!-- Video -->
<video id="movie" poster="ittank.png" preload="auto" autoplay loop>
	<source src="https://r13---sn-oguesnll.c.docs.google.com/videoplayback?requiressl=yes&id=ff84adabedf6d0b1&itag=22&source=webdrive&app=texmex&ip=183.99.41.67&ipbits=8&expire=1446119395&sparams=requiressl,id,itag,source,ip,ipbits,expire&signature=77736C1073D1722F693628595B1A348D263C35D1.6AB029FA0CB55135786A6140AC2C92CEB32146E5&key=ck2&mm=30&mn=sn-oguesnll&ms=nxu&mt=1446114135&mv=m&nh=IgpwcjAxLm5ydDE5KgkxMjcuMC4wLjE&pl=18&cpn=VDYUZYpcz85R3QLK&c=WEB&cver=html5" type="video/mp4">
</video>

<body>
	<div id="polina">
		<h1>VM! Sound Admin Login</h1>
		<form name="login3" action="j_spring_security_check" method="post">
			<div class="id">
				<input type="text" name="j_username" id="userid"
					placeholder="M!Plan 계정 (아이디)">
			</div>
			<div class="pass">
				<input type="password" name="j_password" id="passwd" placeholder="비밀번호">
			</div>
			<div class="checkbox">
				<input type="checkbox" name="checkbox" id="checkbox"> <label
					for="checkbox">로그인 상태 유지 </label>
			</div>
			<div class="button">
				<div class="button">
					<input type="button" value="로그인" class="button"
						onclick="login()" />
				</div>
			</div>
			<div class="info">
				<a class="idsearch" href="#" target="_blank">M!Plan 계정찾기</a> <a
					class="passsearch" href="#" target="_blank">M!Plan 비밀번호찾기</a>
			</div>
			<p>ⓒ M!Plan Project 1997~2015</p>
			<p>ⓒ VM! Contents Labs 2009~2015</p>
		</form>
	</div>
</body>
</html>
