<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<a href="/main"><h1>R O K A 출타관리시스템 병사 등록 페이지</h1></a>
<form>
	<div class="form-group">
		<label for="username">군번 :</label> <input type="text" class="form-control" id="username" placeholder="군번을 입력하세요"  required>
		<div class="valid-feedback">Valid.</div>
		<div class="invalid-feedback">예) 11-508791</div>
	</div>
		<div class="form-group">
		<label for="name">이름:</label> <input type="text" class="form-control" id="name" placeholder="비밀번호를 입력하세요"  required>
		<div class="valid-feedback">Valid.</div>
	</div>
		<div class="form-group">
		<label for="address">주소:</label> <input type="text" class="form-control" id="address" placeholder="주소를 입력하세요"  required>
		<div class="valid-feedback">Valid.</div>
	</div>
		<div class="form-group">
		<label for="position">직책:</label> <input type="text" class="form-control" id="position" placeholder="직책을 입력"  required>
		<div class="valid-feedback">Valid.</div>
	</div>

	<div class="form-group">
		<label for="sel1">계급 : </label> <select class="form-control" id="ranks">
			<option>이병</option>
			<option>일병</option>
			<option>상병</option>
			<option>병장</option>
		</select>
	</div>
	<div class="form-group">
		<label for="sel2">사단 : </label> <select class="form-control" id="unit1">
			<option>1div</option>
			<option>2div</option>
			<option>3div</option>
		</select>
			<label for="sel3">연대 : </label> <select class="form-control" id="unit2">
			<option value="" selected>==해당사항없음==</option>
			<option>&nbsp;1r</option>
			<option>&nbsp;2r</option>
			<option>&nbsp;3r</option>
		</select>
		<label for="sel4">대대 : </label> <select class="form-control" id="unit3">
			<option value="" selected>==해당사항없음==</option>
			<option>&nbsp;1br</option>
			<option>&nbsp;2br</option>
			<option>&nbsp;3br</option>
		</select>
		<label for="sel5">중대 : </label> <select class="form-control" id="unit4">
			<option value="" selected>==해당사항없음==</option>
			<option> &nbsp;1co</option>
			<option> &nbsp;2co</option>
			<option> &nbsp;3co</option>
		</select>

	<div class="form-group">
		<label for="phone">핸드폰 :</label> <input type="text" class="form-control" id="phone" placeholder="핸드폰번호를 입력하세요."  required>
		<div class="valid-feedback">Valid.</div>
		<div class="invalid-feedback">-을 제외한 번호만 입력 예)01035978787</div>
	</div>
	<div class="form-group">
		<label for="parentsPhone">부모님핸드폰 :</label> <input type="text" class="form-control" id="parentsPhone" placeholder="핸드폰번호를 입력하세요."  required>
		<div class="valid-feedback">Valid.</div>
		<div class="invalid-feedback">-을 제외한 번호만 입력 예)01035978787</div>
	</div>

</form>
<button id="btn-userJoin" class="btn btn-primary"> 병사등록 </button>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="/js/join.js"></script>
