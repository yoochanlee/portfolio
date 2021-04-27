<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
	<body>
	<div class="cafeCategroy">
	
        <div class="title">
            <h3># 어디로 가볼까?</h3>
        </div>
	
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/cafe/cafe_sort.do?c_addr=&c_i=0">
                    <img src="${pageContext.request.contextPath}/resources/img/category/all.jpg" class="img-rounded" alt="Cinque Terre">
                    <h3>이번주 베스트 </h3>
                </a>
            </li>
            
            <li>
                <a href="${pageContext.request.contextPath}/cafe/cafe_sort.do?c_addr=서울&c_i=0">
                    <img src="${pageContext.request.contextPath}/resources/img/category/seoul.jpg" class="img-rounded" alt="Cinque Terre">
                    <h3>서울은 여기로</h3>
                </a>
            </li>
            
            <li>
                <a href="${pageContext.request.contextPath}/cafe/cafe_sort.do?c_addr=경기&c_i=0">
                    <img src="${pageContext.request.contextPath}/resources/img/category/gurdgi.jpg" class="img-rounded" alt="Cinque Terre">
                    <h3>경기는 여기로</h3>
                </a>
            </li>
            
            <li>
                <a href="${pageContext.request.contextPath}/cafe/cafe_sort.do?c_addr=인천&c_i=0">
                    <img src="${pageContext.request.contextPath}/resources/img/category/inchun.jpg" class="img-rounded" alt="Cinque Terre">
                    <h3>인천은 여기로</h3>
                </a>
            </li>
            
            <li>
                <a href="${pageContext.request.contextPath}/cafe/cafe_sort.do?c_addr=강원&c_i=0">
                    <img src="${pageContext.request.contextPath}/resources/img/category/gangwon.jpg" class="img-rounded" alt="Cinque Terre">
                    <h3>강원은 여기로</h3>
                </a>
            </li>
            
            <li>
                <a href="${pageContext.request.contextPath}/cafe/cafe_sort.do?c_addr=부산&c_i=0">
                    <img src="${pageContext.request.contextPath}/resources/img/category/busan.jpg" class="img-rounded" alt="Cinque Terre">
                    <h3>부산은 여기로</h3>
                </a>
            </li>
        </ul>
			
    </div>	
    
	</body>
</html>