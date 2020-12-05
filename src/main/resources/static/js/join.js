$('#btn-adminJoin').on('click', function(e) {
	e.preventDefault();
	var data =  {
			username: $("#username").val(),
			password: $("#password").val(),
			name: $("#name").val(),
			ranks: $("#ranks").val(),
			unit: $("#unit1").val() + $("#unit2").val() + $("#unit3").val() + $("#unit4").val(),
			phone: $("#phone").val()
		};
	$.ajax({
			type: "POST",
			url: "/auth/adminJoinProc",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			async: false,
			success: (response) => {
				console.log(response);
				alert("회원가입 성공");
				location.href = "/";
			}
		})
		.fail(function(r) {
			var message = JSON.parse(r.responseText);
			console.log((message));
			alert('서버 오류');
		});
		
	});

$('#btn-userJoin').on('click', function(e) {
	e.preventDefault();
	var data =  {
			username: $("#username").val(),
			name: $("#name").val(),
			address: $("#address").val(),
			position: $("#position").val(),
			ranks: $("#ranks").val(),
			unit: $("#unit1").val() + $("#unit2").val() + $("#unit3").val() + $("#unit4").val(),
			phone: $("#phone").val(),
			parentsPhone: $("#parentsPhone").val()
		};

	$.ajax({
		type : 'POST',
		url : '/userJoinProc',
		data: JSON.stringify(data),
		contentType : 'application/json; charset=utf-8',
		dataType : 'json'
	}).done(function(r) {
		if (r.status == 200) {
			console.log(r);
			alert('회원가입 성공');
			location.href = "/main";
		} else {
			if (r.msg == '아이디중복') {
				console.log(r);
				alert('아이디가 중복되었습니다.');
			} else {
				console.log(r);
				alert('회원가입 실패');
			}
		}
	}).fail(function(r) {
		var message = JSON.parse(r.responseText);
		console.log((message));
		alert('서버 오류');
	});
});
