<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script type="text/javascript">
var telID = /^\d{2,4}-\d{3,4}-\d{4}$/;

$(document).ready(function(){
	
	 if('${vo.c_park}' == '가능'){
			$("#ps").attr("checked",true);
			}else{
			$("#imps").attr("checked",true);
			}
	 
	 
	 if('${vo.c_price}'=='2000'){
		 $("#m_1").attr("selected",true);
	 }else  if('${vo.c_price}'=='4000'){
		 $("#m_2").attr("selected",true);
	 }else  if('${vo.c_price}'=='6000'){
		 $("#m_3").attr("selected",true);
	 }else  if('${vo.c_price}'=='8000'){
		 $("#m_4").attr("selected",true);
	 }else  if('${vo.c_price}'=='10000'){
		 $("#m_5").attr("selected",true);
	 }else {
		 $("#m_6").attr("selected",true);
	 }
	 
	 
 
	
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
	
	
}); //document.ready = end



function enter(f){
	
	var c_name = f.c_name.value;
	//주소
	var	m_zipcode = f.m_zipcode.value;
	var	m_addr = f.m_addr.value;
	//주소끝
	
	
	var c_tel = f.c_tel.value;
	var c_time = f.c_time.value;
	var c_hday = f.c_hday.value;
	var c_menu1 = f.c_menu1.value;
	var c_tag = f.c_tag.value;
	
	var c_map = f.c_map.value;
	
	
	
	
	
	if(c_name==''){
		alert("가게이름을 입력하세요.");
		f.c_name.value='';
		f.c_name.focus();
		return;
	}

	if(m_addr==''){
		alert("주소를 입력하세요.");
		f.m_addr.value='';
		f.m_addr.focus();
		return;
	}
	if(telID.test(c_tel)==false){
		alert("전화번호를 입력하세요.");
		f.c_tel.value='';
		f.c_tel.focus();
		return;
	}

	if(c_time==''){
		alert("영업시간을 입력하세요.");
		f.c_time.value='';
		f.c_time.focus();
		return;
	}
	if(c_hday==''){
		alert("쉬는시간을 입력하세요.");
		f.c_hday.value='';
		f.c_hday.focus();
		return;
	}

	if(c_menu1==''){
		alert("메뉴를 입력하세요.");
		f.c_menu1.value='';
		f.c_menu1.focus();
		return;
	}
	if(c_tag==''){
		alert("태그를 입력하세요.");
		f.c_tag.value='';
		f.c_tag.focus();
		return;
	}
	
	if(c_map==''){
		alert("위도,경도를 입력하세요.");
		f.c_map.value='';
		f.c_map.focus();
		return;
	}
	
	if(!confirm("정말 수정 하시겠습니까?"))return;
	
	f.action="cafe_update.do";
	f.submit();
	
	
	
}


</script>

<script>
     var bUpdate=false;
      $(document).ready( function() {
        $( "#nut" ).click( function() {
          
          bUpdate=!bUpdate;
          $('#nut').val(bUpdate?"이미지올리기":"이미지수정");
          

       
          if(!bUpdate){
        	  
        	  var form = new FormData(document.getElementById('image_form'));
    
        	  $.ajax({
  				url:'image_cafe_update.do',
  				processData: false,
  				contentType: false,
  				type: 'POST',
  				data:form,
  				dataType:"json", //수신데이터 타입
  				success:function(res_data){
  					
  						
  						$("#c_photo").attr("src","${pageContext.request.contextPath}/resources/upload/"+res_data.filename);
  					}
  					//$("#m_id_msg").html('');
  					//alert('사용가능한 아이디 입니다.');
 			   });
        }	  
    
   
        
          
          $( '#hide' ).toggle( 'slow' );
          
        });  
          
          
});
    
</script>
<style type="text/css">
#hide{
display: none;
}
.profileplace img {
width: 100%
}
</style>
</head>
<body>

	<header>
	 	<%@ include file="../header/header.jsp" %>
	</header>
	
	<div id="content" >
		<div class="inner">
			<div class="inner-in formBox">
			    <h3 class="linkBox">카페 수정</h3>
			    
			    <div class="profileplace">
						<img class="img-responsive center-block" id="c_photo"
							src="${pageContext.request.contextPath}/resources/upload/${vo.c_photo}">
							<form id="image_form" method="post" enctype="multipart/form-data">
						<table class="table">
							<tr id="hide">
								<th  class="col-sm-3">Image</th>
								<td  class="col-sm-9"><input  class="form-control"
									type="file" name="c_photo_file" maxlength="30"
									value="${vo.c_photo }"></td>
								<td><input  type="hidden" name="c_idx" value="${vo.c_idx }"></td>
							</tr>
							<tr class="btnBox">
								<td colspan="2">
									<input id="nut" type="button" class="btn btn-info" value="이미지수정" >
									
								</td>

							</tr>

						</table>
					</form>
					</div>
			
			    <form method="post" enctype="multipart/form-data">
			        <table class="table">
			            <tr>
			                <th class="col-sm-1">
			                    <span class="group-addon">@</span>
			                </th>
			                <td class="col-sm-11">
			                    <input type="text" name="c_name" id="c_name" class="form-control" placeholder="가게명" value="${vo.c_name}">
			                </td>
			            </tr>
			
			            <tr>
			                <th class="col-sm-1"><span class="group-addon"><i class="glyphicon glyphicon-map-marker"></i></span></th>
			                <td class="col-sm-11">
			                    <input type="text" name="m_zipcode" id="m_zipcode" class="form-control" placeholder="우편번호" value="${fn:substring(vo.c_addr,0,5) }">
			                    <input type="text" name="m_addr" id="m_addr" class="form-control" placeholder="주소" value="${fn:substring(vo.c_addr,5,-1) }">
			                    <input type="button"  id="btn_find_addr" value="주소검색">
			                    
			                </td>
			            </tr>
			
			            <tr>
			                <th class="col-sm-1"><span class="group-addon"><i class="glyphicon glyphicon-phone-alt"></i></span></th>
			                <td class="col-sm-11">
			                    <input type="text" name="c_tel" id="c_tel" class="form-control" placeholder="전화번호'-'까지입력해주세요" value="${vo.c_tel }">
			                    <input type="hidden" name="c_idx"  value="${vo.c_idx }">
			                </td>
			            </tr>
			
			            <tr>
			                <th class="col-sm-1"><span class="group-addon"><i class="glyphicon glyphicon-credit-card"></i></span></th>
			                <td class="col-sm-11">
			                    <select class="form-control" name="c_price" id="c_price">
			                        <option value="2000" id="m_1">2000원대</option>
			                        <option value="4000" id="m_2">4000원대</option>
			                        <option value="6000" id="m_3">6000원대</option>
			                        <option value="8000" id="m_4">8000원대</option>
			                        <option value="10000" id="m_5">10000원대</option>
			                        <option value="12000" id="m_6">12000원대</option>
			                    </select>
			                </td>
			            </tr>
			
			            <tr>
			                <th class="col-sm-1"><span class="group-addon"><i class="glyphicon glyphicon-road"></i></span></th>
			                <td class="col-sm-11">
			                    <label class="radio-inline">
			                        <input type="radio" name="c_park" id="ps" value="가능" checked>가능
			                    </label>
			                    <label class="radio-inline">
			                        <input type="radio" name="c_park" id="imps" value="불가">불가
			                    </label>
			                </td>
			            </tr>
			
			            <tr>
			                <th class="col-sm-1"><span class="group-addon"><i class="glyphicon glyphicon-time"></i></span></th>
			                <td class="col-sm-11">
			                    <input type="text" name="c_time" id="c_time" class="form-control" placeholder="영업시간" value="${vo.c_time }">
			                </td>
			            </tr>
			            
			            <tr>
			                <th class="col-sm-1"><span class="group-addon"><i class="glyphicon glyphicon-time"></i></span></th>
			                <td class="col-sm-11">
			                    <input type="text" name="c_hday" id="c_hday" class="form-control" placeholder="쉬는시간" value="${vo.c_hday }">
			                </td>
			            </tr>
			
			            <tr>
			                <th class="col-sm-1"><span class="group-addon"><i class="glyphicon glyphicon-globe"></i></span></th>
			                <td class="col-sm-11">
			                    <input type="text" name="c_uri" id="c_uri" class="form-control" placeholder="웹 사이트" value="${vo.c_uri }">
			                </td>
			            </tr>
			
			            <tr>
			                <th rowspan="4" class="col-sm-1 rowspan">
			                    <span class="group-addon"><i class="glyphicon glyphicon-glass"></i></span>
			                </th>
			                <td class="col-sm-11"><input type="text" name="c_menu1" class="form-control" placeholder="메뉴 및 가격" value="${vo.c_menu1}"></td>
			            </tr>
			            <tr>
			                <td class="col-sm-11"><input type="text" name="c_menu2" class="form-control" placeholder="메뉴 및 가격" value="${vo.c_menu2 }"></td>
			            </tr>
			            <tr>
			                <td class="col-sm-11"><input type="text" name="c_menu3" class="form-control" placeholder="메뉴 및 가격" value="${vo.c_menu3 }"></td>
			            </tr>
			            <tr>
			                <td class="col-sm-11"><input type="text" name="c_menu4" class="form-control" placeholder="메뉴 및 가격" value="${vo.c_menu4 }"></td>
			            </tr>
			            
			            <tr>
			                <th class="col-sm-1"><span class="group-addon">#</span></th>
			                <td class="col-sm-11">
			                    <input type="text" name="c_tag" id="c_tag" class="form-control" placeholder="태그" value="${vo.c_tag }">
			                </td>
			            </tr>
			
			            
			
			            <tr>
			                <th class="col-sm-1"><span class="group-addon"><i class="glyphicon glyphicon-globe"></i></span></th>
			                <td class="col-sm-11">
			                    <input type="text" name="c_map" id="c_map" class="form-control" placeholder="위도,경도" value="${vo.c_map }">
			                </td>
			            </tr>
			        </table>
			
			        <div class="a-btn">
			            <div class="btn-group">
			                <input type="button" class="btn" value="수정" onclick="enter(this.form);">
			                <!-- /admin_mypage.jsp?admin=cafe -->
			                <input type="button" class="btn" value="목록" onclick="location.href='../member/member_adminpage_form.do';">
			            </div>
			        </div>
			    </form>
			</div>
		</div>
		
		<%@ include file="../etc/scrool.jsp" %>
	</div>
	
	<footer>
		<%@ include file="../footer/footer.jsp" %>
	</footer>

</body>
</html>