<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<title>Document</title>
<script type="text/javascript">
var nameID = /^[가-힣]{2,4}|[a-zA-Z]{2,10}\s[a-zA-Z]{2,10}$/;

var pwdID = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;

var emailID = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;;

var telID = /^\d{3}-\d{3,4}-\d{4}$/;
/* jQuery 초기화 */
$(document).ready(function(){ 
 
 if('${vo.m_gender}' == '남성'){
	$("#m_man").attr("checked",true);
	}else{
	$("#m_woman").attr("checked",true);
	}
 var strArray = '${vo.m_tel}'.split('-');
 if(strArray[0]=='010'){
	 $("#m_one").attr("selected",true);
 }else{
	 $("#m_two").attr("selected",true);
 }
 
 
 $("#m_tel2").val(strArray[1]);
 $("#m_tel3").val(strArray[2]);
});



function update(f){
	var m_name = f.m_name.value.trim();
	var m_pwd = f.m_pwd.value.trim();
	var c_pwd = f.c_pwd.value.trim();
	var m_email = f.m_email.value.trim();
	
	var phoneNum1 = f.m_tel1.value;
    var phoneNum2 = f.m_tel2.value;
    var phoneNum3 = f.m_tel3.value;
    var phoneNumber = phoneNum1 + "-" + phoneNum2 + "-" + phoneNum3;
    
	
	if(pwdID.test(m_pwd)==false){
		alert('비밀번호를 입력하세요');
		f.m_pwd.value='';
		f.m_pwd.focus();
		return;
	}
	if(m_pwd!=c_pwd){
		alert('비밀번호가 다릅니다.');
		f.c_pwd.value='';
		f.c_pwd.focus();
		return;
	}
	if(nameID.test(m_name)==false){
		alert('이름을 입력하세요');
		f.m_name.value='';
		f.m_name.focus();
		return;
	}
	
	if(telID.test(phoneNumber)==false){
		alert('전화번호를 입력하세요');
		f.m_tel2.value='';
		f.m_tel3.value='';
		return;
	}
	if(emailID.test(m_email)==false){
		alert('이메일주소를 입력하세요');
		f.m_email.value='';
		f.m_email.focus();
		return;
	}
	
	if(!confirm("정말 수정 하시겠습니까?"))return;
	
	f.action = "member_update.do"
	f.submit();
	
  }
  
function del(m_idx){
	
	if(!confirm("정말 탈퇴 하시겠습니까?"))return;
	
	location.href="member_delete.do?m_idx=" + m_idx;
	
}
function update_image(f){
	if(!confirm("정말 업로드 하시겠습니까?"))return;
	
	f.action = "member_image_update.do"
	f.submit();
}
</script>
</head>

<body>

	<header>
		<%@ include file="../header/header.jsp"%>
	</header>

	<div id="content">
		<div class="inner">

			<div id="userJoin">
				<div class="inner-in">

					<div class="titleBox">
						<h2>회원정보 페이지</h2>


					</div>
					<form method="post" enctype="multipart/form-data">
						<div class="profileplace">
							<img class="img-responsive center-block" id="m_photo"
								src="${pageContext.request.contextPath}/resources/upload/${vo.m_photo}">
						</div>
						<table class="table">
							<tr>
								<th class="col-sm-3">Image</th>
								<td class="col-sm-9"><input class="form-control"
									type="file" name="m_photo_file" maxlength="30"
									value="${vo.m_photo }"></td>
								<td><input type="hidden" name="m_idx" value="${vo.m_idx }"></td>
							</tr>
							<tr class="btnBox">
								<td colspan="2"><input id="nut" type="button"
									class="btn btn-info" value="업로드"
									onclick="update_image(this.form);"></td>

							</tr>

						</table>


					</form>
					<form method="post">

						<table class="table">
							<tr>
								<th class="col-sm-3">사용자 ID</th>
								<td class="col-sm-9">
									<div class="col-sm-8">
										<input type="text" name="m_id" id="m_id" value="${vo.m_id }"
											class="form-control" readonly="readonly">
									</div>

								</td>
							</tr>

							<tr>
								<th class="col-sm-3">비밀번호</th>
								<td class="col-sm-9"><input type="password" name="m_pwd"
									value="${vo.m_pwd }" id="m_pwd" class="form-control"></td>
							</tr>

							<tr>
								<th class="col-sm-3">비밀번호 확인</th>
								<td class="col-sm-9"><input type="password" name="c_pwd"
									value="${vo.m_pwd }" id="c_pwd" class="form-control"></td>
							</tr>

							<tr>
								<th class="col-sm-3">이름</th>
								<td class="col-sm-9"><input type="text" name="m_name"
									value="${vo.m_name }" id="m_name" class="form-control"></td>
							</tr>

							<tr>
								<th class="col-sm-3">성별</th>
								<td class="col-sm-9"><label class="radio-inline"> <input
										type="radio" name="m_gender" id="m_man" value="남성">남성
								</label> <label class="radio-inline"> <input type="radio"
										name="m_gender" id="m_woman" value="여성">여성
								</label></td>
							</tr>

							<tr>
								<th class="col-sm-3">전화번호</th>
								<td class="col-sm-9">
									<div class="col-sm-4">
										<select class="form-control" name="m_tel1" id="m_tel1">
											<option value="010" id="m_one">010</option>
											<option value="011" id="m_two">011</option>
										</select>
									</div>

									<div class="col-sm-4">
										<input type="text" name="m_tel2" id="m_tel2"
											class="form-control">
									</div>

									<div class="col-sm-4">
										<input type="text" name="m_tel3" id="m_tel3"
											class="form-control">
									</div>
								</td>
							</tr>

							<tr>
								<th class="col-sm-3">E-Mail</th>
								<td class="col-sm-9"><input class="form-control"
									type="text" name="m_email" maxlength="30"
									value="${vo.m_email }"></td>
							</tr>

							<tr class="btnBox">
								<td colspan="2"><input id="nut" type="button"
									class="btn btn-info" value="수정" onclick="update(this.form);">
									<input id="nut" type="button" class="btn btn-danger" value="탈퇴"
									onclick="del(${vo.m_idx});"></td>

							</tr>
						</table>
						<input type="hidden" name="m_grade" value="일반"> <input
							type="hidden" name="m_idx" value="${vo.m_idx }">
					</form>

				</div>

			</div>

		</div>

		<%@ include file="../etc/scrool.jsp"%>
	</div>

	<footer>
		<%@ include file="../footer/footer.jsp"%>
	</footer>

</body>

</html>