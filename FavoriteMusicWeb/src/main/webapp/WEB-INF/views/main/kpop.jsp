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
	<script src="../resources/music/allnew.js" type="text/javascript"></script>
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

<link href="../resources/test/css/list.css" rel="stylesheet"
	type="text/css">
<link href="../resources/test/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link href="../resources/test/css/modal.css" rel="stylesheet"
	type="text/css">
<script src="../resources/test/js/modalLayer.js" type="text/javascript"></script>
<script src="../resources/test/bootstrap/js/bootstrap.min.js"
	type="text/javascript"></script>
<link href="../resources/test/css/artistlist.css" rel="stylesheet"
	type="text/css">
<link href="../resources/test/css/albumlist.css" rel="stylesheet"
	type="text/css">
<link href="../resources/test/css/singlelist.css" rel="stylesheet"
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
<%@ include
		file="inc/header.jsp"%>
	<!-- end header -->
	<!-- center -->
	<div id="center">
		<div class="centerwrap">
			<div class="centertab"></div>
			<div class="tabmusic">
				<h3>최신음악</h3>
				<ul class="newMusic">
					<li class="all"><a href="#" class="on">종합</a></li>
					<li class="kpop"><a href="#" class="">가요</a></li>
					<li class="pop"><a href="#" class="">팝송</a></li>
					<li class="ost"><a href="#" class="">OST</a></li>
					<li class="jpop"><a href="#" class="">J-POP</a></li>
					<li class="classic"><a href="#" class="">클래식</a></li>
				</ul>
			</div>
			<div class="listmusic">
				<table class="table table-striped" id="dataTable">
					<thead>
						<tr>
							<th><input type="checkbox" id="allCheck" /></th>
							<th>번호</th>
							<th>아티스트</th>
							<th>제목명</th>
							<th>앨범명</th>
							<th>발매날짜</th>
							<th>듣기</th>
							<th>다운</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
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

