package jsp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MBDetail18")
public class MBDetail18 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MB18DAO dao; 
    public MBDetail18() {
        super();
        dao = new MB18DAO();
    }//constructor
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(UtilSessionLogin.isLogin( request.getSession() ) == false ) {
			response.sendRedirect(request.getContextPath() + "/jsp/main.jsp");
			return;
		}
		
		String bno = request.getParameter("bno");
		BoardDTO dto = null;
		
			try {
				dto = dao.detail(bno);
			} catch (SQLException e) {
				e.printStackTrace();
				UtilMessage.setSessionMsg(request.getSession()
						, "DBMS 오류 - 회원 게시판 상세 조회 실패" 
						, request.getContextPath() + "/MBList18"
						, "회원 게시판 목록으로 바로가기");
				response.sendRedirect(request.getContextPath() + "/jsp/fail_page.jsp");
				return;
			}
			request.setAttribute("member_board_dto", dto);
			RequestDispatcher disp 
				= request.getRequestDispatcher("./jsp/18mb_detail.jsp");
			disp.forward(request, response);
		
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}//doPost

}
