<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp" %>


<h1 id="blog-list-title">

    <a id="content_title" href="/main">보안시설출입현황</a>
</h1>
 <div class="card mb-3">
                <div class="card-header">
                    <i class="fas fa-table"></i>
                    탄약고 출입 현황</div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                                <tr>
                                    <th>군번</th>
                                    <th>계급+이름</th>
                                    <th>출입시간</th>
                                    <th>퇴장시간</th>
                                </tr>
                            </thead>
<c:forEach var ="bullet" items="${bulletList}">
                            <tbody>
                                <tr>
                                    <th scope="row">${bullet.username}</th>
                                    <td>${bullet.name}</td>
                                    <td>${bullet.checkin}</td>
                                    <td>${bullet.checkout}</td>
                                </tr>
                            </tbody>
 </c:forEach>

                        </table>
                    </div>
                </div>
                <div class="card-footer small text-muted">Updated 1 minute ago</div>
            </div>
            
            <br>
             <div class="card mb-3">
                <div class="card-header">
                    <i class="fas fa-table"></i>
                    무기고 출입 현황</div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                                <tr>
                                    <th>군번</th>
                                    <th>계급+이름</th>
                                    <th>출입시간</th>
                                    <th>퇴장시간</th>
                                </tr>
                            </thead>
<c:forEach var ="weapon" items="${weaponList}">
                            <tbody>
                                <tr>
                                    <th scope="row">${weapon.username}</th>
                                    <td>${weapon.name}</td>
                                    <td>${weapon.checkin}</td>
                                    <td>${weapon.checkout}</td>
                                </tr>
                            </tbody>
 </c:forEach>

                        </table>
                    </div>
                </div>
                <div class="card-footer small text-muted">Updated 1 minute ago</div>
            </div>
            
            <br>
             <div class="card mb-3">
                <div class="card-header">
                    <i class="fas fa-table"></i>
                   대외비보관소 출입 현황</div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                                <tr>
                                    <th>군번</th>
                                    <th>계급+이름</th>
                                    <th>출입시간</th>
                                    <th>퇴장시간</th>
                                </tr>
                            </thead>
<c:forEach var ="security" items="${securityList}">
                            <tbody>
                                <tr>
                                    <th scope="row">${security.username}</th>
                                    <td>${security.name}</td>
                                    <td>${security.checkin}</td>
                                    <td>${security.checkout}</td>
                                </tr>
                            </tbody>
 </c:forEach>

                        </table>
                    </div>
                </div>
                <div class="card-footer small text-muted">Updated 1 minute ago</div>
            </div>
            
            <br>
                   
                      	
</body>
</html>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>