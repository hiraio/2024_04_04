<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
</head>
<body>
	<%
		// TODO : <a> 태그를 이용하여 memberRegister.jsp 이동 링크 생성
		// TODO : 로그인 form 생성. action="loginAuth.do" method="post"
		System.out.println("login.jsp이동완료 ");
	
	%>
   		<form action="loginAuth.do" method="post">
    	    <label for="userid">사용자 ID:</label>
	        <input type="text" id="userid" name="userid"><br><br>

        	<label for="password">비밀번호:</label>
        	<input type="password" id="password" name="password"><br><br>
        	
        	<input type="submit" value="로그인">
        </form>
   	
   		 <a href="memberRegister.jsp">회원가입 페이지로 이동</a>
    
</body>
</html>
