<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <title>Document</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
   var telID = /^\d{3}-\d{3,4}-\d{4}$/;
   
   var ID = /^[a-z]+[a-z0-9]{3,19}$/g;
   
   var nameID = /^[가-힣]{2,4}|[a-zA-Z]{2,10}\s[a-zA-Z]{2,10}$/;
   
   var pwdID = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
   
   var emailID = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;;
   
   $(document).ready(function(){
			/* 중복체크가 눌리면 */
		$("#confirm").click(function(){
			
			var m_id = $("#m_id").val();
			//ID체크
			if(ID.test(m_id)==false){
				$("#m_id_msg").html('영문자 숫자조합으로 작성하세요');
				$("#m_id").val("");//값비우기
				$("#m_id").focus();//포커스
				return;
			}
			
			//Ajax를 이용한 id 체크
			$.ajax({
				url:'check_id.do' ,//MemberCheckIdAction
				data:{"m_id":m_id},
				dataType:"json", //수신데이터 타입
				success:function(res_data){
					//res_data =={"result": true}
					if(res_data.result==false){
						alert('이미 사용중인 아이디 입니다.');
						return;
					}
					$("#m_id_msg").html('');
					alert('사용가능한 아이디 입니다.');
					
					
					//2.회원가입버튼 활성화
					$("#nut").attr("disabled",false);
					
					
					
				}
			});
		}); //중복체크버튼 클릭 end 
  })
function join(f){
	var m_name = f.m_name.value.trim();
	var m_pwd = f.m_pwd.value.trim();
	var c_pwd = f.c_pwd.value.trim();
	var m_email = f.m_email.value.trim();
	var m_photo_file = f.m_photo_file.value.trim();
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
	f.action = "member_insert.do"
	f.submit();
	
   }
  
  
   
   
  
  
</script>
</head>

<body>

    <header>
    	<%@ include file="../header/header.jsp" %>
    </header>

    <div id="content" >
		<div class="inner">
			<div id="userJoin">
		        <div class="inner-in">
		
		            <div class="titleBox">
		                <h2>회원정보 페이지</h1>
		            </div>
		
		            <div class="profileplace">
		                <img class="img-responsive center-block" id="m_photo" src="${pageContext.request.contextPath}/resources/img/mypage/user.jpg">
		            </div>
		
		            <form method="post" enctype="multipart/form-data">
		
		                <table class="table">
		                    <tr>
		                        <th class="col-sm-3">사용자 ID</th>
		                        <td class="col-sm-9">
		                            <div class="col-sm-8">
		                                <input type="text" name="m_id" id="m_id" class="form-control">
		                                <span id="m_id_msg"></span>
		                            </div>
		                            <input id="confirm" type="button" class="btn btn-success" value="중복검사">
		                        </td>
		                    </tr>
		
		                    <tr>
		                        <th class="col-sm-3">비밀번호</th>
		                        <td class="col-sm-9"><input type="password" name="m_pwd" id="m_pwd" class="form-control"></td>
		                    </tr>
		
		                    <tr>
		                        <th class="col-sm-3">비밀번호 확인</th>
		                        <td class="col-sm-9"><input type="password" name="c_pwd" id="c_pwd" class="form-control"></td>
		                    </tr>
		
		                    <tr>
		                        <th class="col-sm-3">이름</th>
		                        <td class="col-sm-9"><input type="text" name="m_name" id="" class="form-control"></td>
		                    </tr>
		
		                    <tr>
		                        <th class="col-sm-3">성별</th>
		                        <td class="col-sm-9">
		                            <label class="radio-inline">
		                                <input type="radio" name="m_gender" value="남성" checked>남성
		                            </label>
		                            <label class="radio-inline">
		                                <input type="radio" name="m_gender" value="여성">여성
		                            </label>
		                        </td>
		                    </tr>
		
		                    <tr>
		                        <th class="col-sm-3">전화번호</th>
		                        <td class="col-sm-9">
		                            <div class="col-sm-4">
		                                <select class="form-control" name="m_tel1" id="m_phone1">
		                                    <option value="010">010</option>
		                                    <option value="011">011</option>
		                                    <option value="016">016</option>
		                                    <option value="017">017</option>
		                                    <option value="018">018</option>
		                                    <option value="019">019</option>
		                                </select>
		                            </div>
		
		                            <div class="col-sm-4">
		                                <input type="text" name="m_tel2" id="m_phone2" class="form-control">
		                            </div>
		
		                            <div class="col-sm-4">
		                                <input type="text" name="m_tel3" id="m_phone3" class="form-control">
		                            </div>
		                        </td>
		                    </tr>
		
		                    <tr>
		                        <th class="col-sm-3">E-Mail</th>
		                        <td class="col-sm-9"><input class="form-control" type="text" name="m_email" maxlength="30"></td>
		                    </tr>
		
		                    <tr>
		                        <th class="col-sm-3">Image</th>
		                        <td class="col-sm-9"><input class="form-control" type="file" name="m_photo_file" maxlength="30"></td>
		                    </tr>
		
		                    <tr class="btnBox">
		                    	<td colspan="2"><input id="nut" type="button" class="btn btn-info" value="등록" disabled="disabled" onclick="join(this.form);"></td>
		                    </tr>
		                   
		                </table>
		 					<input type="hidden" name="m_grade" value="일반" >
		            </form>
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