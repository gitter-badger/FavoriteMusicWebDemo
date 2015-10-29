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

	<h3>Favorite 음원 업로드</h3>
	<form name="multiform" id="multiform"
		action="<%=request.getContextPath()%>/fileuploads" method="POST"
		enctype="multipart/form-data">
			넘버 : <select name = "num">
		  <option value="1">1</option>
		  <option value="2">2</option>
		  <option value="3">3</option>
		  <option value="4">4</option>
		  <option value="5">5</option>
		  <option value="6">6</option>
		  <option value="7">7</option>
		  <option value="8">8</option>
		  <option value="9">9</option>
		  <option value="10">10</option>
		  <option value="11">11</option>
		  <option value="12">12</option>
		  <option value="13">13</option>
		  <option value="14">14</option>
		  <option value="15">15</option>
		  <option value="16">16</option>
		  <option value="17">17</option>
		  <option value="18">18</option>
		  <option value="19">19</option>
		  <option value="20">20</option>
		  <option value="21">21</option>
		  <option value="22">22</option>
		  <option value="23">23</option>
		  <option value="24">24</option>
		  <option value="25">25</option>
		  <option value="26">26</option>
		  <option value="27">27</option>
		  <option value="28">28</option>
		  <option value="29">29</option>
		  <option value="30">30</option>
        </select><br />
		아티스트 : <input type="text" size="20px" name="artist" /> <br /> 
		타이틀 : <input type="text" size="20px" name="title" /> <br /> 
		앨범명 : <input type="text" size="20px" name="album" /> <br /> 
		가사입력 : <textarea rows="10" cols="20" size="20px" name="lyric"></textarea><br /> 
		년도 : <input type="date" size="20px" name="year"><br />
		레이블 : <input type="text" size="20px" name="label" /> <br />
		유통사 : <input type="text" size="20px" name="corp" /> <br />
        1차 분류(가요/팝) : <select name="genre1">
          <option value="gayo">가요</option>
          <option value="pop">팝</option>
          <option value="jpop">일본음악</option>
          <option value="cpop">중국음악</option>
          <option value="worldmusic">월드뮤직</option>
        </select> 
        <br />
		2차 분류(장르) : <select name="genre2">
		  <option value="dance">댄스</option>
		  <option value="electronic">일렉트로닉</option>
		  <option value="rock">락</option>
		  <option value="ost">O.S.T</option>
		  <option value="balade">발라드</option>
		  <option value="rnb">R&amp;B</option>
		  <option value="hiphop">힙합</option>
		  <option value="trot">트롯트</option>
		  <option value="etc">기타</option>
		</select> <br />
		기타 : <input type="text" size="20px" name="etc" /> <br />
		오픈일 : <input type="datetime-local" name="copy"><br />
		연령제한 : <select name = "age">
  <option value="0">전체이용가</option>
  <option value="7">7세이용가</option>
  <option value="12">12세이용가</option>
  <option value="15">15세이용가</option>
  <option value="19">19세이용가</option>
</select>
     <br />
		<!-- 다중 파일업로드  -->
		이미지 : <input type="file" class="afile3" name="imgupload" /> <br />
		음질320K : <input type="file" class="afile3" name="m320kupload" /> <br />
		음질192K : <input type="file" class="afile3" name="m192kupload" /> <br />
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
					alert("전송전!!");
					return true;
				},
				//submit이후의 처리
				success : function(data, statusText) {

					alert("전송성공!!");
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
			$("#result").append("앨범:" + data.album + "<br/>");
			$("#result").append("가사:" + data.lyric + "<br/>");
			$("#result").append("연도:" + data.year + "<br/>");
			$("#result").append("회사:" + data.corp + "<br/>");
			$("#result").append("파일이름1:" + data.fimgName + "<br/>");
			$("#result").append("파일이름2:" + data.f192Name + "<br/>");
			$("#result").append("파일이름3:" + data.f320Name + "<br/>");

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
			//$('#multiform')[0].reset();  //폼 초기화(리셋);
			//$('#multiform').resetForm();   //위코드와 동일 (jQuery.Form 플러그인 메서드)
			$('#multiform').clearForm(); //(jQuery.Form 플러그인 메서드)

			//IE에서 폼 리셋후 input[type=file] 초기화 안되는 문제. 
			//(파일이름은 지워지지만 files 프로퍼티에는 파일정보 남아있음.)
			//참고 : http://javaking75.blog.me/220073388169
			/* if(/(MSIE|Trident)/.test(navigator.userAgent)) {
				//ie 일때 input[type=file] init.
				$("#multiform input[type=file]").each(function(index){
					$(this).replaceWith($(this).clone(true));
				});
			} */
		}
	</script>

</body>
</html>
