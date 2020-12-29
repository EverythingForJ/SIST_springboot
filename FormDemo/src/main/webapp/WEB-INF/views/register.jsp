<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원가입</title>
  <link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<h1>회원 가입</h1>
  <form action="/register2" method="POST">
    <ul>
      <li>Name : <input type="text" name="username" id=""></li>
      <li>Age : <input type="number" name="userage" id=""></li>
      <li>Gender : 
        <input type="radio" name="gender" value="남성">남성&nbsp;&nbsp;
        <input type="radio" name="gender" value="여성">여성
      </li>
      <li>Hobby : 
        <input type="checkbox" name="hobby" value="낚시">낚시&nbsp;&nbsp;
        <input type="checkbox" name="hobby" value="등산">등산&nbsp;&nbsp;
        <input type="checkbox" name="hobby" value="독서">독서&nbsp;&nbsp;
        <input type="checkbox" name="hobby" value="게임">게임&nbsp;&nbsp;
        <input type="checkbox" name="hobby" value="영화감상">영화감상&nbsp;&nbsp;
        <input type="checkbox" name="hobby" value="음악감상">음악감상&nbsp;&nbsp;
      </li>
      <li>City : 
        <select name="city">
          <option value="">--선택--</option>
          <option value="서울">서울</option>
          <option value="부산">부산</option>
          <option value="인천">인천</option>
          <option value="울산">울산</option>
          <option value="광주">광주</option>
          <option value="대전">대전</option>
          <option value="대구">대구</option>
        </select>
      </li>
      <li><input type="submit" value="가입하기"></li>
    </ul>
  </form>
</body>
</html>