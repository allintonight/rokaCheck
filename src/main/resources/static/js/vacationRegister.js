$('#btn-vacationRegister').on('click', function(e) {
	e.preventDefault();
	var data =  {
			username: $("#username").val(),
			checkin: $("#checkin").val(),
			checkout: $("#checkout").val(),
		};

	$.ajax({
			type: "POST",
			url : "/api/1.0/vacations/" + data.username,
			data : JSON.stringify(data),
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			success: (response) => {
				alert("휴가등록 성공");
				location.href = "/main";
			}
		})
	.fail(function(r) {
		var message = JSON.parse(r.responseText);
		console.log((message));
		alert('서버 오류');
	});
});