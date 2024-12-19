<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Add Employee...</h2>
	<form action="">
		<pre>
Name :<input type="text" name="name" />
Email:<input type="text" name="email" />
Mobile:<input type="text" name="mobile" />
<input type="submit" value="save" />
</pre>

	</form>
	${msg}
	
	<%-- <c:set var="x" value="100"></c:set>
	
	<c:out value="${x}"></c:out>  --%>
	
	<%-- <c:forEach var="i" begin = "1" end = "5">
	item <c:out value="${i}"></c:out> </p>
	</c:forEach> --%>
	
	<%-- <c:set var="salary" value="${2000*2}"></c:set>
	<c:if test="${salary > 2000}">
	<p>My salary is: <c:out value = "${salary}" /><p> 
	</c:if> --%>
	
</body>
</html>