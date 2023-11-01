<%@page import = "org.hibernate.SessionFactory" %>
<%@page import = "com.db.HibernateUtil" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Home page </title>
		<%@include file ="com/css.jsp" %>
		<style>
			.image-fit {
			  object-fit: cover;
			  width: 100%;
			  height: 100%;
           }
		</style>
	</head>
	<body>
		<%@include file="com/navbar.jsp"%>
		
		<div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img src="images/image3.jpg" class="d-block image-fit" alt="image 1 unavailable">
		    </div>
		    <div class="carousel-item">
		      <img src="images/image4.jpg" class="d-block image-fit" alt="image 4 unavailable">
		    </div>
		  </div>
		</div>
	</body>
</html>