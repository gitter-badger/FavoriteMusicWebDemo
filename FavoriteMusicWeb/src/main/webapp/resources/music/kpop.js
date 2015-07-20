
function showList(listsearch) {
	var record = "";
	if (listsearch === null) {
		var listsearch = {
			start : 0,
			page : 1
		};
	}

	listsearch.limit = 10;
	listsearch.searchColumn = 'mp_genre1';
	listsearch.searchText = 'gayo';
	// ajax 설정
	$
			.ajax({
				type : 'POST',
				dataType : 'JSON',
				data : JSON.stringify(listsearch),
				contentType : "application/json; charset=UTF-8",
				url : '/web/allnew/musiclist',
				error : function() {
					alert("데이터가 에러 났습니다. 에러확인바랍니다.");
				},
				// 성공시 html 뿌려주기
				success : function(jsontotal) {
					if (jsontotal.success) {
						$
								.each(
										jsontotal.items,
										function(i, listview) {
											record += '<tr>'
													+ '<td><input type="checkbox" name="mp_mpnum" value="'
													+ listview.mpssnumEncrypt
													+ '"/></td>'
													+ '<td>'
													+ '<img src="/sourceimg/'
													+ listview.mp_imgo
													+'" width="50px" height="50px">'									
													+ '</a>'
													+ '</td>'
													+ '<td><a href="#" onclick="ViewSelect(\''
													+ listview.mpssnumEncrypt
													+ '\')">'
													+ listview.mp_artist
													+ '</a></td>'
													+ '<td>'
													+ listview.mp_title
													+ '</td>'
													+ '<td>'
													+ listview.mp_album
													+ '</td>'
													+ '<td>'
													+ listview.mp_year
													+ '</td>'
													+ '<td>'
													+ 
													+ '</td>'
													+ '<td>'
													+ 
													+ '</td>' + '</tr>'
										});
						$('#dataTable > tbody').html(record);
						// page
						if (jsontotal.total > 0) {
							goPagination(jsontotal.total, 10, listsearch.page);
							$('#pagination').show();
						} else {
							$('#pagination').hide();
						}
					} else {
						alert('로딩이 안됩니다.');
					}

				}

			});
};




function goPagination(total, limit, page_index) {
	var options = {
		bootstrapMajorVersion : 3,
		currentPage : page_index,
		totalPages : Math.ceil(total / limit),
		numberOfPages : 10,
		onPageClicked : function(e, originalEvent, type, page) {
			var start = 0;
			// 1페이지라면
			if (page === 1) {
				start = 0;
			} else if (page > 1) {
				// 2페이지이상이면 10 ~ limit 건씩, 3페이지라면 20~limit 건씩 출력
				start = (page - 1) * limit;
			}
			var listsearch = {
				start : start,
				page : page
			};
			showList(listsearch); // 리스트를 새로 조회한다.
		}
	}
	$('#pagination').bootstrapPaginator(options);

}


/**
 * 폼을 리셋한다.
 * 
 * @param formID
 */
function resetForm(formID) {
	$("#" + formID).each(function() {
		this.reset();
	});
	$('#mp_mpnum').val('')
	$("#num option[value='1']").attr('selected', true);
	var bootstrapValidator = $('#' + formID).data('bootstrapValidator');
	if (bootstrapValidator != null) {
		bootstrapValidator.resetForm();
	}
}



/**
 * 일괄체크-해제
 */
$('#allCheck').click(function() {
	if (this.checked) {
		$(':checkbox[name="mp_mpnum"]').prop("checked", true);
	} else {
		$(':checkbox[name="mp_mpnum"]').prop("checked", false);
	}
});
//초기화
(function() {
	showList(null); // 0부터 1페이지를 출력
})();