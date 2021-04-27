<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

	<!-- 애니메이션 css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/demo.css">

    <title>Document</title>
    
</head>

<body>

    <header>
    	<%-- ${pageContext.request.contextPath} --%>
    	<%@ include file="./content/header/header.jsp" %>
    </header>

    <div id="content" >
		<%@include file="./content/main/slider.jsp" %>
		
		<div class="inner">
			<%@include file="./content/main/categroy.jsp" %>
		</div>
		
		<div class="line"></div>
		
		<div class="inner">
			<%@include file="./content/main/cafeList.jsp" %>
		</div>
		
		<%@ include file="./content/etc/scrool.jsp" %>
	</div>

    <footer>
    	<%@ include file="./content/footer/footer.jsp" %>
    </footer>

<script src="${pageContext.request.contextPath}/resources/js/ScrollTrigger.min.js"></script>
<script>
document.addEventListener('DOMContentLoaded', function(){
  var trigger = new ScrollTrigger({
	  addHeight: true
  });
});
</script>
<!-- masonry js -->
<script src="https://unpkg.com/masonry-layout@4/dist/masonry.pkgd.min.js"></script>
<script type="text/javascript">
      $('.cafeList .list ul').masonry({
          // set itemSelector so .grid-sizer is not used in layout
          itemSelector: '.cafeList .list ul li',
          // use element for option
          columnWidth: '.cafeList .list ul li',
          percentPosition: true
      })
   </script> 

</body>


</html>