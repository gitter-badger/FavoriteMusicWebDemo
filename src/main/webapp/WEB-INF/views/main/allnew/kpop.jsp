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
	<%@ include file="../inc/header.jsp"%>
	<!-- end header -->
	<!-- center -->
	<div id="center">
		<div class="centerwrap">
			<div class="centertab"></div>
			<div class="tabmusic">
				<h3>최신음악</h3>
				<ul class="newMusic">
					<li class="all"><a href="/web/allnew/list" class="">종합</a></li>
					<li class="kpop"><a href="/web/allnew/kpoplist" class="on">가요</a></li>
					<li class="pop"><a href="/web/allnew/poplist" class="">팝송</a></li>
					<li class="ost"><a href="/web/allnew/ostlist" class="">OST</a></li>
					<li class="jpop"><a href="/web/allnew/jpoplist" class="">J-POP</a></li>
					<li class="radio2"><a href="/web/allnew/radiolist" class="">Radio</a></li>
				</ul>
			</div>
			<div class="container-fluid">
				<div class="listmusic">

					<table class="table table-striped" id="dataTable">
						<thead>
							<tr>
								<th><input type="checkbox" id="allCheck" /></th>
								<th>이미지</th>
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

				<!-- 페이징처리 부분  -->
				<div class="col-md-8">
					<ul class="pagination" id="pagination">
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- end center -->
	<!-- footer -->
	<%@ include file="../inc/footer.jsp"%>
	<!-- end footer -->
</body>
<script src="../resources/music/kpop.js" type="text/javascript"></script>
</html>

