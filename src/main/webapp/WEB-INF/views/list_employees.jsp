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
<table>
<tr>
<th>Name</th>
<th>Email</th>
<th>Mobile</th>
</tr>

<c:forEach items="${employees}" var="emp">
<tr>
<td>${emp.name}</td>
<td>${emp.email}</td>
<td>${emp.mobile}</td>
<td><a href="delete?id=${emp.id}">delete</a></td>
<td><a href="update?id=${emp.id}">update</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>