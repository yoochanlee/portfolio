<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function del2(r_idx){
	
	if(!confirm("정말 삭제 하시겠습니까?"))return;
	location.href="review/review_delete.do?r_idx=" + r_idx;
}

function review_update1(r_idx){
	location.href="review/review_update_form.do?r_idx=" + r_idx
}



</script>
<style type="text/css">
.reviewBox{
margin: 120px 0 0 !important;
}

</style>
</head>
<body>
	
	<header>
		<%-- ${pageContext.request.contextPath} --%>
		<%@ include file="../header/header.jsp" %>
	</header>
    
    
<div id="content">
	<div class="reviewBox">
		<div class="inner">
		     <h3 class="linkBox"><a href="admin_mypage.jsp?admin=review">내가 쓴 글 <span class="badge">${list.size() }</span></a></h3>
		
		     <table class="table">
		         <tr>
		             <th class="col-sm-1">번호</th>
		             <th class="col-sm-5">내용</th>
		             <th class="col-sm-2">이름</th>
		             <th class="col-sm-1">작성일</th>
		             <th class="col-sm-2"></th>
		             
		         </tr>
				<c:forEach var="my_re" items="${list }" varStatus="i">
		         <tr>
		             <th>${i.count }</th>
		             <td>${my_re.r_cot }</td>
		             <td>${my_re.m_name }</td>
		             <td>${fn:substring(my_re.r_regdate, 0, 10)}</td>
		            <td>
		             <div class="btn-group">
		                <button type="button" class="btn btn-default" onclick="review_update1('${my_re.r_idx}')">수정</button>	 
		                 <button type="button" class="btn btn-default" onclick="del2('${my_re.r_idx}')">삭제</button>
		                 
		            
		                </div>
		                 </td>
		         </tr>
		         </c:forEach>
		     </table>
		
		     <div class="a-btn"><a href="admin_mypage.jsp?admin=review" class="btn btn-default">더보기</a></div>
		</div>	     
     </div>
 </div>

</body>
</html>