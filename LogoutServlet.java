package edu.web.member;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO : 로그인된 사용자만 접근 가능. 로그아웃을 하려면 로그인된 사용자여야함
// userid 세션을 제거하고, login.jsp로 이동 

@WebServlet("/logout.do")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogoutServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		System.out.println("logout.do로 이동완료");
		HttpSession session = request.getSession(true);
		session.invalidate();
		if (request.isRequestedSessionIdValid()) {
			System.out.println("유요한 세션");
		} else {
			System.out.println("유요하지않은 세션");
		}
		
		 ServletContext context = getServletContext();
		 RequestDispatcher dispatcher = context.getRequestDispatcher("/login.jsp");
		 dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
