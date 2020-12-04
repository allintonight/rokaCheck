<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<h1>R O K A 출타관리시스템</h1>
<form action="/auth/loginProc" method="post">
  <div class="form-group">
    <label for="email">군번</label>
    <input type="text" class="form-control" placeholder="군번을 입력하세요" id="username"  name="username">
  </div>
  <div class="form-group">
    <label for="pwd">비밀번호:</label>
    <input type="password" class="form-control" placeholder="비밀번호를 입력" id="password"  name="password">
  </div>

 <button id="btn-login" class="btn btn-primary">Submit</button>&nbsp;&nbsp;
</form>
  
 <button type="button" class="btn btn-primary" onclick="location.href='/auth/AdminjoinForm'">관리자 등록</button>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
