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

<link href="resources/test/css/main.css" rel="stylesheet"
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

</head>
<body>

	<!-- 모달창 로그인 레이아웃 -->
	<div class="modal" id="modallogin" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
	<!-- center -->
	<div id="center">
		<div class="centerwrap">
			<div class="centertab"></div>
		 <div class="listtest">
      <div class="albumtitle">
       <h2><strong>최신앨범</strong></h2>
        <h3 class ="on"> <a href="#" class="musicgroup">종합</a> <span class="textbar"></span><a href="#" class="musicgroup">가요</a> <span class="textbar"></span> <a href="#" class="musicgroup">팝</a> <span class="textbar"></span> <a href="#" class=				"musicgroup">J-POP</a></h3>
        </div>
        <ul>
          <li>
            <div class="albumlist"> 
            <a href="#" class="tnail"></a> 
            <span class="group"></span> 
            <span class="thumb"> <img src ="img/2325321.jpg"> </span>
             <span class="grup">
              <h4>Darkness</h4>
              </span> 
              <span class="info"> 
              <span class="year">2014.09.11</span>
              </span>
              <span class="subject">
               <span class="artist">티아라(T-ara)</span> 
               <span class="titlename">Sugar Free (BigRoom ver.)</span> 
               </span> 
               <span class="play"> 
               <span class="home">앨범보기</span> 
               <span class="like">듣기</span> 
               </span> 
               </div>
            </li>
             <li>
            <div class="albumlist"> 
            <a href="#" class="tnail"></a> 
            <span class="group"></span> 
            <span class="thumb"> <img src ="img/2325321.jpg"> </span>
             <span class="grup">
              <h4>Darkness</h4>
              </span> 
              <span class="info"> 
              <span class="year">2014.09.11</span>
              </span>
              <span class="subject">
               <span class="artist">티아라(T-ara)</span> 
               <span class="titlename">Sugar Free (BigRoom ver.)</span> 
               </span> 
               <span class="play"> 
               <span class="home">앨범보기</span> 
               <span class="like">듣기</span> 
               </span> 
               </div>
            </li>
             <li>
            <div class="albumlist"> 
            <a href="#" class="tnail"></a> 
            <span class="group"></span> 
            <span class="thumb"> <img src ="img/2325321.jpg"> </span>
             <span class="grup">
              <h4>Darkness</h4>
              </span> 
              <span class="info"> 
              <span class="year">2014.09.11</span>
              </span>
              <span class="subject">
               <span class="artist">티아라(T-ara)</span> 
               <span class="titlename">Sugar Free (BigRoom ver.)</span> 
               </span> 
               <span class="play"> 
               <span class="home">앨범보기</span> 
               <span class="like">듣기</span> 
               </span> 
               </div>
            </li>
             <li>
            <div class="albumlist"> 
            <a href="#" class="tnail"></a> 
            <span class="group"></span> 
            <span class="thumb"> <img src ="img/2325321.jpg"> </span>
             <span class="grup">
              <h4>Darkness</h4>
              </span> 
              <span class="info"> 
              <span class="year">2014.09.11</span>
              </span>
              <span class="subject">
               <span class="artist">티아라(T-ara)</span> 
               <span class="titlename">Sugar Free (BigRoom ver.)</span> 
               </span> 
               <span class="play"> 
               <span class="home">앨범보기</span> 
               <span class="like">듣기</span> 
               </span> 
               </div>
            </li>
                 <li>
            <div class="albumlist"> 
            <a href="#" class="tnail"></a> 
            <span class="group"></span> 
            <span class="thumb"> <img src ="img/2325321.jpg"> </span>
             <span class="grup">
              <h4>Darkness</h4>
              </span> 
              <span class="info"> 
              <span class="year">2014.09.11</span>
              </span>
              <span class="subject">
               <span class="artist">티아라(T-ara)</span> 
               <span class="titlename">Sugar Free (BigRoom ver.)</span> 
               </span> 
               <span class="play"> 
               <span class="home">앨범보기</span> 
               <span class="like">듣기</span> 
               </span> 
               </div>
            </li>
                 <li>
            <div class="albumlist"> 
            <a href="#" class="tnail"></a> 
            <span class="group"></span> 
            <span class="thumb"> <img src ="img/2325321.jpg"> </span>
             <span class="grup">
              <h4>Darkness</h4>
              </span> 
              <span class="info"> 
              <span class="year">2014.09.11</span>
              </span>
              <span class="subject">
               <span class="artist">티아라(T-ara)</span> 
               <span class="titlename">Sugar Free (BigRoom ver.)</span> 
               </span> 
               <span class="play"> 
               <span class="home">앨범보기</span> 
               <span class="like">듣기</span> 
               </span> 
               </div>
            </li>
                 <li>
            <div class="albumlist"> 
            <a href="#" class="tnail"></a> 
            <span class="group"></span> 
            <span class="thumb"> <img src ="img/2325321.jpg"> </span>
             <span class="grup">
              <h4>Darkness</h4>
              </span> 
              <span class="info"> 
              <span class="year">2014.09.11</span>
              </span>
              <span class="subject">
               <span class="artist">티아라(T-ara)</span> 
               <span class="titlename">Sugar Free (BigRoom ver.)</span> 
               </span> 
               <span class="play"> 
               <span class="home">앨범보기</span> 
               <span class="like">듣기</span> 
               </span> 
               </div>
            </li>
                 <li>
            <div class="albumlist"> 
            <a href="#" class="tnail"></a> 
            <span class="group"></span> 
            <span class="thumb"> <img src ="img/2325321.jpg"> </span>
             <span class="grup">
              <h4>Darkness</h4>
              </span> 
              <span class="info"> 
              <span class="year">2014.09.11</span>
              </span>
              <span class="subject">
               <span class="artist">티아라(T-ara)</span> 
               <span class="titlename">Sugar Free (BigRoom ver.)</span> 
               </span> 
               <span class="play"> 
               <span class="home">앨범보기</span> 
               <span class="like">듣기</span> 
               </span> 
               </div>
            </li>
        </ul>
      </div>
      <div class="listtest">
      <div class="albumtitle">
       <h2><strong>최신앨범</strong></h2>
        <h3 class ="on"> <a href="#" class="musicgroup">종합</a> <span class="textbar"></span><a href="#" class="musicgroup">가요</a> <span class="textbar"></span> <a href="#" class="musicgroup">팝</a> <span class="textbar"></span> <a href="#" class=				"musicgroup">J-POP</a></h3>
        </div>
        <ul>
          <li>
            <div class="albumlist"> 
            <a href="#" class="tnail"></a> 
            <span class="group"></span> 
            <span class="thumb"> <img src ="img/2325321.jpg"> </span>
             <span class="grup">
              <h4>Darkness</h4>
              </span> 
              <span class="info"> 
              <span class="year">2014.09.11</span>
              </span>
              <span class="subject">
               <span class="artist">티아라(T-ara)</span> 
               <span class="titlename">Sugar Free (BigRoom ver.)</span> 
               </span> 
               <span class="play"> 
               <span class="home">앨범보기</span> 
               <span class="like">듣기</span> 
               </span> 
               </div>
            </li>
             <li>
            <div class="albumlist"> 
            <a href="#" class="tnail"></a> 
            <span class="group"></span> 
            <span class="thumb"> <img src ="img/2325321.jpg"> </span>
             <span class="grup">
              <h4>Darkness</h4>
              </span> 
              <span class="info"> 
              <span class="year">2014.09.11</span>
              </span>
              <span class="subject">
               <span class="artist">티아라(T-ara)</span> 
               <span class="titlename">Sugar Free (BigRoom ver.)</span> 
               </span> 
               <span class="play"> 
               <span class="home">앨범보기</span> 
               <span class="like">듣기</span> 
               </span> 
               </div>
            </li>
             <li>
            <div class="albumlist"> 
            <a href="#" class="tnail"></a> 
            <span class="group"></span> 
            <span class="thumb"> <img src ="img/2325321.jpg"> </span>
             <span class="grup">
              <h4>Darkness</h4>
              </span> 
              <span class="info"> 
              <span class="year">2014.09.11</span>
              </span>
              <span class="subject">
               <span class="artist">티아라(T-ara)</span> 
               <span class="titlename">Sugar Free (BigRoom ver.)</span> 
               </span> 
               <span class="play"> 
               <span class="home">앨범보기</span> 
               <span class="like">듣기</span> 
               </span> 
               </div>
            </li>
             <li>
            <div class="albumlist"> 
            <a href="#" class="tnail"></a> 
            <span class="group"></span> 
            <span class="thumb"> <img src ="img/2325321.jpg"> </span>
             <span class="grup">
              <h4>Darkness</h4>
              </span> 
              <span class="info"> 
              <span class="year">2014.09.11</span>
              </span>
              <span class="subject">
               <span class="artist">티아라(T-ara)</span> 
               <span class="titlename">Sugar Free (BigRoom ver.)</span> 
               </span> 
               <span class="play"> 
               <span class="home">앨범보기</span> 
               <span class="like">듣기</span> 
               </span> 
               </div>
            </li>
                 <li>
            <div class="albumlist"> 
            <a href="#" class="tnail"></a> 
            <span class="group"></span> 
            <span class="thumb"> <img src ="img/2325321.jpg"> </span>
             <span class="grup">
              <h4>Darkness</h4>
              </span> 
              <span class="info"> 
              <span class="year">2014.09.11</span>
              </span>
              <span class="subject">
               <span class="artist">티아라(T-ara)</span> 
               <span class="titlename">Sugar Free (BigRoom ver.)</span> 
               </span> 
               <span class="play"> 
               <span class="home">앨범보기</span> 
               <span class="like">듣기</span> 
               </span> 
               </div>
            </li>
                 <li>
            <div class="albumlist"> 
            <a href="#" class="tnail"></a> 
            <span class="group"></span> 
            <span class="thumb"> <img src ="img/2325321.jpg"> </span>
             <span class="grup">
              <h4>Darkness</h4>
              </span> 
              <span class="info"> 
              <span class="year">2014.09.11</span>
              </span>
              <span class="subject">
               <span class="artist">티아라(T-ara)</span> 
               <span class="titlename">Sugar Free (BigRoom ver.)</span> 
               </span> 
               <span class="play"> 
               <span class="home">앨범보기</span> 
               <span class="like">듣기</span> 
               </span> 
               </div>
            </li>
                 <li>
            <div class="albumlist"> 
            <a href="#" class="tnail"></a> 
            <span class="group"></span> 
            <span class="thumb"> <img src ="img/2325321.jpg"> </span>
             <span class="grup">
              <h4>Darkness</h4>
              </span> 
              <span class="info"> 
              <span class="year">2014.09.11</span>
              </span>
              <span class="subject">
               <span class="artist">티아라(T-ara)</span> 
               <span class="titlename">Sugar Free (BigRoom ver.)</span> 
               </span> 
               <span class="play"> 
               <span class="home">앨범보기</span> 
               <span class="like">듣기</span> 
               </span> 
               </div>
            </li>
                 <li>
            <div class="albumlist"> 
            <a href="#" class="tnail"></a> 
            <span class="group"></span> 
            <span class="thumb"> <img src ="img/2325321.jpg"> </span>
             <span class="grup">
              <h4>Darkness</h4>
              </span> 
              <span class="info"> 
              <span class="year">2014.09.11</span>
              </span>
              <span class="subject">
               <span class="artist">티아라(T-ara)</span> 
               <span class="titlename">Sugar Free (BigRoom ver.)</span> 
               </span> 
               <span class="play"> 
               <span class="home">앨범보기</span> 
               <span class="like">듣기</span> 
               </span> 
               </div>
            </li>
        </ul>
      </div>
      <div class="listtest">
      <div class="albumtitle">
       <h2><strong>최신앨범</strong></h2>
        <h3 class ="on"> <a href="#" class="musicgroup">종합</a> <span class="textbar"></span><a href="#" class="musicgroup">가요</a> <span class="textbar"></span> <a href="#" class="musicgroup">팝</a> <span class="textbar"></span> <a href="#" class=				"musicgroup">J-POP</a></h3>
        </div>
        <ul>
          <li>
            <div class="albumlist"> 
            <a href="#" class="tnail"></a> 
            <span class="group"></span> 
            <span class="thumb"> <img src ="img/2325321.jpg"> </span>
             <span class="grup">
              <h4>Darkness</h4>
              </span> 
              <span class="info"> 
              <span class="year">2014.09.11</span>
              </span>
              <span class="subject">
               <span class="artist">티아라(T-ara)</span> 
               <span class="titlename">Sugar Free (BigRoom ver.)</span> 
               </span> 
               <span class="play"> 
               <span class="home">앨범보기</span> 
               <span class="like">듣기</span> 
               </span> 
               </div>
            </li>
             <li>
            <div class="albumlist"> 
            <a href="#" class="tnail"></a> 
            <span class="group"></span> 
            <span class="thumb"> <img src ="img/2325321.jpg"> </span>
             <span class="grup">
              <h4>Darkness</h4>
              </span> 
              <span class="info"> 
              <span class="year">2014.09.11</span>
              </span>
              <span class="subject">
               <span class="artist">티아라(T-ara)</span> 
               <span class="titlename">Sugar Free (BigRoom ver.)</span> 
               </span> 
               <span class="play"> 
               <span class="home">앨범보기</span> 
               <span class="like">듣기</span> 
               </span> 
               </div>
            </li>
             <li>
            <div class="albumlist"> 
            <a href="#" class="tnail"></a> 
            <span class="group"></span> 
            <span class="thumb"> <img src ="img/2325321.jpg"> </span>
             <span class="grup">
              <h4>Darkness</h4>
              </span> 
              <span class="info"> 
              <span class="year">2014.09.11</span>
              </span>
              <span class="subject">
               <span class="artist">티아라(T-ara)</span> 
               <span class="titlename">Sugar Free (BigRoom ver.)</span> 
               </span> 
               <span class="play"> 
               <span class="home">앨범보기</span> 
               <span class="like">듣기</span> 
               </span> 
               </div>
            </li>
             <li>
            <div class="albumlist"> 
            <a href="#" class="tnail"></a> 
            <span class="group"></span> 
            <span class="thumb"> <img src ="img/2325321.jpg"> </span>
             <span class="grup">
              <h4>Darkness</h4>
              </span> 
              <span class="info"> 
              <span class="year">2014.09.11</span>
              </span>
              <span class="subject">
               <span class="artist">티아라(T-ara)</span> 
               <span class="titlename">Sugar Free (BigRoom ver.)</span> 
               </span> 
               <span class="play"> 
               <span class="home">앨범보기</span> 
               <span class="like">듣기</span> 
               </span> 
               </div>
            </li>
                 <li>
            <div class="albumlist"> 
            <a href="#" class="tnail"></a> 
            <span class="group"></span> 
            <span class="thumb"> <img src ="img/2325321.jpg"> </span>
             <span class="grup">
              <h4>Darkness</h4>
              </span> 
              <span class="info"> 
              <span class="year">2014.09.11</span>
              </span>
              <span class="subject">
               <span class="artist">티아라(T-ara)</span> 
               <span class="titlename">Sugar Free (BigRoom ver.)</span> 
               </span> 
               <span class="play"> 
               <span class="home">앨범보기</span> 
               <span class="like">듣기</span> 
               </span> 
               </div>
            </li>
                 <li>
            <div class="albumlist"> 
            <a href="#" class="tnail"></a> 
            <span class="group"></span> 
            <span class="thumb"> <img src ="img/2325321.jpg"> </span>
             <span class="grup">
              <h4>Darkness</h4>
              </span> 
              <span class="info"> 
              <span class="year">2014.09.11</span>
              </span>
              <span class="subject">
               <span class="artist">티아라(T-ara)</span> 
               <span class="titlename">Sugar Free (BigRoom ver.)</span> 
               </span> 
               <span class="play"> 
               <span class="home">앨범보기</span> 
               <span class="like">듣기</span> 
               </span> 
               </div>
            </li>
                 <li>
            <div class="albumlist"> 
            <a href="#" class="tnail"></a> 
            <span class="group"></span> 
            <span class="thumb"> <img src ="img/2325321.jpg"> </span>
             <span class="grup">
              <h4>Darkness</h4>
              </span> 
              <span class="info"> 
              <span class="year">2014.09.11</span>
              </span>
              <span class="subject">
               <span class="artist">티아라(T-ara)</span> 
               <span class="titlename">Sugar Free (BigRoom ver.)</span> 
               </span> 
               <span class="play"> 
               <span class="home">앨범보기</span> 
               <span class="like">듣기</span> 
               </span> 
               </div>
            </li>
                 <li>
            <div class="albumlist"> 
            <a href="#" class="tnail"></a> 
            <span class="group"></span> 
            <span class="thumb"> <img src ="img/2325321.jpg"> </span>
             <span class="grup">
              <h4>Darkness</h4>
              </span> 
              <span class="info"> 
              <span class="year">2014.09.11</span>
              </span>
              <span class="subject">
               <span class="artist">티아라(T-ara)</span> 
               <span class="titlename">Sugar Free (BigRoom ver.)</span> 
               </span> 
               <span class="play"> 
               <span class="home">앨범보기</span> 
               <span class="like">듣기</span> 
               </span> 
               </div>
            </li>
        </ul>
      </div>
			<!-- 차트 -->
			<div class="subcenter">
				<div class="login">
					<div class="login-box-body">
						<h2>
							<strong>로그인</strong>
						</h2>
						<form action="j_spring_security_check" method="post">
							<div class="form-group has-feedback">
								<input type="text" class="form-control" placeholder="아이디"
									name="j_username" /> <span
									class="glyphicon glyphicon-user form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="password" class="form-control" placeholder="패스워드"
									name="j_password" /> <span
									class="glyphicon glyphicon-lock form-control-feedback"></span>
							</div>
							<div class="row">
								<div class="col-xs-8">
									<div class="checkbox icheck">
										<label> <input type="checkbox" id="idcheck">
											아이디 저장
										</label>
									</div>
								</div>
								<!-- /.col -->
								<div class="col-xs-4">
									<button type="submit"
										class="btn btn-primary btn-block btn-flat">로그인</button>
								</div>
								<div class="userinfo">
									<ul class="infolist">
										<li><a href="./join" class="userlink">회원가입</a> <span
											class="textbar"></span></li>
										<li><a href="#" class="userlink">계정찾기</a> <span
											class="textbar"></span></li>
										<li><a href="#" class="userlink">비밀번호찾기</a></li>
									</ul>
								</div>
								<!-- /.col -->
							</div>
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
									class="info-box-number">${musictotal }곡</span>



							</div>
							<!-- /.info-box-content -->
						</div>
						<!-- /.info-box -->

						<div class="info-box">
							<span class="info-box-icon"><i class="fa fa-play-circle"></i></span>
							<div class="info-box-content">
								<span class="info-box-text">라디오 채널수</span> <span
									class="info-box-number">${radiototal}채널</span>
							</div>
							<!-- /.info-box-content -->
						</div>
						<!-- /.info-box -->

						<div class="info-box">
							<span class="info-box-icon"><i class="fa fa-cloud-upload"></i></span>
							<div class="info-box-content">
								<span class="info-box-text">오늘 등록된 음원수</span> <span
									class="info-box-number">${todaymusictotal }곡</span>
							</div>
							<!-- /.info-box-content -->
						</div>
						<!-- /.info-box -->

						<div class="info-box">
							<span class="info-box-icon"><i class="fa  fa-users"></i></span>
							<div class="info-box-content">
								<span class="info-box-text">총 유저수</span> <span
									class="info-box-number">${membertotal }명</span>
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
						<li><a href="#">[공지] Favorite Music 테스트중</a></li>
						<li><a href="#">[안내] Favorite Music App</a></li>
						<li><a href="#">[안내] Favorite Music 정기 정검</a></li>
						<li><a href="#">[안내] Favorite Music 회원 가입</a></li>
						<li><a href="#">[공지] Favorite Music 기능 추가 관련</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- end center -->
	<%@ include
		file="inc/footer.jsp"%>
</body>
<script src="resources/test/js/main.js" type="text/javascript"></script>
</html>

