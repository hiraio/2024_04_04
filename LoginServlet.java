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

/*
 *  TODO : login.jsp에서 입력받은 아이디, 패스워드를 DB의 데이터와 비교해서
 *  데이터가 일치하면 - 로그인 세션 생성 및 로그인 성공(loginResult.jsp)로 이동
 *  (아이디 값에 대한 세션 생성. 세션 만료 시간 60초)
 *  데이터가 일치하지 않으면 - login.jsp로 이동 (심심하면 실패 alert 띄우기)
 */

@WebServlet("/loginAuth.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static MemberDAOImple dao;

	public LoginServlet() {
		dao = MemberDAOImple.getInstance();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LognServlet으로 이동완료");
		request.setCharacterEncoding("UTF-8");

		// 파라미터 데이터 받아오기
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");

		int result = dao.checkUser(userid, password);

		if (result == 1) {
			System.out.println("DB에 일치하는 정보 존재");
			HttpSession session = request.getSession(true);
			session.setAttribute("userid", userid);
			session.setMaxInactiveInterval(10); // 60초
			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/loginResult.jsp");

			dispatcher.forward(request, response); // request와 response를 포워딩(전송)

		} else {
			System.out.println("DB에 정보없음");
			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/login.jsp");

			dispatcher.forward(request, response); // request와 response를 포워딩(전송)

		}

	}

}
