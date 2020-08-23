<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function send(c_idx){
	
	location.href="cafe/update_form.do?c_idx=" + c_idx;
	
}
function del(c_idx){
	if(!confirm("정말 삭제 하시겠습니까?"))return;
	location.href="cafe/cafe_delete.do?c_idx=" + c_idx;
	
}
</script>
</head>
<body>

<div class="cafeBox">
    <h3 class="linkBox"><a href="admin_mypage.jsp?admin=cafe">카페 목록</a></h3>

    <table class="table">
        <tr>
            <th class="col-sm-1">번호</th>
            <th class="col-sm-3">카페이름</th>
            <th class="col-sm-4">카페주소</th>
            <th class="col-sm-2"></th>
        </tr>
<c:forEach var="cafe" items="${list1 }" varStatus="num">
        <tr>
            <td>${ num.count}</td>
            <td><a href="${pageContext.request.contextPath}/cafe/cafe_detail_form.do?c_idx=${cafe.c_idx}">${cafe.c_name }</a></td>
            <td>${cafe.c_addr }</td>
            
            <td>
                <div class="btn-group">
                	<!-- /admin_mypage.jsp?admin=edit -->
                    <input type="button" class="btn btn-default" value="수정" onclick="send('${cafe.c_idx}')";>
                    <input type="button" class="btn btn-default" value="삭제" onclick="del('${cafe.c_idx}')";>
                </div>
            </td>
        </tr>
      </c:forEach>
    </table>

    <div class="a-btn"><a href="" class="btn btn-default">더보기</a></div>
</div>

</body>
</html>