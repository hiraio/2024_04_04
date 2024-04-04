package edu.web.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO : loginResult.jsp에서 이동
// 로그인된 사용자의 정보를 DB에서 select
// select된 MemberVO 데이터를 memberResult.jsp로 전송



@WebServlet("/select.do")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static MemberDAOImple dao;
	   
    
    public SelectServlet() {
       dao = MemberDAOImple.getInstance();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		
		System.out.println("SelectServlet 이동완료");
		 HttpSession session = request.getSession();
		 String userid = (String) session.getAttribute("userid");
		 System.out.println(userid);
		 MemberVO vo =  dao.select(userid);
		 request.setAttribute("vo", vo);
		 
		 ServletContext context = getServletContext();
		 RequestDispatcher dispatcher = context.getRequestDispatcher("/memberResult.jsp");
		 dispatcher.forward(request, response);
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
	}

}
