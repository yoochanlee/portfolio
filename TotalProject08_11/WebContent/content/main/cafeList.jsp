<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="cafeList" >
		<div class="title"><h3>CAFE가 모였다</h3></div>
			
		<div class="list">
			<ul>
			
			<c:forEach var="ca" items="${list4 }">
				<li>
					<a class="imgBox" href="${pageContext.request.contextPath}/cafe/cafe_detail_form.do?c_idx=${ca.c_idx}">
						<img src="${pageContext.request.contextPath}/upload/${ca.c_photo}" alt="Cinque Terre">
					</a>	
					<a href="${pageContext.request.contextPath}/cafe/cafe_detail_form.do?c_idx=${ca.c_idx}">
						<h5>${ca.c_name }</h5>
					</a>	
					<p>${ca.c_addr }</p>
				</li>
			</c:forEach>	
				
			</ul>
		</div>

		<div class="more">
			<div class="a-btn"><a href="${pageContext.request.contextPath}/content/cafe/cafe_list.jsp" class="btn btn-default">더보기</a></div>
		</div>
				
	</div>

		
	</body>
</html>