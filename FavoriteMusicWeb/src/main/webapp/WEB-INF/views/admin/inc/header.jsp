<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<title>Favorite Music Admin :: M!Plan Labs</title>
<meta name="description" content="">
<meta name="author" content="">

<meta name="viewport" content="width=device-width">

<link rel="stylesheet"
	href="/web/resources/admin/_Shared/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/web/resources/admin/css/jqueryui/jquery-ui-1.8.22.custom.css">
<style>
body {
	padding-top: 60px;
	padding-bottom: 40px;
	font-size: 12px;
}
</style>
<link rel="stylesheet"
	href="/web/resources/admin/_Shared/bootstrap/css/bootstrap-responsive.min.css">
<link rel="stylesheet"
	href="/web/resources/admin/_Shared/bootstrap/css/style.css">

<!--[if lt IE 9]>
  <script src="js/libs/html5-3.4-respond-1.1.0.min.js"></script>
  <![endif]-->
</head>
<body>
	<!--[if lt IE 7]><p class=chromeframe>Your browser is <em>ancient!</em> <a href="http://browsehappy.com/">Upgrade to a different browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to experience this site.</p><![endif]-->

	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="#">Favorite Music! 관리자 페이지</a>
				<div class="nav-collapse">
					<ul class="nav">
						<li class="active"><a href="login">Home</a></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">회원관리 <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="blacklist">블랙리스트</a></li>
								<li><a href="memberlist">회원관리</a></li>
								<li><a href="group">등급수정</a></li>
								<li><a href="memberdel">회원탈퇴</a></li>
								<li><a href="membereup">엑셀회원등록</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">라디오관리 <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="proin">프로그램 등록</a></li>
								<li><a href="propage">프로그램 페이지</a></li>
								<li><a href="qsheet">큐시트</a></li>
								<li><a href="data">자료관리</a></li>
								<li><a href="board">게시판</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">음원관리 <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="musinin">음원 등록</a></li>
								<li><a href="musicda">음반사 관리</a></li>
								<li><a href="musicup">음원 수정</a></li>
								<li><a href="musical">앨범 관리</a></li>
								<li><a href="#">test</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">관리자 <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="adnotice">공지사항</a></li>
								<li><a href="adqna">질문 답변</a></li>
								<li><a href="adsns">SNS 등록</a></li>
								<li><a href="adapi">API관리</a></li>
								<li><a href="admail">메일 보내기</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">차트관리 <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="realchart">실시간검색</a></li>
								<li><a href="stchart">스트리밍 차트</a></li>
								<li><a href="downchart">다운로드 차트</a></li>
								<li><a href="allchart">총합 차트</a></li>
								<li><a href="kchart">가요 차트</a></li>
								<li><a href="pchart">팝차트</a></li>
								<li><a href="jchart">일본차트</a></li>
							</ul></li>

					</ul>
					<ul class="nav pull-right">
						<li><a>Admin님께서 접속 하였습니다.</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>


	<script src="/web/resources/admin/_Shared/js/lib/jquery-1.7.2.js"></script>
	<script
		src="/web/resources/admin/_Shared/bootstrap/js/libs/bootstrap/bootstrap.min.js"></script>
	<script src="/web/resources/admin/_Shared/bootstrap/js/plugins.js"></script>
	<script src="/web/resources/admin/_Shared/bootstrap/js/script.js"></script>
	<script src="http://code.jquery.com/ui/1.8.22/jquery-ui.min.js"
		type="text/javascript"></script>
	<script>
		var _gaq = [ [ '_setAccount', 'UA-XXXXX-X' ], [ '_trackPageview' ] ];
		(function(d, t) {
			var g = d.createElement(t), s = d.getElementsByTagName(t)[0];
			g.src = ('https:' == location.protocol ? '//ssl' : '//www')
					+ '.google-analytics.com/ga.js';
			s.parentNode.insertBefore(g, s)
		}(document, 'script'));
	</script>
	<script type="text/javascript">
		
	</script>
</body>
</html>
