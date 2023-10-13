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
<title></title>
</head>
<body>
	<h1>loginForm.jsp</h1>
	
	<form action="<c:url value ="j_spring_security_check"/>" method="post">
		ID : <input type="text" name="j_username" id="" /> <br>
		PW : <input type="text" name="j_password" id="" /> <br>
		<input type="submit" value="LOGIN" /> <br />
	</form>
</body>
</html>