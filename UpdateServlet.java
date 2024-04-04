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


// TODO : memberUpdate.jsp에서 전송된 데이터로 DB 회원 정보 수정
//		  회원 정보 수정에 성공하면 memberResult.jsp에 MemberVO 데이터 전송하여 출력

@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static MemberDAOImple dao = null;
	   
    
    public UpdateServlet() {
       dao = MemberDAOImple.getInstance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("update.do 이동완료");
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		System.out.println(userid);
		String password = request.getParameter("userid");
		String email = request.getParameter("password");
		String emailAgree = request.getParameter("emailAgree");
		String[] interest = request.getParameterValues("interest");
		String phone = request.getParameter("phone");
		String introduce = request.getParameter("introduce");
		
		MemberVO vo = new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);
		
		 dao.update(userid, vo);
		
		request.setAttribute("vo",vo);
		 
		 ServletContext context = getServletContext();
		 RequestDispatcher dispatcher = context.getRequestDispatcher("/memberResult.jsp");
		 dispatcher.forward(request, response);
		
	}

}
