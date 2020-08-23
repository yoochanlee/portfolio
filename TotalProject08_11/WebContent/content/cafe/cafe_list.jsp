<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
    
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <title>Document</title>
    
  <style type="text/css">
  	.inner-in{width: 800px !important; margin: 0 auto;}
  </style>  
  

</head>

<body>

    <header>
    	<%@ include file="../header/header.jsp" %>
    </header>

    <div id="content" >
    	<div class="jumbotron" id="main_text">
		    <h2>우리동네 카페 베스트</h2>      
		    <p>각 ${param.c_addr }별 유명한 카페를 한눈에! <br> WOW <br> ^오^ </p>
		 </div>
		  
		<div class="inner-in">
			
			<div class="cafe_list">
				
			<div class="listBox">
				<ul class="list">
				<c:forEach var="cafe" items="${list }">
					<li>
						<div class="cafeListBox">
						    <div class="cafeInfoImg">
						      <a href="${pageContext.request.contextPath}/cafe/cafe_detail_form.do?c_idx=${cafe.c_idx}"><img src="../../${pageContext.request.contextPath}/upload/${cafe.c_photo}"></a>
						    </div>
						    <div class="cafeInfoBox">
						    
						      <h4 class="cafeInfoTitle"> ${cafe.c_name }  ${cafe.ca_list.avg }</h4>
						      
						      
						      <h3>Best review!</h3>
						      
						      <h4>${cafe.ca_list.r_cot }</h4>
						      
						      <a href="${pageContext.request.contextPath}/cafe/cafe_detail_form.do?c_idx=${cafe.c_idx}" id="more">more</a>
						    </div>
					  </div>
					</li>
					</c:forEach>
				</ul>
			</div>
	
			<div class="pageBox">
		        <ul class="pagination">
		        <c:forEach var="c" begin="1" end="${b}" varStatus="i">
		            <li><a href="${pageContext.request.contextPath}/cafe/cafe_sort.do?c_addr=${param.c_addr }&c_i=${i.count-1}">${i.count}</a></li>
		            </c:forEach>
		        </ul>
	     	</div>
					
		</div>
			
		</div>
		
		<%@ include file="../etc/scrool.jsp" %>
	</div>

    <footer>
    	<%@ include file="../footer/footer.jsp" %>
    </footer>

</body>

</html>