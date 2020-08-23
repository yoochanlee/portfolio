<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
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
	var c_photo_file = f.c_photo_file.value;
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
	if(c_photo_file==''){
		alert("사진을 등록하세요.");
		return;
	}
	if(c_map==''){
		alert("위도,경도를 입력하세요.");
		f.c_map.value='';
		f.c_map.focus();
		return;
	}
	
	f.action="cafe_insert.do";
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
			<div class="inner-in formBox">
			    <h3 class="linkBox">카페 등록</h3>
			
			    <form method="post" enctype="multipart/form-data">
			        <table class="table">
			            <tr>
			                <th class="col-sm-1">
			                    <span class="group-addon">@</span>
			                </th>
			                <td class="col-sm-11">
			                    <input type="text" name="c_name" id="c_name" class="form-control" placeholder="가게명">
			                </td>
			            </tr>
			
			            <tr>
			                <th class="col-sm-1"><span class="group-addon"><i class="glyphicon glyphicon-map-marker"></i></span></th>
			                <td class="col-sm-11">
			                    <input type="text" name="m_zipcode" id="m_zipcode" class="form-control" placeholder="우편번호">
			                    <input type="text" name="m_addr" id="m_addr" class="form-control" placeholder="주소">
			                    <input type="button"  id="btn_find_addr" value="주소검색">
			                    
			                </td>
			            </tr>
			
			            <tr>
			                <th class="col-sm-1"><span class="group-addon"><i class="glyphicon glyphicon-phone-alt"></i></span></th>
			                <td class="col-sm-11">
			                    <input type="text" name="c_tel" id="c_tel" class="form-control" placeholder="전화번호'-'까지입력해주세요">
			                </td>
			            </tr>
			
			            <tr>
			                <th class="col-sm-1"><span class="group-addon"><i class="glyphicon glyphicon-credit-card"></i></span></th>
			                <td class="col-sm-11">
			                    <select class="form-control" name="c_price" id="c_price">
			                        <option value="2000">2000원대</option>
			                        <option value="4000">4000원대</option>
			                        <option value="6000">6000원대</option>
			                        <option value="8000">8000원대</option>
			                        <option value="10000">10000원대</option>
			                        <option value="12000">12000원대</option>
			                    </select>
			                </td>
			            </tr>
			
			            <tr>
			                <th class="col-sm-1"><span class="group-addon"><i class="glyphicon glyphicon-road"></i></span></th>
			                <td class="col-sm-11">
			                    <label class="radio-inline">
			                        <input type="radio" name="c_park" value="가능" checked>가능
			                    </label>
			                    <label class="radio-inline">
			                        <input type="radio" name="c_park" value="불가">불가
			                    </label>
			                </td>
			            </tr>
			
			            <tr>
			                <th class="col-sm-1"><span class="group-addon"><i class="glyphicon glyphicon-time"></i></span></th>
			                <td class="col-sm-11">
			                    <input type="text" name="c_time" id="c_time" class="form-control" placeholder="영업시간">
			                </td>
			            </tr>
			            
			            <tr>
			                <th class="col-sm-1"><span class="group-addon"><i class="glyphicon glyphicon-time"></i></span></th>
			                <td class="col-sm-11">
			                    <input type="text" name="c_hday" id="c_hday" class="form-control" placeholder="종료시간">
			                </td>
			            </tr>
			
			            <tr>
			                <th class="col-sm-1"><span class="group-addon"><i class="glyphicon glyphicon-globe"></i></span></th>
			                <td class="col-sm-11">
			                    <input type="text" name="c_uri" id="c_uri" class="form-control" placeholder="웹 사이트">
			                </td>
			            </tr>
			
			            <tr>
			                <th rowspan="4" class="col-sm-1 rowspan">
			                    <span class="group-addon"><i class="glyphicon glyphicon-glass"></i></span>
			                </th>
			                <td class="col-sm-11"><input type="text" name="c_menu1" class="form-control" placeholder="메뉴 및 가격"></td>
			            </tr>
			            <tr>
			                <td class="col-sm-11"><input type="text" name="c_menu2" class="form-control" placeholder="메뉴 및 가격"></td>
			            </tr>
			            <tr>
			                <td class="col-sm-11"><input type="text" name="c_menu3" class="form-control" placeholder="메뉴 및 가격"></td>
			            </tr>
			            <tr>
			                <td class="col-sm-11"><input type="text" name="c_menu4" class="form-control" placeholder="메뉴 및 가격"></td>
			            </tr>
			            
			            <tr>
			                <th class="col-sm-1"><span class="group-addon">#</span></th>
			                <td class="col-sm-11">
			                    <input type="text" name="c_tag" id="c_tag" class="form-control" placeholder="태그">
			                </td>
			            </tr>
			
			            <tr>
			                <th class="col-sm-1"><span class="group-addon"><i class="glyphicon glyphicon-duplicate"></i></span></th>
			                <td class="col-sm-11">
			                    <input type="file" name="c_photo_file" class="form-control">
			                </td>
			            </tr>
			
			            <tr>
			                <th class="col-sm-1"><span class="group-addon"><i class="glyphicon glyphicon-globe"></i></span></th>
			                <td class="col-sm-11">
			                    <input type="text" name="c_map" id="c_map" class="form-control" placeholder="위도,경도">
			                </td>
			            </tr>
			        </table>
			
			        <div class="a-btn">
			            <div class="btn-group">
			                <input type="button" class="btn" value="등록" onclick="enter(this.form);">
			                <!-- /admin_mypage.jsp?admin=cafe -->
			                <input type="button" class="btn" value="목록" onclick="location.href='../member_adminpage_form.do';">
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