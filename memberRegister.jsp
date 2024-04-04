<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// TODO : 회원 가입 form 생성. action = "register.do" method ="post"
		System.out.println("memberRegister로 이동완료");
	%>
	 <h2>회원가입 폼</h2>
    <form action="register.do" method="post">
        <label for="userId">사용자 ID:</label>
        <input type="text" id="userid" name="userid"><br><br>

        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password"><br><br>

        <label for="email">이메일:</label>
        <input type="email" id="email" name="email"><br><br>

        <label for="emailAgree">이메일 수신 동의:</label>
        <input type="checkbox" id="emailAgree" name="emailAgree" value="agree"><br><br>

        <label for="interest">관심사:</label><br>
        <input type="checkbox" id="interest1" name="interest" value="영화">영화
        <input type="checkbox" id="interest2" name="interest" value="음악">음악
        <input type="checkbox" id="interest3" name="interest" value="스포츠">스포츠<br><br>

        <label for="phone">전화번호:</label>
        <input type="tel" id="phone" name="phone"><br><br>

        <label for="introduce">자기소개:</label><br>
        <textarea id="introduce" name="introduce" rows="4" cols="50"></textarea><br><br>

        <input type="submit" value="가입하기">
        
     </form>
</body>
</html>









