<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>ROKA | 휴가등록</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<h1><a href="/main">R O K A 출타관리시스템 휴가 등록 페이지</a></h1>
	<form>
	  <div class="form-group">
	      <label for="username">휴가를 등록할 병사의 군번 : </label>
	    <input type="text" class="form-control" placeholder="군번 입력하세요" id="username">
	  </div>
	  <div>
	    <label for="checkin">휴가시작일 : </label>
	    <input type="date" class="form-control" placeholder="휴가시작일 입력하세요" id="checkin">
	  </div>
	  <div class="form-group">
	    <label for="checkout">휴가종료일 : </label>
	    <input type="date" class="form-control" placeholder="휴가종료일 입력" id="checkout">
	  </div>
	</form>
	<button id="btn-vacationRegister" class="btn btn-primary">휴가등록</button>
	<script src="/js/vacationRegister.js"></script>
</body>
</html>