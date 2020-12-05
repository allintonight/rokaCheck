<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<style>
	body {
		font-family: 'Noto Sans KR', sans-serif !important;
		padding: 20px 50px;
	}
</style>
</head>
<body>
<h1 class="text-center">R O K A 출타관리시스템</h1>
<nav class="navbar navbar-expand-sm bg-light navbar-light d-flex justify-content-center">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="#">R O K A 출타관리시스템</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/userJoinForm">병사등록</a>
    </li> 
    <li class="nav-item">
      <a class="nav-link" href="/userUpdateForm">병사정보수정</a>
    </li>
        <li class="nav-item">
      <a class="nav-link" href="/adminUpdateForm">관리자정보수정</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/eye">홍채등록</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/vacationRegister">휴가등록</a>
    </li>
    
    <li class="nav-item">
      <a class="nav-link" href="/security">보안시설출입현황</a>
    </li>
     <li class="nav-item">
      <a class="nav-link" href="/status">병력상태조회</a>
    </li>
    <li class="nav-item">

      <a class="nav-link disabled" id="userName" href="#">${user.username}</a>
    </li>

    <li class="nav-item">
      <a class="nav-link disabled" href="#">${user.name}</a>

    </li>
    
 <li class="nav-item">
      <a class="nav-link" href="/logout">로그아웃</a>
    </li>
    
  </ul>
</nav>

<br>
