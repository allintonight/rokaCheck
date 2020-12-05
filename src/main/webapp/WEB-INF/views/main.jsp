<%@page import="java.time.LocalDate"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap" rel="stylesheet">
<style>
	li {
		list-style: none;
	}
	
	.container {
		display: flex;
		justify-content: space-between;
	}
	
	table {
		text-align: center;
	}
	
	.list-group-item {
		cursor: pointer;
	}
	
	.user_info {
	    font-size: 1.2rem;
	    display: flex;
	    width: 60%;
	    margin: 0 auto;
	    padding-bottom: 30px;
	}
	
	.user_info span:last-child {
	    color: gray;
	    margin-left: auto;
}
</style>
</head>
<body>
<%@ include file = "header.jsp" %>
<p class="user_info">소속: <span class="userUnit">${user.unit}</span><span><%=LocalDate.now() %></span></p>
<div class="container">
	<aside class="aside list-group">
		<ol>
			<c:set var="units" value="" />
			<c:forTokens items="${user.unit}" delims=" " var="item" varStatus="i">			
			<c:set var="units" value="${units} ${item}" />
			<li class="list-group-item list-group-item-action ${i.last? 'active' : ''}"
			data-unit="${units}"
			onclick="renderMain(event)"><b class="userUnit">${item}</b> <span></span>/<span>${totalCounts[i.index]}</span></li>
			</c:forTokens>
		</ol>
	</aside>
	<main>
		<div class="content">
	  		<h2><span class="userUnit">${user.unit}</span> 복귀현황</h2>          
			<h5 class="text-right"><small class="text-muted">(복귀인원)</small><span id="completeCount">%복귀인원%</span>/${page.totalElements}<small class="text-muted">(총 복귀 예정인원)</small></h5>
	  		<table class="table table-striped">
		    	<thead>
		      		<tr>
				        <th>군번</th>
				        <th>계급</th>
				        <th>이름</th>
				        <th>전화번호</th>
				        <th>부모님 전화번호</th>
				        <th>휴가 출발</th>
				        <th>휴가 복귀</th>
				        <th>복귀 유무</th>
				        <th>비고</th>
		      		</tr>
		    	</thead>
		    <tbody>
		    <c:forEach var="item" items="${page.content}">
		      <tr>
		        <td>${item.user.username}</td>
		        <td>${item.user.ranks}</td>		        
		        <td>${item.user.name}</td>
		        <td>${item.user.phone}</td>
		        <td>${item.user.parentsPhone}</td>
		        <td>${item.checkin}</td>
		        <td>${item.checkout}</td>
		        <c:choose>
		        	<c:when test="${item.status eq 'COMPLETED'}">
				        <td class="status">✅</td>
				        <td data-id="${item.user.username}"><button onclick="onClickSendSmsBtn(event)">SMS 전송</button></td>
		        	</c:when>
		        	<c:otherwise>
				        <td class="status">❌</td>
				        <td data-id="${item.user.username}"><button onclick="onClickCameBackBtn(event)">복귀 확인</button></td>		        	
		        	</c:otherwise>
		        </c:choose>
		      </tr>
	      	</c:forEach>
		    </tbody>
		  </table>
		</div>
	</main>
</div>

</body>
<script src="/js/main.js"></script>
</html>