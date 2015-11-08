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
	<link href="resources/test/css/mvlist.css" rel="stylesheet"
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
	<%@ include file="inc/header.jsp"%>
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
											</span>
											<c:if test="${object3.m_titleuse == 'Y'}">
												<span class="grup">
													<h4>Title</h4>
												</span>
											</c:if>
											<span class="info"> <span class="bit1">${object3.m_year}</span>
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
			
			<!--  MV  -->
			
			<div class="text">
				<h2>뮤직비디오</h2>

			</div>


			<div id="thelist">
				<div class="listtest">
					<ul>
						<c:choose>
							<c:when test="${not empty object4}">
								<c:forEach var="object4" items="${object4}" varStatus="status">
									<li>
										<div class="mvlist">
											<a href="#" class="tnail"></a> <span class="group"></span> <span
												class="thumb"> <img
												src="${resourcePath}/videoimg/${object4.mv_imgo}">
											</span>
											<c:if test="${object4.mv_release == 'N'}">
												<span class="grup">
													<h4>티저</h4>
												</span>
											</c:if>
											<span class="info"> <span class="bit1">${object4.mv_year}</span>
												<span class="bit2">${object4.mv_age}세</span>
											</span> <span class="info"></span> <span class="subject"> <span
												class="artist">${object4.mv_artist}</span> <span
												class="title">${object4.mv_title}</span> <span class="album">${object4.mv_album}</span>
											</span> <span class="play"> <span class="home"><a
													href="${resourcePath}/video/${object4.mv_mvko}"
													target="_blank">뮤비듣기</a></span> <span class="like">추천</span>
											</span>
										</div>
									</li>
								</c:forEach>
							</c:when>
							<c:when test="${empty object4}">

								<li>찾으시는 동영상이 없습니다.</li>
							</c:when>
						</c:choose>
					</ul>
				</div>

			</div>
		</div>
	</div>
	<!-- end center -->
	<!-- footer -->
	<%@ include file="inc/footer.jsp"%>
	<!-- end footer -->
</body>
<script src="resources/test/js/main.js" type="text/javascript"></script>
</html>

