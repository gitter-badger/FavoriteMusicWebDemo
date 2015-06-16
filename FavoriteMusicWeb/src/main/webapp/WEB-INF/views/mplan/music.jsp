<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jquery-ajax-form-submit/</title>
<!-- jQuery import -->
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<!-- jQuery Form Plugin import -->
<script
	src="<%=request.getContextPath()%>/resources/js/jquery/jquery.form.min.js"></script>
</head>
<body>

	<h3>Favorite 아티스트등록</h3>
	<form name="multiform" id="multiform"
		action="<%=request.getContextPath()%>/labelinsert" method="POST"
		enctype="multipart/form-data">
		아티스트 : <input type="text" size="20px" name="artist" /> <br /> 
		데뷔년도 : <input type="text" size="20px" name="debut" /> <br /> 
		특징/소개 : <textarea rows="10" cols="20" size="20px" name="content"></textarea><br /> 
		레이블 : <input type="text" size="20px" name="label" /> <br />
		이미지 : <input type="file" class="afile3" name="imgupload" /> <br />
        사용여부 : 
        <table width="200">
          <tr>
            <td><label>
              <input type="radio" name="RadioGroup1" value="Y" id="RadioGroup1_0">
              사용</label></td>
          </tr>
          <tr>
            <td><label>
              <input type="radio" name="RadioGroup1" value="N" id="RadioGroup1_1">
              사용불가</label></td>
          </tr>
        </table>
      <input type="submit" id="btnSubmit" value="전송" /><br />
	</form>

	<div id="result"></div>


	<script>
		/*jQuery form 플러그인을 사용하여 폼데이터를 ajax로 전송*/

		var downGroupCnt = 0; //다운로드그룹 개수카운트

		$(function() {

			//폼전송 : 해당폼의 submit 이벤트가 발생했을경우 실행  
			$('#multiform').ajaxForm({
				cache : false,
				dataType : "json",
				//보내기전 validation check가 필요할경우
				beforeSubmit : function(data, frm, opt) {
					//console.log(data);
					alert("데이터 입력중입니다.");
					return true;
				},
				//submit이후의 처리
				success : function(data, statusText) {

					alert("데이터 전송 완료");
					console.log(data); //응답받은 데이터 콘솔로 출력         

					output(data); //받은 정보를 화면 출력하는 함수 호출
				},
				//ajax error
				error : function(e) {
					alert("에러발생!!");
					console.log(e);
				}
			});
		});

		//전달받은 정보를 가지고 화면에 보기 좋게 출력
		function output(data) {
			//업로드한 파일을 다운로드할수있도록 화면 구성
			$("#result").append("<h3>(" + (++downGroupCnt) + ") 다운로드</h3>");
			$("#result").append("가수:" + data.artist + "<br/>");
			$("#result").append("제목:" + data.title + "<br/>");
		

			if (data.downlinkimg != null) {
				$("#result").append(
						"파일 :<a href='"+ data.downlinkimg +"' download>"
								+ data.fimgName + "</a>");
				$("#result").append("<br/>");

			}
			if (data.downlink192k != null) {
				$("#result").append(
						"파일 :<a href='"+ data.downlink192k +"' download>"
								+ data.f192Name + "</a>");
				$("#result").append("<br/>");

			}
			if (data.downlink320k != null) {
				$("#result").append(
						"파일 :<a href='"+ data.downlink320k +"' download>"
								+ data.f320Name + "</a>");
				$("#result").append("<br/>");

			}
			$('#multiform').clearForm(); //(jQuery.Form 플러그인 메서드)

		}
	</script>

</body>
</html>
