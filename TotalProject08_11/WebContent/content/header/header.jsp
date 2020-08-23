<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

	<title>Document</title>

	<!-- reset.css -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@4.0.1/reset.min.css" />
	<!-- normalize.css -->
	<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" />
	
	<!-- bootstrap  -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

	<!-- font  -->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;400;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;400;700&display=swap" rel="stylesheet">
	
	<!-- css  -->
	<%-- ${pageContext.request.contextPath} --%>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/basic.css">
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/cafe.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mypage.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/userJoin.css">
    
    <style>
        
    </style>
    
	<script type="text/javascript">
		//header 스크롤
	    $(window).scroll(function() {
	        if ($(this).scrollTop() > 1){
	            $('header').addClass("fixed");
	        }
	        else{
	            $('header').removeClass("fixed");
	        }
	    });
	</script>    
	<script type="text/javascript">
	function login(f){
		//사용자가 입력한 비밀번호
	var m_pwd = f.m_pwd.value.trim();
	var m_id = f.m_id.value.trim();
	
	if(m_id==''){
		alert("이메일을 입력하세요.");
		f.m_id.value='';
		f.m_id.focus();
		return;
	}

	if(m_pwd==''){
		alert("비밀번호를 입력하세요.");
		f.m_pwd.value='';
		f.m_pwd.focus();
		return;
	}
	
	$.ajax({
		url:"${ pageContext.request.contextPath }/login.do",//MemberLoginAction
		data:{"m_id":m_id,"m_pwd":m_pwd},
		dataType: "json",//결과
		success:function(res_data){
			// res_data={"result":"success"}
			// res_data={"result":"fail_id"}
			// res_data={"result":"fail_pwd"}
			//alert(res_data.result);
			if(res_data.result=='fail_id'){
				alert('아이디가 존재하지 않습니다.');
				return;
			}
			if(res_data.result=='fail_pwd'){
				alert('비밀번호가 틀립니다.');
				return;
			}
			
			//로그인 성공: 메인페이지로 이동
			location.href=document.location.href;
			
		}
			
	});

}

	</script>

</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<div id="logo">
					<a class="navbar-brand" href="${ pageContext.request.contextPath }/list.do">CAFE's</a>
				</div>
			</div>
				
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${empty user }">
				
				<li><a href="#" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-log-in"></span>로그인</a></li>
				</c:if>
				<!-- 로그아웃 if문  -->
				<c:if test="${ user.m_grade eq '일반' }">
				<li><a>${user.m_name }님 환영합니다</a></li>
				<li><a href="${ pageContext.request.contextPath }/mypage_list.do"><span class="glyphicon glyphicon-user"></span> 마이페이지 </a></li>
				<li><a href="${ pageContext.request.contextPath }/logout.do"><span class="glyphicon glyphicon-log-out"></span>로그아웃</a></li>
				
				</c:if>
				<c:if test="${user.m_grade eq '관리자' }">
				<li><a>${user.m_name }님 환영합니다</a></li>
				<li><a href="${ pageContext.request.contextPath }/mypage_list.do"><span class="glyphicon glyphicon-user"></span> 관리자페이지 </a></li>
				<li><a href="${ pageContext.request.contextPath }/logout.do"><span class="glyphicon glyphicon-log-out"></span>로그아웃</a></li>
				
				</c:if>
			</ul>
		</div>  	  
	</nav>

	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">로그인</h4>
					<h5 class="modal-title">
						가고싶은 카페를 검색해봐요
					</h5>
				</div>

				<form class="form-horizontal" action="">

					<div id="form-group">
						<div class="form-group">
							<label class="control-label col-sm-3" for="email">Email:</label>
							<div class="col-sm-9">
								<input type="email" class="form-control" id="email" placeholder="Enter email" name="m_id">
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-3" for="pwd">Password:</label>
							<div class="col-sm-9">
								<input type="password" class="form-control" id="pwd" placeholder="Enter password" name="m_pwd">
							</div>
						</div>
					</div>
		
					<div id="modal-button">
						<div class="text-center">
							<input type="button" class="btn btn-default" data-dismiss="modal" value="회원가입" onclick="location.href='${ pageContext.request.contextPath }/insert_form.do'">
							<input type="button" class="btn btn-default" value="로그인" onclick="login(this.form);">
						</div>
					</div>
						
				</form>
			</div>

		</div>
	</div>

</body>
</html>