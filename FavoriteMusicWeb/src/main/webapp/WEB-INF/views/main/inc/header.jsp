<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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



</body>
</html>
