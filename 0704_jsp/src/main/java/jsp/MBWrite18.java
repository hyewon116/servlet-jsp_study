package jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MBWrite18")
public class MBWrite18 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public MBWrite18() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response); //실수로 get방식으로 들어오더라도 무조건 post로 실행되도록.
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//로그인 검사 start!!!
		HttpSession session = request.getSession(); //1. 세션 받아오기 
		String loginID = (String) session.getAttribute("login_id"); //2. Login15.java 파일에서 "login_id" 설정한 아이디 정보 받아옴
		if(loginID == null || loginID.trim().length() == 0 ) {
			response.sendRedirect(request.getContextPath() + "/jsp/main.jsp"); //로그인 정보가 없다면 메인으로 보내라!!
			return; //반드시 리턴 수행!!
		}
		//로그인 검사 end!!!
		
		String title = request.getParameter("title");
		String cnts = request.getParameter("cnts");
		int successCount = 0;
		//successCount = dao.write(title, cnts, loginID);
		if( successCount == 1 ) {//글쓰기 DBMS insert 성공
			
			
		} else {//글쓰기 DBMS insert 실패
			
		}
		
	}//doPost

}
