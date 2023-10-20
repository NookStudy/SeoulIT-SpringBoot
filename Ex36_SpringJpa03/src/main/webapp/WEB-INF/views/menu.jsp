<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%-- core 라이브러리 적용 --%>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- jQuery 3.7.0 적용 -->
<script  src="https://code.jquery.com/jquery-3.7.0.js"
  	integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" 
  	crossorigin="anonymous"></script>
<!-- BootStrap 5.3.1  및 4.6.2 적용 -->
<script 
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" 
	crossorigin="anonymous"></script>
<script 
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" 
	crossorigin="anonymous"></script>
<link rel="stylesheet" 
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" 
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" 
	crossorigin="anonymous">
<link 
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" 
	crossorigin="anonymous">
<title></title>
</head>
<body>
	<h1>Spring JPA #03</h1>
	
	<a href="/selectByNameLike?name=test&page=1">Name Like 조회 : 1페이지</a> <br />
	<a href="/selectByNameLike?name=test&page=2">Name Like 조회 : 2페이지</a> <br />
	<a href="/selectByNameLike?name=test&page=3">Name Like 조회 : 3페이지</a> <br />
<!-- 	<br /> -->
<!-- 	<p> -->
<!-- 		<a href="/insert">데이터 추가</a> <br /> -->
<!-- 		<a href="/selectById?id=1">개별 조회-ByID</a> -->
<!-- 		<a href="/selectAll">전체 조회</a> -->
<!-- 		<hr /> -->
<!-- 		<a href="/selectByName?name=을지문덕">개별 조회 - byName</a><br /> -->
<!-- 		<a href="/selectByEmail?email=test7@test.com">개별 조회 - byEmail</a><br /> -->
<!-- 		<a href="/selectByNameLike?name=김">리스트조회 - NameLike</a><br /> -->
<!-- 		<a href="/selectByNameLikeNameDesc?name=김">리스트 조회 - Name Like Name Desc</a><br /> -->
<!-- 		<hr /> -->
<!-- 		<a href="/delete?id=2">데이터 삭제</a> -->
<!-- 		<a href="/update?id=1&username=홍길동">데이터 수정</a> -->
		
	
	</p>
	<img src="<c:url value="banner.jpg"></c:url>" alt="" />
	<c:url value="banner.jpg"></c:url>
	${pageContext.request.contextPath }
</body>
</html>