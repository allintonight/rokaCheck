<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">


<a href="/main"><h1>R O K A 출타관리시스템 관리자 수정 페이지</h1></a>
<form>
	<div class="form-group">
		<label for="username">군번:</label> <input type="username" class="form-control" id="username" value="${user.username}"  readonly="readonly">

	<div class="form-group">
		<label for="pwd">패스워드:</label> <input type="password" class="form-control" id="password" placeholder="비밀번호를 입력하세요"  required>
		<div class="valid-feedback">Valid.</div>
		<div class="invalid-feedback">특수문자포함 10자리이상 입력</div>


	<div class="form-group">
		<label for="sel1">계급 : </label> <select class="form-control" id="ranks">
			<option>하사</option>
			<option>중사</option>
			<option>상사</option>
			<option>원사</option>
			<option>준위</option>
			<option>소위</option>
			<option>중위</option>
			<option>대위</option>
			<option>소령</option>
			<option>중령</option>
			<option>대령</option>
			<option>소장</option>
			<option>중장</option>
			<option>대장</option>
		</select>
	</div>
	<div class="form-group">
		<label for="sel2">사단 : </label> <select class="form-control" id="unit1">
			<option>1사단</option>
			<option>2사단</option>
			<option>3사단</option>
		</select>
			<label for="sel3">연대 : </label> <select class="form-control" id="unit2">
			<option value="" selected>==해당사항없음==</option>
			<option>&nbsp;1연대</option>
			<option>&nbsp;2연대</option>
			<option>&nbsp;3연대</option>
		</select>
		<label for="sel4">대대 : </label> <select class="form-control" id="unit3">
			<option value="" selected>==해당사항없음==</option>
			<option>&nbsp;1대대</option>
			<option>&nbsp;2대대</option>
			<option>&nbsp;3대대</option>
		</select>
		<label for="sel5">중대 : </label> <select class="form-control" id="unit4">
			<option value="" selected>==해당사항없음==</option>
			<option> &nbsp;1중대</option>
			<option> &nbsp;2중대</option>
			<option> &nbsp;3중대</option>
		</select>

	<div class="form-group">
		<label for="phone">핸드폰 :</label> <input type="text" class="form-control" id="phone" placeholder="핸드폰번호를 입력하세요."  required>
		<div class="valid-feedback">Valid.</div>
		<div class="invalid-feedback">-을 제외한 번호만 입력 예)01035978787</div>
	</div>

</form>

<button id="btn-adminUpdate" class="btn btn-primary"> 관리자 수정 </button>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="/js/update.js"></script>
