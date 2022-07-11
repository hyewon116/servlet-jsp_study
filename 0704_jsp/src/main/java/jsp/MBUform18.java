package jsp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MBUform18")
public class MBUform18 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MB18DAO dao;
	
    public MBUform18() {
        super();
        dao = new MB18DAO();
    }//constructor

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if( UtilSessionLogin.isLogin( request.getSession() ) == false ) {
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
									, "DBMS 오류"
									, request.getContextPath() + "/MBList18"
									, "회원 게시판 목록으로 바로가기");
				response.sendRedirect(request.getContextPath() + "/jsp/fail_page.jsp");
				return;
			}
			
			String loginID = (String) request.getSession().getAttribute("login_id"); //로그인 정보 불러오기
			if( loginID.equals(dto.getMid()) == true ) { //true 안 써도 됨. 헷갈리지 말라고 씀.
				request.setAttribute("member_board_dto", dto);
				RequestDispatcher disp = request.getRequestDispatcher("/jsp/18mb_update.jsp");
				disp.forward(request, response);				
			} else {
				UtilMessage.setSessionMsg(request.getSession()
									, "수정하실 수 없는 게시글입니다."
									, request.getContextPath() + "/MBList18"
									, "회원 게시판 목록으로 바로가기");
				response.sendRedirect(request.getContextPath() + "/jsp/fail_page.jsp");
				return;
			}
			
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}//doPost

}
