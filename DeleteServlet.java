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

// TODO : memberResult.jsp에서 이동
// 		 로그인된 사용자 아이디를 가져와서 DB에 회원 정보 삭제
//		 삭제 성공 후에 login.jsp 페이지로 이동

@WebServlet("/delete.do")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static MemberDAOImple dao = null;

	public DeleteServlet() {
		dao = MemberDAOImple.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		String userid = (String) session.getAttribute("userid");
		System.out.println(userid);

		int result = dao.delete(userid);
		if (result == 1) {
			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/login.jsp");

			dispatcher.forward(request, response); // request와 response를 포워딩(전송)

		} else {
			System.out.println("삭제실패");
		}
	}

}
