<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp" %>
<h1 id="blog-list-title">
    <a id="content_title" href="/main">병력상태현황</a>
</h1>

<br><br>

<!-- msgboards Post -->
<c:forEach var="user"  items="${userList.content}">
<div class="card mb-4" id="post-card-${user.no}">
    <div class="card-body">
        <h2 class="card-title"><img alt="user" src="/images/군인.png"></h2>
        <h5 class="card-title">군번 : "${user.username}"</h5><br>
        <h5 class="card-title">이름 : "${user.name}"</h5><br>
        <h5 class="card-title">우울도 : <div class="progress"><div class="progress-bar" style="width:${user.depression}%">"${user.depression}%"</div></div></h5><br>
        <h5 class="card-title">피로도 : <div class="progress"><div class="progress-bar" style="width:${user.tire}%">"${user.tire}%"</div></div></h5><br>        
        <br/>
        <br/>
    </div>
</div>
</c:forEach>
<!-- Pagination -->
<ul class="pagination justify-content-center mb-4">
   <c:choose>
   <c:when test="${userList.first}">   
    <li class="page-item">
        <a class="page-link" href="?page=${userList.number-1}">&larr; 이전</a>
    </li>
    </c:when>
    <c:otherwise>
    <li class="page-item disabled">
        <a class="page-link" href="?page=${userList.number-1}">&larr; 이전</a>
    </li>
    </c:otherwise>
     </c:choose>
   <c:choose>
   <c:when test="${userList.last }">   
    <li class="page-item">
        <a class="page-link" href="?page=${userList.number+1}">&larr; 다음</a>
    </li>
    </c:when>
    <c:otherwise>
    <li class="page-item disabled">
        <a class="page-link" href="?page=${userList.number+1}">&larr; 다음</a>
    </li>
    </c:otherwise>
     </c:choose>
</ul>

</body>
</html>