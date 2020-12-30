<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${code}'s City List</h1>
	<ul>
		<c:forEach items="${citylist}" var="city">
			<li>${city.id}, <a href="/detail?name=${city.name}">${city.name}</a>, ${city.countryCode}, ${city.district}, ${city.population}</li>
		</c:forEach>
	</ul>
</body>
</html>