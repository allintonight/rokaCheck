$('#btn-adminUpdate').on('click', function() {
	var data =  {
			pwd: $("#pwd").val(),
			ranks: $("#ranks").val(),
			unit: $("#unit1").val() + $("#unit2").val() + $("#unit3").val() + $("#unit4").val(),
			phone: $("#phone").val()
		};

	$.ajax({
		type : "POST",
		url : "/adminUpdate",
		data : JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		dataType : "json"
	}).done(function(r) {
		if (r.status == 200) {
			console.log(r);
			alert("수정 성공");
			location.href = "/";
		} 
	}).fail(function(r) {
		var message = JSON.parse(r.responseText);
		console.log((message));
		alert('서버 오류');
	});
});

$('#btn-userUpdate').on('click', function() {
	var data =  {

			adress: $("#adress").val(),
			position: $("#position").val(),
			ranks: $("#ranks").val(),
			unit: $("#unit1").val() + $("#unit2").val() + $("#unit3").val() + $("#unit4").val(),
			phone: $("#phone").val(),
			parentsPhone: $("#parentsPhone").val()
		};

	$.ajax({
		type : 'POST',
		url : '/userUpdate',
		data : JSON.stringify(data),
		contentType : 'application/json; charset=utf-8',
		dataType : 'json'
	}).done(function(r) {
		if (r.status == 200) {
			console.log(r);
			alert('회원가입 성공');
			location.href = '/main';
		}
	}).fail(function(r) {
		var message = JSON.parse(r.responseText);
		console.log((message));
		alert('서버 오류');
	});
});
