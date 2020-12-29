<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원가입</title>
  <link rel="stylesheet" href="css/style.css" />
  <script src="js/jquery-3.5.1.min.js"></script>
  <script>
	$(function(){
		$('#btnSubmit').on('click', function(){
			let hobby = '';
			$('.hobby:checked').each(function(){
				hobby += $(this).val() + ",";
			});
			hobby = hobby.substring(0, hobby.length - 1);
			
			let str = '/register3/' + $('#username').val() + '/' + $('#userage').val();
			str += '/' + $('.gender:checked').val() + '/' + hobby + '/' + $('#city').val();
			$.ajax({
				url : str
			}); 
		});
	});
  </script>
</head>
<body>
	<h1>회원 가입</h1>
  <!-- <form action="/register3" method="POST"> -->
    <div>
    <ul>
      <li>Name : <input type="text" name="username" id="username"></li>
      <li>Age : <input type="number" name="userage" id="userage"></li>
      <li>Gender : 
        <input type="radio" name="gender" value="남성" class="gender">남성&nbsp;&nbsp;
        <input type="radio" name="gender" value="여성" class="gender">여성
      </li>
      <li>Hobby : 
        <input type="checkbox" name="hobby" value="낚시" class='hobby'>낚시&nbsp;&nbsp;
        <input type="checkbox" name="hobby" value="등산" class='hobby'>등산&nbsp;&nbsp;
        <input type="checkbox" name="hobby" value="독서" class='hobby'>독서&nbsp;&nbsp;
        <input type="checkbox" name="hobby" value="게임" class='hobby'>게임&nbsp;&nbsp;
        <input type="checkbox" name="hobby" value="영화감상" class='hobby'>영화감상&nbsp;&nbsp;
        <input type="checkbox" name="hobby" value="음악감상" class='hobby'>음악감상&nbsp;&nbsp;
      </li>
      <li>City : 
        <select name="city" id='city'>
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
      <li><input type="button" value="가입하기" id="btnSubmit"></li>
    </ul>
    </div>
  <!-- </form> -->
</body>
</html>