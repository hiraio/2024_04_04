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
		// TODO : 세션을 이용 "userid님, 환영합니다." 라고 화면에 출력
		String userid = (String)session.getAttribute("userid");
	
		
	%>
	<h2><%=userid %>님, 환영합니다</h2>
	<!--  location.href로 이동하면 servlet에서 doGet()을 호출-
		ㄴ GET방식으로  -->
		<!-- // TODO : 회원 정보 보기 버튼 생성
		// TODO : 로그아웃 버튼 생성 -->
	<button onclick="location.href='select.do'">회원정보</button>
	<button onclick="location.href='logout.do'">로그아웃</button>
	
	<!--  로그인하고 정보를 -->

</body>
</html>