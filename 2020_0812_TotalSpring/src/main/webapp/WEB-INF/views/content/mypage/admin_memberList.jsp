<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	function del(m_idx){
		
		if(!confirm("정말 삭제 하시겠습니까?"))return;
		
		location.href="member_delete.do?m_idx=" + m_idx;
		
	}
	
	function update(m_idx){
		
		location.href="update_form.do?m_idx=" + m_idx;
	}




</script>

</head>
<body>

<div class="memberBox">
     <h3 class="linkBox"><a href="admin_mypage.jsp?admin=member">회원리스트 <span class="badge">${list.size() }</span></a></h3>

     <div class="inner-in">
     
         <table class="table">
         <c:forEach var="member" items="${list }" varStatus="i">
             <tr>
                 <th class="col-sm-1">번호</th>
                 <th class="col-sm-3">이름</th>
                 <th class="col-sm-4">가입일자</th>
                 <th class="col-sm-2"></th>
             </tr>

             <tr>
                 <th>${i.count}</th>
                 <td>${member.m_name}</td>
                 <td>${member.m_regdate }</td>
                  <td>
                
                  <div class="btn-group">
                 
                 
                     <button type="button" class="btn btn-default" onclick="update(${member.m_idx})">수정</button>
                     <button type="button" class="btn btn-default" onclick="del(${member.m_idx})">삭제</button>
                 
                
                </div>
                </td>
             </tr>
             
             </c:forEach>
         </table>

     </div>

     <div class="a-btn"><a href="" class="btn btn-default">더보기</a></div>
 </div>

</body>
</html>