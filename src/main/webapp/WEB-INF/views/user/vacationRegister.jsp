<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<a href="/main"><h1>R O K A 출타관리시스템 휴가 등록 페이지</h1></a>
<form>
  <div class="form-group">
      <label for="username">휴가를 등록할 병사의 군번 : </label>
    <input type="text" class="form-control" placeholder="군번 입력하세요" id="username">
  </div>
    <label for="checkin">휴가시작일 : </label>
    <input type="date" class="form-control" placeholder="휴가시작일 입력하세요" id="checkin">
  </div>
  <div class="form-group">
    <label for="checkout">휴가종료일 : </label>
    <input type="date" class="form-control" placeholder="휴가종료일 입력" id="checkout">
  </div>
 	<div class="form-group">
		<label for="sel1">휴가상태 : </label> <select class="form-control" id="status">
			<option>휴가중</option>
			<option>사용중</option>
			<option>사용완료</option>
		</select>

</form>
 <button id="btn-vacationRegister" class="btn btn-primary">휴가등록</button>
 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="/check/js/vacationRegister.js"></script>