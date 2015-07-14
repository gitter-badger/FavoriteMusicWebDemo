

	$(function(){
		$('#save_button').click(function() {
			 $('#formaction').submit();
		
	})
	
	 $('#frm').ajaxForm({
			beforeSubmit : function(data, form, option) {
				// console.log(data);
				alert("전송전!!");
				return true;
			},
			success : function(response, status) {
				filedone(response);
			},
			// ajax error
			error : function(e) {
				alert("에러발생!!");
				console.log(e);
			}
	 });
		 
	 })
	 
	 function filedone(response){
		if(typeof(execAttach) == 'undefined'){
			return;
		}
		var resobject = $.parseJSON(response);
		alert(resobject);
		execAttach(resboject);
		
	}
	function init(){
		var open = PopupUtil.getOpener();
		if(!open){
			alert("잘못된 경로");
			return;
		}
		var attacher = getAtacher('imger', open);
		alert(attacher);
		registerAction(attacher);
	}
	
	