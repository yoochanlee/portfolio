<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- kakao 주소검색 library -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	
<style type="text/css">
#input_box{
	width: 600px;
	margin: auto;
	margin-top: 30px;

}


</style>	
<script type="text/javascript">
//ID정규식
var regular_id = /^[a-zA-Z0-9]{4,8}$/;

/* jQuery 초기화 */
$(document).ready(function(){
	
	//주소검색 클릭
	$("#btn_find_addr").click(function(){
		
		  new daum.Postcode({
			  //테마 바꾸는 법 !!
			  theme:{bgColor:"#E7A23A"},
		        oncomplete: function(data) {
						//data = {'zonecode':12345,'address':'서울시 관악구'...}
						//alert('우편번호:'+data.zonecode);
						//alert('주소:'+data.address);
						
						//값 넣기
						$("#m_zipcode").val(data.zonecode);
						$("#m_addr").val(data.address);
		        }
		    }).open();
		
	});
	
	//회원구분에 따라서 라디오 버튼 체크
	if('${vo.m_grade}' == '일반'){
		$("#radio_member").attr("checked",true);
	}else{
		$("#radio_admin").attr("checked",true);
	}
	
	
	
}); //document.ready = end
function send(f){
	var m_name = f.m_name.value.trim();
	var m_pwd = f.m_pwd.value.trim();
	var m_zipcode = f.m_zipcode.value.trim();
	var m_addr = f.m_addr.value.trim();
	
	if(m_name==''){
		alert('이름을 입력하세요');
		f.m_name.value='';
		f.m_name.focus();
		return;
	}
	if(m_pwd==''){
		alert('비밀번호를 입력하세요');
		f.m_pwd.value='';
		f.m_pwd.focus();
		return;
	}
	if(m_zipcode==''){
		alert('우편번호를 입력하세요');
		f.m_zipcode.value='';
		f.m_zipcode.focus();
		return;
	}
	if(m_addr==''){
		alert('주소를 입력하세요');
		f.m_addr.value='';
		f.m_addr.focus();
		return;
	}
	if(!confirm("정말 수정 하시겠습니까?"))return;
	
	//전송
	f.action="modify.do" //MemberModifyAction
	
	f.submit();
}





</script>


</head>
<body>

	<div id="input_box">
		<div class="panel panel-primary">
			<div class="panel-heading">회원가입</div>
			<div class="panel-body">
				<form>
				<input type="hidden" name="m_idx" value="${vo.m_idx }">
					<table class="table table striped">
						<tr>
						<th>이름</th>
						<td><input name="m_name" value="${vo.m_name}"></td>
						</tr>
						
						<tr>
						<th>아이디</th>
						<td>
						<input name="m_id" value="${vo.m_id}" readonly="readonly">
						</td>
						</tr>
						
						<tr>
						<th>비밀번호</th>
						<td><input type="password" name="m_pwd" value="${vo.m_pwd}"></td>
						</tr>
						
						<tr>
						<th>우편번호</th>
						<td>
						<input name="m_zipcode" id="m_zipcode" value="${vo.m_zipcode}">
						<input type="button" value="주소검색" id="btn_find_addr">
						</td>
						</tr>
						
						<tr>
						<th>주소</th>
						<td><input name="m_addr" id="m_addr" size = "50" value="${vo.m_addr }"></td>
						</tr>
						
						<!-- 수정할때 사용  -->
						<tr>
						<th>회원구분</th>
						<td><input id="radio_member" type="radio" name="m_grade" value="일반" >일반
						<input id="radio_admin" type="radio" name="m_grade" value="관리자">관리자
						</td>
						</tr>
						
						
						<tr>
							<td colspan="2" align="center">
								<input id="btn_register" type="button" value="회원수정" onclick="send(this.form);">	
								<input type="button" value="목록보기" onclick="location.href='list.do'">
							</td>
						
						</tr>
					</table>
				</form>
			</div>
		</div>

	</div>

</body>
</html>