package edu.web.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





// TODO : memberRegister.jsp에서 전송된 데이터를 DB에 저장
// DB 저장 후에 login.jsp로 이동(심심하면 alert도 띄우기)

@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	private static MemberDAOImple dao;
	   
    public RegisterServlet() {
    	dao = MemberDAOImple.getInstance();
    	
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				// sendRedirect() : 특정 경로로 이동
				// request는 소멸되기 때문에 데이터를 전송할 수 없음
			
				/*
				 * // request attribute 방식으로 객체 데이터 전송 request.setAttribute("board", board);
				 * 
				 * // ServletContext : 애플리케이션 정보 제공 ServletContext context =
				 * getServletContext(); // ServletContext 객체를 참조
				 * 
				 * // RequestDispatcher : 클라이언트로부터 발생된 요청을 다른 경로의 // 리소스(Servlet or jsp)로 전송하는
				 * 역할
				 * 
				 * RequestDispatcher dispatcher =
				 * context.getRequestDispatcher("/ch15/board/detail.jsp");
				 * 
				 * dispatcher.forward(request, response); // request와 response를 포워딩(전송)
				 */
				// 활용
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("RegisterSevlet 로 이동완료");
		request.setCharacterEncoding("UTF-8");

	    // 파라미터 데이터 받아오기
	    String userid = request.getParameter("userid");
	    String password = request.getParameter("password");
	    String email = request.getParameter("email");
	    String emailAgree = request.getParameter("emailAgree");
	    String[] interest = request.getParameterValues("interest");
	    String phone = request.getParameter("phone");
	    String introduce = request.getParameter("introduce");

	    // MemberVO 객체 생성 후 데이터 설정
	    MemberVO member = new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);	
	    int result = dao.insert(member);
	    
	    System.out.println(result);
	    
	     ServletContext context = getServletContext();
	     RequestDispatcher dispatcher =
				  context.getRequestDispatcher("/login.jsp");
				  
				  dispatcher.forward(request, response); // request와 response를 포워딩(전송)
	    
		
	}

}
