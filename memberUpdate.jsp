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
		// TODO : 로그인된 사용자 아이디를 저장
		String userid = (String) session.getAttribute("userid");
		System.out.print(userid);
		// TODO : form action ="update.do" method="post" 생성
		// TODO : userid를 제외한 모든 정보 수정 가능하게 input 태그 작성
		//		 userid는 읽기만 가능하도록 input 태그 생성
	%> 
	
	<h1>회원 정보 수정</h1>
    <form action="update.do" method="post">
        <label for="userid">아이디:</label>
        <input type="text" id="userid" name="userid" value="<%=userid %>" readonly><br>

        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password"><br>

        <label for="email">이메일:</label>
        <input type="email" id="email" name="email"><br>

         <label for="emailAgree">이메일 수신 동의:</label>
        <input type="checkbox" id="emailAgree" name="emailAgree" value="agree"><br><br>
		
		<label for="interest">관심사:</label><br>
        <input type="checkbox" id="interest1" name="interest" value="영화">영화
        <input type="checkbox" id="interest2" name="interest" value="음악">음악
        <input type="checkbox" id="interest3" name="interest" value="스포츠">스포츠<br><br>

        <label for="phone">전화번호:</label>
        <input type="text" id="phone" name="phone"><br>

        <label for="introduce">소개:</label>
        <textarea id="introduce" name="introduce"></textarea><br>

        <input type="submit" value="수정 완료">
	
</form>
	
	

</body>
</html>



