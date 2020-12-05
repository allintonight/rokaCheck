$('#btn-vacationRegister').on('click', function(e) {
	e.preventDefault();
	var data =  {
			username: $("#username").val(),
			checkin: $("#checkin").val(),
			checkout: $("#checkout").val(),
			status: $("#status").val()
		};

$.ajax({
		type: "POST",
		url : "/vacation/"+data.username,
		data : JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		dataType : "json"
	}).done(function(r) {
		if (r.status == 200) {
			console.log(r);
			alert("휴가등록 성공");
			location.href = "/main";
		} else {
				console.log(r);
				alert('회원가입 실패');
			}
	}).fail(function(r) {
		var message = JSON.parse(r.responseText);
		console.log((message));
		alert('서버 오류');
	});
});