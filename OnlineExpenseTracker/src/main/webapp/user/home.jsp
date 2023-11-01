<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../com/css.jsp"%>
</head>
<body>
<c:if test="${empty loginUser }">
	<c:redirect url="../login.jsp"></c:redirect>
</c:if>
	<%@include file="../com/navbar.jsp"%>
	<div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img src="../images/image3.jpg" class="d-block image-fit" alt="image 1 unavailable">
		    </div>
		    <div class="carousel-item">
		      <img src="../images/image4.jpg" class="d-block image-fit" alt="image 4 unavailable">
		    </div>
		  </div>
		</div>
</body>
</html>