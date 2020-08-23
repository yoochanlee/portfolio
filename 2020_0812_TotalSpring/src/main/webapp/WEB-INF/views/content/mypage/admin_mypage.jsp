<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Document</title>
    
</head>

<body>

    <header>
    	<%@ include file="../header/header.jsp" %>
    </header>

    <div class="bgBox">
        <div class="bg"></div>
    </div>

    <section id="content">
        <div class="topMypage jumbotron">
            <div class="inner">
                <h2>AdminPage</h2>

                <div class="imgBox">
                    <div class="row">
                        <a href="" class="col-sm-3">
                            <img src="${pageContext.request.contextPath}/resources/img/mypage/mypage.jpg" class="img-circle" alt="프로필 이미지">
                        </a>
                        <div class="textBox col-sm-9">
                            <h3>Hello 관리자!</h3>

                            <div class="linkBox">
                                <a href="myadmin_review.do">내가 쓴 글 <span class="badge">5</span></a>
                                <a href="update_form.do?m_idx=${user.m_idx}">회원정보 수정</a> 
                                <!-- if -->
                                <a href="../cafe/insert_form.do">카페 등록</a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <div class="bottomMypage">
            <div class="inner">
				
				<%@ include file="./admin_memberList.jsp" %>
				<%@ include file="./admin_reviewList.jsp" %>
           		<%@ include file="./admin_cafeList.jsp" %>
	
            </div>
        </div>
        
        <%@ include file="../etc/scrool.jsp" %>
    </section>

    <footer>
    	<%@ include file="../footer/footer.jsp" %>
    </footer>

</body>

</html>