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
                <h2>MyPage</h2>

                <div class="imgBox">
                    <div class="row">
                        <a href="" class="col-sm-3">
                            <img src="${pageContext.request.contextPath}/img/mypage/mypage.jpg" class="img-circle" alt="프로필 이미지">
                        </a>
                        <div class="textBox col-sm-9">
                            <h3>Hello ${user.m_name }</h3>
		
                            <div class="linkBox">
                            	
                 
                                <a href="myadmin_review.do">내가 쓴 글 <span class="badge">${list.size() }</span></a>
                                <a href="#" onclick="location.href='update_form.do?m_idx=${user.m_idx}'">회원정보 수정</a> 
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <div class="bottomMypage">
            <div class="inner">
				
           		<%@ include file="./user_reviewList.jsp" %>
										
            </div>
        </div>
        
        <%@ include file="../etc/scrool.jsp" %>
    </section>

    <footer>
    	<%@ include file="../footer/footer.jsp" %>
    </footer>

</body>

</html>