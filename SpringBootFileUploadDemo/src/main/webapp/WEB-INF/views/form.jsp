<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>file 업로드 예제</h1>
	<form method="post" action="upload" enctype="multipart/form-data">
		<p><label>email:</label> <input type="text" name="email"></p>
		<p><br> <label>file:</label> <input type="file" name="file1"></p>
		<p><input type="submit" value="upload"></p>
	</form>
</body>
</html>