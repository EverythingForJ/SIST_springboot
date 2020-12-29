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
	<h2>회원 정보</h2>
	<ul>
		<li>이름 : ${user.username}</li>
		<li>나이 : ${user.userage}</li>
		<li>성별 : ${user.gender}</li>
		<li>취미 : 
			<c:forEach var="item" items="${user.hobby}">
				<c:out value="${item}" />,
			</c:forEach>
		</li>
		<li>거주지 : ${user.city}</li>
	</ul>
</body>
</html>