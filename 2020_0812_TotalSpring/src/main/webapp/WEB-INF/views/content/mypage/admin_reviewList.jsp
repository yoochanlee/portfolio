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
function del3(r_idx){
	
	if(!confirm("정말 삭제 하시겠습니까?"))return;
	location.href="../review/review_delete.do?r_idx=" + r_idx;
}

function review_update(r_idx){
	location.href="../review/review_update_form.do?r_idx=" + r_idx
}



</script>

</head>
<body>

<div class="reviewBox">
     <h3 class="linkBox"><a href="admin_mypage.jsp?admin=review">오늘 신규 리뷰 <span class="badge">${list2.size() }</span></a></h3>

     <table class="table">
         <tr>
             <th class="col-sm-1">번호</th>
             <th class="col-sm-5">내용</th>
             <th class="col-sm-2">이름</th>
             <th class="col-sm-1">작성일</th>
             <th class="col-sm-2"></th>
             
         </tr>
		<c:forEach var="re" items="${list2 }" varStatus="i">
         <tr>
             <th>${i.count }</th>
             <td>${re.r_cot }</td>
             <td>${re.m_name }</td>
             <td>${fn:substring(re.r_regdate, 0, 10)}</td>
            <td>
             <div class="btn-group">
                <button type="button" class="btn btn-default" onclick="review_update('${re.r_idx}')">수정</button>	 
                 <button type="button" class="btn btn-default" onclick="del3('${re.r_idx}')">삭제</button>
                 
            
                </div>
                 </td>
         </tr>
         </c:forEach>
     </table>

     <div class="a-btn"><a href="admin_mypage.jsp?admin=review" class="btn btn-default">더보기</a></div>
 </div>

</body>
</html>