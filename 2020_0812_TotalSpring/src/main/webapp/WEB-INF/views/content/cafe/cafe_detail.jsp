<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1c57854d8d14e52fa332a84532ac85cf"></script>
  <!-- 슬라이드 css -->
  <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	 var strArray = '${vo.c_map}'.split(',');
	 
	 
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = {
	        center: new kakao.maps.LatLng(strArray[0], strArray[1]), // 지도의 중심좌표
	        level: 3, // 지도의 확대 레벨
	        mapTypeId : kakao.maps.MapTypeId.ROADMAP // 지도종류
	    }; 

	// 지도를 생성한다 
	var map = new kakao.maps.Map(mapContainer, mapOption); 

	function relayout() {    
	    
	    // 지도를 표시하는 div 크기를 변경한 이후 지도가 정상적으로 표출되지 않을 수도 있습니다
	    // 크기를 변경한 이후에는 반드시  map.relayout 함수를 호출해야 합니다 
	    // window의 resize 이벤트에 의한 크기변경은 map.relayout 함수가 자동으로 호출됩니다
	    map.relayout();
	}
	  
	// 지도에 마커를 생성하고 표시한다
	var marker = new kakao.maps.Marker({
	   position: new kakao.maps.LatLng(strArray[0], strArray[1]), // 마커의 좌표
	   map: map // 마커를 표시할 지도 객체
	});
			
			
			
			

	
});
</script>  


 
<script type="text/javascript">
function send(f){
	
	var r_grade = f.r_grade.value.trim();
	var r_pwd = f.r_pwd.value.trim();
	var r_cot = f.r_cot.value.trim();
//로그인 상태 체크 : session에 MemberVo user를 저장함
	
	//로그인 안되어 있으면
	if('${empty sessionScope.user}'=='true'){
	alert('로그인 하셔야 리뷰작성이 가능합니다.');
	f.r_cot.value ="";
	f.r_pwd.value ="";
	return;
	}
		

	
	
	if(r_cot==""){
		alert('내용을 입력해주세요');
		f.r_cot.value ="";
		f.r_cot.focus();
		return;
	}
	if(r_pwd==""){
		alert('비밀번호를 입력해주세요');
		f.r_pwd.value ="";
		f.r_pwd.focus();
		return;
	}
	if(r_grade==""){
		alert('평점을 선택해주세요');
		return;
	}
		
	
	

f.submit();
}




</script>
 
	
  <title>Document</title>
  
  <style type="text/css">
  	.swiper-container {
      width: 100%;
      height: 350px;
    }

    .swiper-slide {
      text-align: center;
      font-size: 18px;
      background: #fff;

      /* Center slide text vertically */
      display: -webkit-box;
      display: -ms-flexbox;
      display: -webkit-flex;
      display: flex;
      -webkit-box-pack: center;
      -ms-flex-pack: center;
      -webkit-justify-content: center;
      justify-content: center;
      -webkit-box-align: center;
      -ms-flex-align: center;
      -webkit-align-items: center;
      align-items: center;
    }
    
    .swiper-slide img{width: 100%;}
  </style>  
</head>

<body>

    <header>
    	<%@ include file="../header/header.jsp" %>
    </header>

    <div id="content" >
    	<div class="cafe_imgBox swiper-container">
    		<ul class="swiper-wrapper">
    			<li class="swiper-slide">
    				<img alt="cafe 이미지" src="${pageContext.request.contextPath}/resources/upload/${vo.c_photo}">
    			</li>
    			
    		
    		</ul>
    	</div>
    
		<div class="inner">
			<!-- 카페정보 -->
			
			<div class="cafeTitle">
				<h2>${vo.c_name }</h2>
				<p>
					<span class="glyphicon glyphicon-eye-open"></span> 
					<span> 조회수 ${hu.s_num }</span> 
					<span class="glyphicon glyphicon-pencil"></span> 
					<span> 리뷰수 ${vo2.total }</span> 
				</p>
			</div>
			
			<div id="cafeInfo">
				<table class="table" >
		        <tr>
		            <th class="col-sm-2">주소</th>
		            <td class="col-sm-8">${vo.c_addr }
		            </td>
		        </tr>
		
		        <tr>
		            <th class="col-sm-2">전화번호</th>
		            <td class="col-sm-8">${vo.c_tel }</td>
		        </tr>
		
		        
		
		        <tr>
		            <th class="col-sm-2">가격대</th>
		            <td class="col-sm-8">${vo.c_price }</td>
		          </tr>
		  
		          <tr>
		            <th class="col-sm-2">주차</th>
		            <td class="col-sm-8">${vo.c_park } </td>
		          </tr>
		
		          <tr>
		            <th class="col-sm-2">영업시간</th>
		            <td class="col-sm-8">${vo.c_time }</td>
		          </tr>
		  
		          <tr>
		            <th class="col-sm-2">휴일</th>
		            <td class="col-sm-8">${vo.c_hday }</td>
		          </tr>
		          
		          <tr>
		            <th class="col-sm-2">홈페이지</th>
		            <td class="col-sm-8"><a href="${vo.c_uri }">${vo.c_uri }</a></td>
		          </tr>
		          
		        <tr>
		        	<td colspan="2" class="tag">
		        		<ul>
		        		 <c:set var="tel" value="${fn:split(vo.c_tag,',')}" />
		        		<c:forEach var="telnum" items="${tel}" varStatus="g">
		        			<li>
		        				<input type="button" class="btn btn-info" value="${telnum}" onclick="location.href='cafe_tag.do?c_tag=${telnum}&c_i=0'">
		        			</li>
						</c:forEach> 		        			
 
		        		</ul>
		        	</td>
		        </tr> 
		          
		        <tr>
		            <th class="col-sm-2">메뉴</th>
		            <td class="col-sm-8">
		                <ul id="memuList">
		                <c:set var="tel1" value="${fn:split(vo.c_menu1,',')}" />
		                 
		                <li class="menu">
		                        <span class="menuName">${tel1[0]}</span> 
		                        <span class="menuPrice">${tel1[1]}</span>
		                </li>
		                <c:set var="tel2" value="${fn:split(vo.c_menu2,',')}" />
		                <li class="menu">
		                        <span class="menuName">${tel2[0]}</span> 
		                        <span class="menuPrice">${tel2[1]}</span>
		                </li>
		                <c:set var="tel3" value="${fn:split(vo.c_menu3,',')}" />
		                <li class="menu">
		                        <span class="menuName">${tel3[0]}</span> 
		                        <span class="menuPrice">${tel3[1]}</span>
		                </li>
		                <c:set var="tel4" value="${fn:split(vo.c_menu4,',')}" />
		                <li class="menu">
		                        <span class="menuName">${tel4[0]}</span> 
		                        <span class="menuPrice">${tel4[1]}</span>
		                </li>
		                
		                
		                    
		                </ul>
		            </td>
		        </tr>
		        <tr>
		        <th>위치</th>
		        <td><div id="map" style="width:700px;height:400px;"></div></td>
		        </tr>
		    </table>
			</div>
		    
		    <!-- 리뷰 작성 -->
		    <div class="reviewWriter">
	            <form action="../review/review_insert.do" method="get">
	
	                <div class="panel panel-default">
	                    <div class="panel-heading">
	                       <div class="input-group">
	                           <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
	                          <input id="name" type="text" class="form-control" name="r_name" placeholder="이름" value="${sessionScope.user.m_name}" readonly="readonly">
	                       </div>
	                    </div>
	                    <div class="panel-body">
	                        <div class="contentBox">
	                        	<textarea class="form-control reviewContent" rows="5" name="r_cot" style="resize: none"></textarea>
	                        </div>
	                        
	                        <div class="well">
	                            <div class="input-group">
	                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
	                                <input id="r_pwd" type="password" class="form-control" name="r_pwd" placeholder="Password">
	                            </div>
	                            
	                            <div class="input-group">
	                                <span class="input-group-addon">평점</span>
	                                <div class="form-control">
	                                <label class="radio-inline"><input  type="radio" name="r_grade" value="1" >1</label>
    								<label class="radio-inline"><input  type="radio" name="r_grade" value="2" >2</label>
    								<label class="radio-inline"><input  type="radio" name="r_grade" value="3" >3</label>
    								<label class="radio-inline"><input  type="radio" name="r_grade" value="4" >4</label>
    					      		<label class="radio-inline"><input  type="radio" name="r_grade" value="5" >5</label>
    								</div >
	                                
	                            </div>
	                            
	                            <div class="btnBox">
	                            	<div class="btn-group">
		                                <input type="button" class="btn btn-default" onclick="send(this.form);" value="등록">
		                                <input type="button" class="btn btn-default" onclick="" value="취소">
		                            </div>
                            	</div>
	                        </div>
	                    </div>
	                    <input  type="hidden" name="m_idx" value="${sessionScope.user.m_idx }" >
	                    <input  type="hidden" name="c_idx" value="${vo.c_idx }" >
	                </div>
	
	            </form>
	        </div>
		    
		    <!-- 리뷰목록 -->
		    
		    <div class="reviewBox">
		    	<div class="reviewText">
		    		<div class="reviewL">리뷰</div>
		    		
		    		<div class="reviewR">
		    			<ul>
		    			
		    				<li>전체(${vo2.total })</li>
		    				<li>BAD(${vo2.bad})</li>
		    				<li>NOTBAD(${vo2.notbad})</li>
		    				<li>SOSO(${vo2.soso})</li>
		    				<li>LIKES(${vo2.likes})</li>
		    				<li>GOOD(${vo2.god})</li>
	    				</ul>
		    		</div>
		    	</div>
		    	<c:forEach var="review" items="${list }">
		    	<ul class="reviewUser">
		    		<li>
		    			<div class="cafeReview">
						    <div class="userImg">
						      <a href="">
						      	<img src="${pageContext.request.contextPath}/img/cafe/01.jpg">
						      	<span>${review.m_name }</span>
						      </a>
						    </div>
						    <div class="review">
						      <span class="point"><img id="images1" src="${pageContext.request.contextPath}/resources/grade/${review.image}.png"></span>	
						      <span>${review.r_regdate }</span>
						      <p>${review.r_cot }</p>
						    </div>
					  </div>
		    		</li>
	
		    	</ul>
		    </c:forEach>	
		    </div>
		    
		</div>
		
		<%@ include file="../etc/scrool.jsp" %>
	</div>

    <footer>
    	<%@ include file="../footer/footer.jsp" %>
    </footer>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- Swiper JS -->
	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
	<!-- Initialize Swiper -->
	<script>
	    var swiper = new Swiper('.swiper-container', {
	      slidesPerView: 3,
	      loop: true,
	      mousewheel: true,
	      autoplay: {
	          delay: 2500,
	          disableOnInteraction: false,
	        },
	    });
	</script>
 
</body>

</html>