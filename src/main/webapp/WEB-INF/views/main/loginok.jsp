<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Favorite Music</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"
	type="text/javascript"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
	type="text/javascript"></script>
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />

<meta http-equiv="Content-Type" content="text/html" charset="UTF-8" />

<style>
.ui-autocomplete {
	position: absolute;
	cursor: default;
	height: 200px;
	overflow-y: scroll;
	overflow-x: hidden;
}
</STYLE>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#testText")
								.autocomplete(
										{
											source : function(request, response) {
												$
														.ajax({
															url : "/web/search",
															type : "post",
															dataType : "json",
															data : {
																term : request.term,
																param1 : "param1 Value",
																param2 : "param2 Value"
															},
															contentType : "application/x-www-form-urlencoded; charset=UTF-8",
															data : request,
															success : function(
																	data) {
																var result = data;
																response(result);
															},
															error : function(
																	data) {
																alert("에러가 발생하였습니다.")
															}
														});
											}
										});
					});
</script>
<link href="resources/test/css/logins.css" rel="stylesheet"
	type="text/css">
<link href="resources/test/css/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<script src="resources/test/bootstrap/js/bootstrap.min.js"
	type="text/javascript"></script>
<script src="resources/test/js/main.js" type="text/javascript"></script>
</head>
<body>
	<!-- Header 윗부분 -->
	<div id="header">
		<div id="headerwrap"></div>
		<div class="top">
			<!-- 로고 시작 -->
			<div id="logo">
				<a href="#" class="logoimg">Favorite Music</a>
			</div>
			<!-- 로고 종료 -->
			<!-- search -->
			<div class="search">
				<span class="input-group margin"> <input type="text"
					id="testText" class="form-control"
					placeholder="[가수 & 제목] 검색 하면 됩니다."><span
					class="input-group-btn">
						<button class="btn btn-info btn-flat" type="button">검색</button>
				</span>
				</span>
			</div>
			<!-- 검색 종료 -->
			<!-- 로그인 시작-->
			<div class="logout_header">
				<a href="j_spring_security_logout">${username}님 반갑습니다.</a>
				</li>
			</div>

			<!-- 로그인 종료-->
			<!-- 메뉴 시작 -->
			<div class="nav">
				<ul>
					<li class="nav_0"><a href="#">음원차트</a></li>
					<li class="nav_1"><a href="#">최신음악</a></li>
					<li class="nav_2"><a href="#">장르음악</a></li>
					<li class="nav_3"><a href="#">라디오</a></li>
					<li class="nav_4"><a href="#">공지사항</a></li>
					<li class="nav_5"><a href="#">FAQ</a></li>
					<li class="nav_6"><a href="#">1:1</a></li>
					<li class="nav_7"><a href="#">1:1</a></li>
					<li class="nav_8"><a href="#">1:1</a></li>
				</ul>
			</div>
			<!-- 메뉴종료 -->
		</div>
	</div>
	<!-- end header -->
	<!-- center -->
	<div id="center">
		<div class="centerwrap">
			<div class="centertab"></div>
			<!-- 앨범 -->
			<div class="album">
				<div class="musicList albumList">
					<h2>
						<strong>최신앨범</strong>
					</h2>
					<h3 class="on">
						<a href="#" class="musicgroup">종합</a> <span class="textbar"></span><a
							href="#" class="musicgroup">가요</a> <span class="textbar"></span>
						<a href="#" class="musicgroup">팝</a> <span class="textbar"></span>
						<a href="#" class="musicgroup">J-POP</a>
					</h3>
					<ul class="thumbs">
						<li><a href="#thumb1" class="thumbnail"
							style="background-image: url(resources/test/img/462544.jpg);">
								<h4>AllNew</h4> <span class="description">Get the latest
									technologies</span>
						</a></li>
						<li><a href="#thumb2" class="thumbnail"
							style="background-image: url(resources/test/img/465226.jpg)">
								<h4>AllNew</h4> <span class="description">Get the latest
									technologies</span>
						</a></li>
						<li><a href="#thumb3" class="thumbnail"
							style="background-image: url(resources/test/img/465266.jpg)">
								<h4>AllNew</h4> <span class="description">Get the latest
									technologies</span>
						</a></li>
						<li><a href="#thumb4" class="thumbnail"
							style="background-image: url(resources/test/img/462544.jpg)">
								<h4>AllNew</h4> <span class="description">Get the latest
									technologies</span>
						</a></li>
						<li><a href="#thumb5" class="thumbnail"
							style="background-image: url(resources/test/img/462544.jpg)">
								<h4>AllNew</h4> <span class="description">Get the latest
									technologies</span>
						</a></li>
						<li><a href="#thumb6" class="thumbnail"
							style="background-image: url(resources/test/img/462544.jpg)">
								<h4>POP</h4> <span class="description">Get the latest
									technologies</span>
						</a></li>
						<li><a href="#thumb7" class="thumbnail"
							style="background-image: url(resources/test/img/462544.jpg)">
								<h4>가요</h4> <span class="description">Get the latest
									technologies</span>
						</a></li>
						<li><a href="#thumb8" class="thumbnail"
							style="background-image: url(resources/test/img/462544.jpg)">
								<h4>AllNew</h4> <span class="description">Get the latest
									technologies</span>
						</a></li>
					</ul>
				</div>
			</div>
			<!-- 싱글 -->
			<div class="album">
				<div class="musicList albumList">
					<h2>
						<strong>최신음악</strong>
					</h2>
					<h3 class="on">
						<a href="#" class="musicgroup">종합</a> <span class="textbar"></span><a
							href="#" class="musicgroup">가요</a> <span class="textbar"></span>
						<a href="#" class="musicgroup">팝</a> <span class="textbar"></span>
						<a href="#" class="musicgroup">J-POP</a>
					</h3>
					<ul class="thumbs">
						<li><a href="#thumb1" class="thumbnail"
							style="background-image: url(resources/test/img/462544.jpg);">
								<h4>AllNew</h4> <span class="description">Get the latest
									technologies</span>
						</a></li>
						<li><a href="#thumb2" class="thumbnail"
							style="background-image: url(resources/test/img/465226.jpg)">
								<h4>AllNew</h4> <span class="description">Get the latest
									technologies</span>
						</a></li>
						<li><a href="#thumb3" class="thumbnail"
							style="background-image: url(resources/test/img/465266.jpg)">
								<h4>AllNew</h4> <span class="description">Get the latest
									technologies</span>
						</a></li>
						<li><a href="#thumb4" class="thumbnail"
							style="background-image: url(resources/test/img/462544.jpg)">
								<h4>AllNew</h4> <span class="description">Get the latest
									technologies</span>
						</a></li>
						<li><a href="#thumb5" class="thumbnail"
							style="background-image: url(resources/test/img/462544.jpg)">
								<h4>AllNew</h4> <span class="description">Get the latest
									technologies</span>
						</a></li>
						<li><a href="#thumb6" class="thumbnail"
							style="background-image: url(resources/test/img/462544.jpg)">
								<h4>POP</h4> <span class="description">Get the latest
									technologies</span>
						</a></li>
						<li><a href="#thumb7" class="thumbnail"
							style="background-image: url(resources/test/img/462544.jpg)">
								<h4>가요</h4> <span class="description">Get the latest
									technologies</span>
						</a></li>
						<li><a href="#thumb8" class="thumbnail"
							style="background-image: url(resources/test/img/462544.jpg)">
								<h4>AllNew</h4> <span class="description">Get the latest
									technologies</span>
						</a></li>
					</ul>
				</div>
			</div>
			<!-- 라디오 -->
			<div class="album">
				<div class="musicList albumList">
					<h2>
						<strong>라디오</strong>
					</h2>
					<ul class="thumbs">
						<li><a href="#thumb1" class="thumbnail"
							style="background-image: url(resources/test/img/462544.jpg);">
								<h4>AllNew</h4> <span class="description">Get the latest
									technologies</span>
						</a></li>
						<li><a href="#thumb2" class="thumbnail"
							style="background-image: url(resources/test/img/465226.jpg)">
								<h4>AllNew</h4> <span class="description">Get the latest
									technologies</span>
						</a></li>
						<li><a href="#thumb3" class="thumbnail"
							style="background-image: url(resources/test/img/465266.jpg)">
								<h4>AllNew</h4> <span class="description">Get the latest
									technologies</span>
						</a></li>
						<li><a href="#thumb4" class="thumbnail"
							style="background-image: url(resources/test/img/462544.jpg)">
								<h4>AllNew</h4> <span class="description">Get the latest
									technologies</span>
						</a></li>
						<li><a href="#thumb5" class="thumbnail"
							style="background-image: url(resources/test/img/462544.jpg)">
								<h4>AllNew</h4> <span class="description">Get the latest
									technologies</span>
						</a></li>
						<li><a href="#thumb6" class="thumbnail"
							style="background-image: url(resources/test/img/462544.jpg)">
								<h4>POP</h4> <span class="description">Get the latest
									technologies</span>
						</a></li>
						<li><a href="#thumb7" class="thumbnail"
							style="background-image: url(resources/test/img/462544.jpg)">
								<h4>가요</h4> <span class="description">Get the latest
									technologies</span>
						</a></li>
						<li><a href="#thumb8" class="thumbnail"
							style="background-image: url(resources/test/img/462544.jpg)">
								<h4>AllNew</h4> <span class="description">Get the latest
									technologies</span>
						</a></li>
					</ul>
				</div>
			</div>
			<!-- 차트 -->
			<div class="subcenter">
				<div class="login">
					<div class="login-box-body">
						<h2>
							<strong>회원정보</strong>
						</h2>
						<form action="j_spring_security_logout" method="post">
							<div class="userinfo">
								<ul class="infolist">
									<li><a href="#" class="userlink">닉네임 : ${username}님</a></li>
									<li><a href="#" class="userlink">계정종료 : 2015/07/30</a></li>
									<li><a href="#" class="userlink">회원정보변경</a></li>
								</ul>
							</div>
							<div class="col-xs-4">
								<button type="submit"
									class="btn btn-primary btn-block btn-danger">로그아웃</button>
							</div>
							<!-- /.col -->
						</form>
					</div>

				</div>
				<!-- 정보 -->
				<div class="infomation">
					<div class="box-body">
						<h2>
							<strong>정보</strong>
						</h2>
						<div class="info-box">
							<span class="info-box-icon"><i class="fa fa-music"></i></span>
							<div class="info-box-content">
								<span class="info-box-text">음원보유수</span> <span
									class="info-box-number">10,000,000곡</span>
							</div>
							<!-- /.info-box-content -->
						</div>
						<!-- /.info-box -->

						<div class="info-box">
							<span class="info-box-icon"><i class="fa fa-play-circle"></i></span>
							<div class="info-box-content">
								<span class="info-box-text">라디오 채널수</span> <span
									class="info-box-number">20개</span>
							</div>
							<!-- /.info-box-content -->
						</div>
						<!-- /.info-box -->

						<div class="info-box">
							<span class="info-box-icon"><i class="fa fa-cloud-upload"></i></span>
							<div class="info-box-content">
								<span class="info-box-text">오늘 등록된 음원수</span> <span
									class="info-box-number">1,240곡</span>
							</div>
							<!-- /.info-box-content -->
						</div>
						<!-- /.info-box -->

						<div class="info-box">
							<span class="info-box-icon"><i class="fa  fa-users"></i></span>
							<div class="info-box-content">
								<span class="info-box-text">총 유저수</span> <span
									class="info-box-number">120,020명</span>
							</div>
						</div>
					</div>
				</div>
				<!-- 공지사항 -->
				<div class="noticelist">
					<h2>
						<strong>공지사항</strong>
					</h2>
					<ul id="notice">
						<li><a href="#">회사소개</a></li>
						<li><a href="#">이용약관</a></li>
						<li><a href="#">개인정보보호정책</a></li>
						<li><a href="#">법적고지</a></li>
						<li><a href="#">이메일무단수집거부</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- end center -->
	<!-- footer -->
	<div id="footer">
		<div class="footerwarp">
			<div id="company">
				<a href="#" class="footersize">Favorite Music</a>
			</div>
			<div class="footerlist">
				<ul id="footercompany">
					<li><a href="#">회사소개</a></li>
					<li><a href="#">이용약관</a></li>
					<li><a href="#">개인정보보호정책</a></li>
					<li><a href="#">법적고지</a></li>
					<li><a href="#">이메일무단수집거부</a></li>
					<li><a href="#">고객센터</a></li>
					<li><a href="#">찾아오시는 길</a></li>
				</ul>
			</div>
			<div class="footerlist2">
				<ul id="footercompany">
					<li>사업자등록번호 : 000-00-0000</li>
					<li>통신판매신고번호 : 2015-경기**-0101</li>
					<li>개인정보관리책임자 : M!Plan</li>
					<li>대표이사 : 김정훈</li>
					<li id="company-info">VM! - Favorite Music㈜ <br /> ⓒ
						Copyright M!Plan All Rights Reserved. 1997~2015, ⓒ Copyright
						M!Plan Lap All Rights Reserved. 2009~2015<br />
					</li>
				</ul>
			</div>
		</div>
	</div>
	<!-- end footer -->
</body>
</html>
