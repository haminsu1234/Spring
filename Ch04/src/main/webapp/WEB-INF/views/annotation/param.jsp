<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>param 실습</h3>
				<a href="/Ch04/index">index</a>
		<h3>user1 등록</h3>
		<form action="/Ch04/annotation/param1" method="post">
			<input type="text" name="uid"/><br>
			<input type="submit" value="등록하기">
		</form>	
		
		<form action="/Ch04/annotation/param2" method="post">
			<input type="text" name="uid"/><br>
			<input type="text" name="name"/><br>
			<input type="submit" value="등록하기">
		</form>	
		
		<form action="/Ch04/annotation/param3" method="post">
			<input type="text" name="uid"/><br>
			<input type="text" name="name"/><br>
			<input type="text" name="hp"/><br>
			<input type="text" name="age"/><br>
			<input type="submit" value="등록하기">
		</form>	
	</body>
</html>