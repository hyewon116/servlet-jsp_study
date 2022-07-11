package jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MBDelete18")
public class MBDelete18 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MB18DAO dao;
	public MBDelete18() {
        super();
        dao = new MB18DAO();
    }//constructor

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if( UtilSessionLogin.isLogin( request.getSession() ) == false ) {
			response.sendRedirect(request.getContextPath() + "/jsp/main.jsp");
			return;
		}

		String loginID = (String) request.getSession().getAttribute("login_id");
		String bno = request.getParameter("bno");
		int successCount = 0;
		
			try {
				successCount = dao.delete(bno, loginID);
			} catch (SQLException e) {
				e.printStackTrace();
				UtilMessage.setSessionMsg(request.getSession()
						, "DBMS 오류 - 게시글 삭제 실패"
						, request.getContextPath() + "/MBList18"
						, "회원 게시판 목록으로 바로가기");
			response.sendRedirect(request.getContextPath() + "/jsp/fail_page.jsp");
			return;
			}
			if ( successCount == 0 ) {
				UtilMessage.setSessionMsg(request.getSession()
										, "게시글 삭제에 실패하였습니다."
										, request.getContextPath() + "/MBList18"
										, "회원 게시판 목록으로 바로가기");
				response.sendRedirect(request.getContextPath() + "/jsp/fail_page.jsp");
			} else if ( successCount == 1 ){
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				
				out.println("<script>alert("+request.getParameter("bno")+"+'번 글이 삭제되었습니다.');location.href='./MBList18';</script>");  
				out.flush();
			}
		
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}//doPost

}
