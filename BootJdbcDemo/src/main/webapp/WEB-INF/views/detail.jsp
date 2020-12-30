<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${cityname.name}'s Information</h1>
	<ul>
		<li>ID : ${cityname.id}</li>
		<li>Name : ${cityname.name}</li>
		<li>Country Code : ${cityname.countryCode}</li>
		<li>District : ${cityname.district}</li>
		<li> Population : ${cityname.population}</li>
	</ul>	
</body>
</html>