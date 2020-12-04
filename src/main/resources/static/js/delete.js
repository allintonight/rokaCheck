$('#btn-delete').on('click', function() {
	var data =  {
			username: $("#username").val()
		};

	$.ajax({
		type : "delete",
		url : "/user/"+username,
		data : JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		dataType : "json"
	}).done(function(r) {
		if (r.status == 200) {
			console.log(r);
			alert("삭제 성공");
			location.href = "/main";
		} 
	}).fail(function(r) {
		var message = JSON.parse(r.responseText);
		console.log((message));
		alert('서버 오류');
	});
});

