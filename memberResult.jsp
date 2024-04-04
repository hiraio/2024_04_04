<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>회원 정보</h1>
    <p>
        <%-- 회원 정보 출력 --%>
        <%@ page import="edu.web.member.MemberVO" %>
        <%
     		System.out.println("memberResult.jsp로 이동완료 ");
			MemberVO vo = (MemberVO)request.getAttribute("vo");
			System.out.print(vo);
			
        %>
  	    <strong>아이디:</strong> <%= vo.getUserId() %><br>
        <strong>비밀번호:</strong> <%= vo.getPassword() %><br>
        <strong>이메일:</strong> <%= vo.getEmail() %><br>
        <strong>이메일 수신 여부:</strong> <%= vo.getEmailAgree() %><br>
        <strong>관심 분야:</strong> <%= vo.getInterestJoin() %><br>
        <strong>전화번호:</strong> <%= vo.getPhone() %><br>
        <strong>소개:</strong> <%= vo.getIntroduce() %><br> 
    </p>
    <form action="memberUpdate.jsp" method="post">
        <%-- 회원 수정 버튼 --%>
        <input type="submit" value="회원 수정">
    </form>
    <form action="delete.do" method="post">
        <%-- 회원 탈퇴 버튼 --%>
        <input type="submit" value="회원 탈퇴">
    </form>

	<%
		// TODO : 회원 정보 출력
		// TODO : 회원 수정 버튼 생성(경로 memberUpdate.jsp)
		// TODO : 회원 탈퇴 버튼 생성(delete.do)	
	%>

</body>
</html>