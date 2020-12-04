<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<a href="/main"><h1>R O K A 출타관리시스템 병사 수정페이지</h1></a>
<form>
	<div class="form-group">
		<label for="username">군번:</label> <input type="text" class="form-control" id="username" placeholder="군번을 입력하세요" required>
		<div class="valid-feedback">Valid.</div>
	</div>

	<div class="form-group">
		<label for="adress">주소:</label> <input type="text" class="form-control" id="adress" placeholder="주소를 입력하세요" required>
		<div class="valid-feedback">Valid.</div>
	</div>
	<div class="form-group">
		<label for="position">직책:</label> <input type="text" class="form-control" id="position" placeholder="직책을 입력" required>
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
			<option>1사단</option>
			<option>2사단</option>
			<option>3사단</option>
		</select> <label for="sel3">연대 : </label> <select class="form-control" id="unit2">
			<option value="" selected>==해당사항없음==</option>
			<option>&nbsp;1연대</option>
			<option>&nbsp;2연대</option>
			<option>&nbsp;3연대</option>
		</select> <label for="sel4">대대 : </label> <select class="form-control" id="unit3">
			<option value="" selected>==해당사항없음==</option>
			<option>&nbsp;1대대</option>
			<option>&nbsp;2대대</option>
			<option>&nbsp;3대대</option>
		</select> <label for="sel5">중대 : </label> <select class="form-control" id="unit4">
			<option value="" selected>==해당사항없음==</option>
			<option>&nbsp;1중대</option>
			<option>&nbsp;2중대</option>
			<option>&nbsp;3중대</option>
		</select>

		<div class="form-group">
			<label for="phone">핸드폰 :</label> <input type="text" class="form-control" id="phone" placeholder="핸드폰번호를 입력하세요." required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">-을 제외한 번호만 입력 예)01035978787</div>
		</div>
		<div class="form-group">
			<label for="phone">부모님핸드폰 :</label> <input type="text" class="form-control" id="parentsPhone" placeholder="핸드폰번호를 입력하세요." required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">-을 제외한 번호만 입력 예)01035978787</div>
		</div>
</form>
<button id="btn-userUpdate" class="btn btn-primary">등록사항 수정</button>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="/js/update.js"></script>
