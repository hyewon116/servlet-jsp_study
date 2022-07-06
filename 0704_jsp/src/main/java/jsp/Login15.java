package jsp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login15")
public class Login15 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Login15DAO dao;
    public Login15() {
        super();
        dao = new Login15DAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("mid");
		String pwd = request.getParameter("mpwd");
		
		int loginYN = 0;
		try {
			loginYN = dao.loginCheck(id, pwd);			
		} catch (SQLException e) {
			e.printStackTrace();
			request.getSession().setAttribute("err_msg", "DBMS 오류. <br><br>잠시 후 다시 시도해주세요.");
			response.sendRedirect("./jsp/10RE_err_page.jsp");
		}
		if(loginYN == 0) {//로그인 실패
			request.getSession().setAttribute("err_msg"
					, "로그인 실패. <br><br>아이디와 패스워드를 확인해주세요.");
			response.sendRedirect("./jsp/10RE_err_page.jsp");
		} else if(loginYN == 1) {//로그인 성공
			request.getSession().setAttribute("login_id", id);
			response.sendRedirect("./jsp/main.jsp");
		}
		
	}//doPost
}
