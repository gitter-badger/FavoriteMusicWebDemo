<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
						$("#searchname")
								.autocomplete(
										{
											source : function(request, response) {
												$
														.ajax({
															url : "/web/editsearch",
															type : "post",
															dataType : "json",
															data : {
																term : request.term,
															//param1 : "param1 Value",
															//param2 : "param2 Value"
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

<link href="resources/test/css/search.css" rel="stylesheet"
	type="text/css">
<link href="resources/test/css/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/test/css/modal.css" rel="stylesheet"
	type="text/css">
<script src="resources/test/js/modalLayer.js" type="text/javascript"></script>
<script src="resources/test/bootstrap/js/bootstrap.min.js"
	type="text/javascript"></script>
<link href="resources/test/css/artistlist.css" rel="stylesheet"
	type="text/css">
<link href="resources/test/css/albumlist.css" rel="stylesheet"
	type="text/css">
<link href="resources/test/css/singlelist.css" rel="stylesheet"
	type="text/css">
</head>
<body>

	<!-- 모달창 로그인 레이아웃 -->
	<div class="modal" id="modallogin">
		<div class="login">
			<div class="login-box-body">
				<h2>
					<strong>로그인</strong>
				</h2>
				<form action="j_spring_security_check" method="post">
					<div class="form-group has-feedback">
						<input type="text" class="form-control" name="j_username"
							placeholder="아이디" /> <span
							class="glyphicon glyphicon-user form-control-feedback"></span>
					</div>
					<div class="form-group has-feedback">
						<input type="password" class="form-control" name="j_password"
							placeholder="패스워드" /> <span
							class="glyphicon glyphicon-lock form-control-feedback"></span>
					</div>
					<div class="row">

						<!-- /.col -->
						<div class="col-xs-4">
							<button type="submit" class="btn btn-primary btn-block btn-flat">로그인</button>
						</div>

						<!-- /.col -->
					</div>
				</form>
				<button type="button" class="closeModalLayer" data-dismiss="modal"
					aria-hidden="true" onClick="removeModal()">&times;</button>
			</div>
		</div>
	</div>

	<!-- 모달창 로그인 레이아웃 종료-->
	<!-- Header 윗부분 -->
	<div id="header">
		<div id="headerwrap"></div>
		<div class="top">
			<!-- 로고 시작 -->
			<div id="logo">
				<a href="/web" class="logoimg">Favorite Music</a>
			</div>
			<!-- 로고 종료 -->
			<!-- search -->

			<div class="search">
				<form action="/web/search" method="get">
					<span class="input-group margin"> <input type="text"
						id="searchname" name="searchname" class="form-control"
						placeholder="[가수 & 제목] 검색 하면 됩니다."> <span
						class="input-group-btn">
							<button class="btn btn-info btn-flat" id="btnsearch"
								type="submit">검색</button>
					</span>
					</span>
				</form>
			</div>

			<!-- 검색 종료 -->
			<!-- 로그인 시작-->
			<div class="btjoin">
				<button class="btn btn-block btn-primary">회원가입</button>
			</div>
			<div class="btlogin">
				<button class="btn btn-block btn-danger" id="openmodal">로그인</button>
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
			<div class="text">
				<h2>아티스트</h2>
			</div>



			<div id="thelist">
				<div class="listtest">
					<ul>
						<c:choose>
							<c:when test="${not empty object}">
								<c:forEach var="object" items="${object}" varStatus="status">
									<li>

										<div class="artistlist">
											<a href="#" class="tnail"></a> <span class="group"></span> <span
												class="thumb"> <img
												src="${resourcePath}/artistimg/${object.art_img}">
											</span> <span class="grup"> </span> <span class="info"> <span
												class="debut">${object.art_debut}</span>
											</span> <span class="subject"> <span class="artist">${object.art_artist}</span>
												<span class="corp">${object.art_label}</span> <span
												class="etc">${object.art_etc}</span>
											</span> <span class="play"> <span class="home">자세히 보기</span>
												<span class="like">${object.art_hit}명</span>
											</span>
										</div>
									</li>
								</c:forEach>
							</c:when>
							<c:when test="${empty object}">
								<li>찾으시는 아티스타가 없습니다.</li>
							</c:when>
						</c:choose>
					</ul>
				</div>
			</div>
			<div class="text">
				<h2>앨범</h2>
			</div>

			<div id="thelist">
				<div class="listtest">
					<ul>
						<c:choose>
							<c:when test="${not empty object2}">
								<c:forEach var="object2" items="${object2}" varStatus="status">
									<li>
										<div class="albumlist">
											<a href="#" class="tnail"></a> <span class="group"></span> <span
												class="thumb"> <img
												src="${resourcePath}/albumimg/${object2.al_imgorg}">
											</span> <span class="grup"> </span> <span class="info"> <span
												class="year">${object2.al_year}</span>
											</span> <span class="subject"> <span class="artist">${object2.al_artist}</span>
												<span class="album">${object2.al_album}</span> <span
												class="corp">${object2.al_corp}</span>
											</span> <span class="play"> <span class="home">앨범보기</span> <span
												class="like">싱글</span>
											</span>
										</div>
									</li>
								</c:forEach>
							</c:when>
							<c:when test="${empty object2}">
								<li>찾으시는 앨범이 없습니다.</li>
							</c:when>
						</c:choose>
					</ul>
				</div>
			</div>
			<div class="text">
				<h2>곡</h2>

			</div>


			<div id="thelist">
				<div class="listtest">
					<ul>

						<c:choose>


							<c:when test="${not empty object3}">
								<c:forEach var="object3" items="${object3}" varStatus="status">
									<li>
										<div class="singlelist">
											<a href="#" class="tnail"></a> <span class="group"></span> <span
												class="thumb"> <img
												src="${resourcePath}/sourceimg/${object3.m_imgo}">
											</span> <span class="grup">
												<h4>Darkness</h4>
											</span> <span class="info"> <span class="bit1">${object3.m_year}</span>
												<span class="bit2">320kbps</span> <span class="bit3">Flac</span>
											</span> <span class="info"></span> <span class="subject"> <span
												class="artist">${object3.m_artist}</span> <span
												class="title">${object3.m_title}</span> <span class="album">${object3.m_album}</span>
											</span> <span class="play"> <span class="home"><a
													href="${resourcePath}/source320k/${object3.m_320ko}"
													target="_blank">음악듣기</a></span> <span class="like">싱글</span>
											</span>
										</div>
									</li>
								</c:forEach>
							</c:when>
							<c:when test="${empty object3}">

								<li>찾으시는 곡이 없습니다.</li>
							</c:when>
						</c:choose>
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
<script src="resources/test/js/main.js" type="text/javascript"></script>
</html>

