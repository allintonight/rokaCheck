<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
</sec:authorize>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>
<h1>R O K A 출타관리시스템</h1>
<nav class="navbar navbar-expand-sm bg-light navbar-light">
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
      <a class="nav-link disabled" href="#">군번</a>
    </li>

    <li class="nav-item">
      <a class="nav-link disabled" href="#">이름</a>
    </li>
    
 <li class="nav-item">
      <a class="nav-link" href="/logout">로그아웃</a>
    </li>
    
  </ul>
</nav>

<br>
