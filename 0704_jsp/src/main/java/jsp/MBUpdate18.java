package jsp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MBUpdate18")
public class MBUpdate18 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MB18DAO dao;
    public MBUpdate18() {
        super();
        dao = new MB18DAO();
    }//constructor

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//로그인 체크 
		if( UtilSessionLogin.isLogin( request.getSession() ) == false ) {
			response.sendRedirect(request.getContextPath() + "/jsp/main.jsp");
			return;
		}
		
		request.setCharacterEncoding("UTF-8"); 
		
		String loginID = (String) request.getSession().getAttribute("login_id");
		String no = request.getParameter("bno");
		String title = request.getParameter("title");
		String cnts = request.getParameter("cnts");
		
		int successCount = 0;
		
		try {
			successCount = dao.update(no, title, cnts, loginID);
		} catch (SQLException e) {
			e.printStackTrace();
			UtilMessage.setSessionMsg(request.getSession()
					, "DBMS 오류 - 게시글 수정 실패"
					, request.getContextPath() + "/MBList18"
					, "회원 게시판 목록으로 바로가기");
			response.sendRedirect("./jsp/fail_page.jsp");
			return;
		}
		if ( successCount == 0 ) { //업데이트 실패
			UtilMessage.setSessionMsg(request.getSession() 
									, "게시글 수정을 실패하였습니다." 
									, request.getContextPath() + "/MBList18"
									, "회원 게시판 목록으로 바로가기");
			response.sendRedirect(request.getContextPath() + "/jsp/fail_page.jsp");
		} else if ( successCount == 1 ) { //업데이트 성공
			response.sendRedirect("./MBDetail18?&bno=" + no); //수정한 해당 글 확인하기.
		}
	}//doPost
}
