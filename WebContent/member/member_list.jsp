<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL사용하려면 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap Library -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
#box {
	width: 1000px;
	margin: auto;
	margin-top: 30px;
}

#title {
	text-align: center;
	font-size: 24pt;
	font-weight: bold;
	font-family: D2Coding, 휴면엑스포;
	color: #5566ff;
	text-shadow: 1px 1px 1px black;
}
</style>

<script type="text/javascript">

function del(f){
	
	if(!confirm("정말 삭제 하시겠습니까?"))return;
	
	location.href="delete.do?m_idx=" + f.m_idx.value;
	
	
}

function send(m_idx){
	
	location.href="modify_form.do?m_idx=" + m_idx;
	
}

</script>
</head>
<body>
	<div id="box">
		<h1 id="title">::::회원목록::::</h1>
		<div align="right">
			<input class="btn btn-primary" type="button" value="회원가입"
				onclick="location.href='insert_form.do'">
			<input class="btn btn-primary" type="button" value="회원가입2"
				onclick="location.href='insert_form2.do'">
		</div>
		<br>
		<!-- 목록출력 -->
		<div>
			<table class="table table=striped">
				<!-- table title -->
				<tr class="info">
					<th>번호</th>
					<th>아이디</th>
					<th>이름</th>
					<th>비밀번호</th>
					<th>우편번호</th>
					<th>주소</th>
					<th>IP</th>
					<th>가입일자</th>
					<th>회원구분</th>
					<th style="text-align: center;">편집</th>
				</tr>

				<!-- table data  -->
				<c:forEach var="vo" items="${list}">
					<form>
					<input type="hidden" name="m_idx" value="${vo.m_idx }">
					<tr>
						<td>${vo.m_idx }</td>
						<td>${vo.m_id }</td>
						<td>${vo.m_name }</td>
						<td>${vo.m_pwd }</td>
						<td>${vo.m_zipcode }</td>
						<td>${vo.m_addr }</td>
						<td>${vo.m_ip }</td>
						<td>${fn:substring(vo.m_regdate,0,10) }</td>
						<td>${vo.m_grade }</td>
						<td><input class="btn btn-warning" type="button" value="수정"
							onclick="send('${vo.m_idx}')";>
							<input class="btn btn-danger" type="button" value="삭제"
							onclick="del(this.form);"></td>
					</tr>
					</form>
				</c:forEach>

			</table>


		</div>

	</div>


</body>
</html>