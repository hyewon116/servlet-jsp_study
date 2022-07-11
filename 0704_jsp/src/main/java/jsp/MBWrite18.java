package jsp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MBWrite18")
public class MBWrite18 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MB18DAO dao;
    public MBWrite18() {
        super();
        dao = new MB18DAO();
    }//constructor

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//로그인 검사 start!!!
		if( UtilSessionLogin.isLogin( request.getSession() ) == false ) {
			response.sendRedirect( request.getContextPath() + "/jsp/main.jsp" );
			return;
		}
		//로그인 검사 end!!!
		String title = request.getParameter("title");
		String cnts = request.getParameter("cnts");
		String loginId = (String) request.getSession().getAttribute("login_id");
		int successCount = 0;
		try {
			successCount = dao.write(title, cnts, loginId);
		} catch( SQLException e ) {
			e.printStackTrace();
			UtilMessage.setSessionMsg(request.getSession(), "DBMS 오류"
					, request.getContextPath() + "/MBList18", "회원 게시판 목록으로 바로가기");
			response.sendRedirect(request.getContextPath() + "/jsp/fail_page.jsp");
			return;
		}
		if( successCount == 1 ) {//글쓰기 DBMS insert 성공
			response.sendRedirect("./MBList18");
		} else {//글쓰기 DBMS insert 실패
			UtilMessage.setSessionMsg(request.getSession(), "회원 게시판 쓰기 실패"
					, request.getContextPath() + "/MBList18", "회원 게시판 목록으로 바로가기");
			response.sendRedirect(request.getContextPath() + "/jsp/fail_page.jsp");
		}
	}//doPost

}//class