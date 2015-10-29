<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Yboard for AngularJS</title>
<link href="/web/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="/web/resources/bower_components/angular/angular.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="page-header">
			<h1>
				AngularJS</small>
			</h1>
		</div>
		<div class="row">
			<div class="col-md-8">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">검색창</div>
					<div class="panel-body">
						<div class="col-md-6">
							<div class="input-group">
								<input type="text" class="form-control"> <span
									class="input-group-btn">
									<button class="btn btn-default" type="button">검색</button>
								</span>
							</div>
						</div>
						<div class="col-md-3">
							<button type="button" class="btn btn-primary">추가</button>
							<button type="button" class="btn btn-danger">삭제</button>
						</div>
					</div>
					<!-- Table -->
					<table class="table table-striped" id="dataTable">
						<thead>
							<tr>
								<th><input type="checkbox"/></th>
								<th>아이디</th>
								<th>제목</th>
								<th>위선권</th>
								<th>닉네임</th>
								<th>남여</th>
								<th>날짜</th>
							</tr>							
						</thead>
						<tbody ng-controller="yboardList">
							<tr ng-repeat="yboard in yboards">
								<td><input type="checkbox"/></td>
								<td>{{board.boardID}}</td>
								<td>{{boardSearch.boardTitle}}</td>
								<td>{{boardSearch.priority}}</td>
								<td>{{boardSearch.userName}}</td>
								<td>{{boardSearch.userGender}}</td>
								<td>{{boardSearch.registDate}}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>			
			<div class="col-md-8">				
				<ul class="pagination">
					<li><a href="#">&laquo;</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">&raquo;</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
<script src="/web/resources/js/angular/yboard.js"></script>
</html>