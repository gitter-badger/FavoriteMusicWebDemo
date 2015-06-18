<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Favorite Music</title>
<script src="http://code.jquery.com/jquery-1.9.1.js" type="text/javascript"></script>
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
$(document).ready(function() {
$("#testText").autocomplete({
source : function(request, response) {
$.ajax({
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
	success : function(data) {
		var result = data;
		response(result);
		},
		error : function(data) {
			alert("에러가 발생하였습니다.")
			}
		});
		}
		});
		});

</script>
<link href="resources/main/main.css" rel="stylesheet" type="text/css">
<link href="resources/main/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link href="resources/main/iCheck/square/blue.css" rel="stylesheet"
	type="text/css" />
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/main/css/_all-skins.min.css" rel="stylesheet"
	type="text/css">
<link href="resources/main/music.css" rel="stylesheet" type="text/css">
<link href="resources/main/modal.css" rel="stylesheet" type="text/css">

<script src="resources/main/modalLayer.js" type="text/javascript">
</script>
<script src="resources/main/bootstrap/js/bootstrap.min.js"
	type="text/javascript">
</script>
<script src="resources/main/iCheck/icheck.min.js" type="text/javascript"></script>
<script src="resources/main/main.js" type="text/javascript">
</script>
</head>
<body>

	<!-- 모달창 로그인 레이아웃 -->
	<div class="modal" id="modallogin">
		<div class="login">
			<div class="login-box-body">
				<form action="#" method="post">
					<div class="form-group has-feedback">
						<input type="text" class="form-control" placeholder="아이디" /> <span
							class="glyphicon glyphicon-user form-control-feedback"></span>
					</div>
					<div class="form-group has-feedback">
						<input type="password" class="form-control" placeholder="패스워드" />
						<span class="glyphicon glyphicon-lock form-control-feedback"></span>
					</div>
					<div class="row">
						<div class="col-xs-8">
							<div class="checkbox icheck">
								<label> <input type="checkbox"> 아이디 저장
								</label>
							</div>
						</div>
						<div class="col-xs-4">
							<button type="submit" class="btn btn-primary btn-block btn-flat">로그인</button>
						</div>
					</div>
				</form>
					<button type="button" class="closeModalLayer" data-dismiss="modal"
						aria-hidden="true" onClick="removeModal()">&times;</button>
			
			</div>
		</div>
	</div>

	<!-- 모달창 로그인 레이아웃 종료-->

	<div id="header">
		<!-- LOGO -->
		<div class="inner_wrap">
			<div id="logo">
				<a href="/web" class="logoimg">Favorite Music</a>
			</div>
			<div class="search">
				<span class="input-group margin">
						<input type="text" id="testText" class="form-control"
							placeholder="[가수 & 제목] 검색 하면 됩니다."> <span
							class="input-group-btn">
							<button class="btn btn-info btn-flat" type="button">검색</button>
						</span>
				</span>
			</div>
			<div class="btjoin">
				<button class="btn btn-block btn-primary">회원가입</button>
			</div>
			<div class="btlogin">
				<button class="btn btn-block btn-danger" id="openmodal">로그인</button>
			</div>

			<div class="nav">
				<ul>
					<li class="nav_0"><a href="#">Chart</a></li>
					<li class="nav_1"><a href="#">New</a></li>
					<li class="nav_2"><a href="#">All</a></li>
					<li class="nav_3"><a href="#">Radio</a></li>
					<li class="nav_4"><a href="/web/fileuploadsingle">Notice</a></li>
					<li class="nav_5"><a href="/web/jquery">Faq</a></li>
				</ul>
			</div>
		</div>
	</div>

	<!-- Start Center -->
	<div id="center">
		<!-- LOGO -->
		<div class="center_wrap">
			<div class="slider">
				<div class="box-body">
					<div id="carousel-example-generic" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"
								class=""></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"
								class=""></li>
						</ol>
						<div class="carousel-inner">
							<div class="item active">
								<img
									src="http://placehold.it/900x500/39CCCC/ffffff&text=I+Love+Bootstrap"
									alt="First slide">
								<div class="carousel-caption">First Slide</div>
							</div>
							<div class="item">
								<img
									src="http://placehold.it/900x500/3c8dbc/ffffff&text=I+Love+Bootstrap"
									alt="Second slide">
								<div class="carousel-caption">Second Slide</div>
							</div>
							<div class="item">
								<img
									src="http://placehold.it/900x500/f39c12/ffffff&text=I+Love+Bootstrap"
									alt="Third slide">
								<div class="carousel-caption">Third Slide</div>
							</div>
						</div>
					</div>
					<!-- /.box-body -->
				</div>
			</div>

			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">로그인</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<div class="login">
						<div class="login-box-body">
							<form action="#" method="post">
								<div class="form-group has-feedback">
									<input type="text" class="form-control" placeholder="아이디" /> <span
										class="glyphicon glyphicon-user form-control-feedback"></span>
								</div>
								<div class="form-group has-feedback">
									<input type="password" class="form-control" placeholder="패스워드" />
									<span class="glyphicon glyphicon-lock form-control-feedback"></span>
								</div>
								<div class="row">
									<div class="col-xs-8">
										<div class="checkbox icheck">
											<label> <input type="checkbox"> 아이디 저장
											</label>
										</div>
									</div>
									<!-- /.col -->
									<div class="col-xs-4">
										<button type="submit"
											class="btn btn-primary btn-block btn-flat">로그인</button>
									</div>
									<!-- /.col -->
								</div>
							</form>
						</div>
						<!-- /.box-body -->
					</div>
					<!-- /.box -->
				</div>
			</div>
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">Favorite Music 정보</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<div class="info-box">
						<span class="info-box-icon bg-aqua"><i
							class="fa fa-envelope-o"></i></span>
						<div class="info-box-content">
							<span class="info-box-text">음원보유수</span> <span
								class="info-box-number">10,000,000곡</span>
						</div>
						<!-- /.info-box-content -->
					</div>
					<!-- /.info-box -->

					<div class="info-box">
						<span class="info-box-icon bg-aqua"><i
							class="fa fa-envelope-o"></i></span>
						<div class="info-box-content">
							<span class="info-box-text">라디오 채널수</span> <span
								class="info-box-number">20개</span>
						</div>
						<!-- /.info-box-content -->
					</div>
					<!-- /.info-box -->

					<div class="info-box">
						<span class="info-box-icon bg-aqua"><i
							class="fa fa-envelope-o"></i></span>
						<div class="info-box-content">
							<span class="info-box-text">오늘 등록된 음원수</span> <span
								class="info-box-number">1,240곡</span>
						</div>
						<!-- /.info-box-content -->
					</div>
					<!-- /.info-box -->

					<div class="info-box">
						<span class="info-box-icon bg-aqua"><i
							class="fa fa-envelope-o"></i></span>
						<div class="info-box-content">
							<span class="info-box-text">총 유저수</span> <span
								class="info-box-number">120,020명</span>
						</div>
						<!-- /.info-box-content -->
					</div>
					<!-- /.info-box -->
				</div>
			</div>
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">공지사항</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<div class="notice">
						<div class="notice">
							<dl class="noticelist">
								<dd>
									<ul id="mainnoticelist">
										<li><a href="#">Hellomplan 대표</a></li>
										<li><a href="#">[공지사항] 06/10 정기정검</a></li>
										<li><a href="#">본 서비스는 안드로이드 앱에서만 정상 사용</a></li>
										<li><a href="#">새로운 Hello M!Plan 개편</a></li>
										<li><a href="#">새로운 Hello M!Plan 개편</a></li>
									</ul>
								</dd>
							</dl>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Center -->
	<!-- Start Footer -->
	<div id="footer">
		<div class="footerwarp" id="footerwarp">
			<a href="#" class="footersize">Favorite Music</a>
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
</body>
</html>
