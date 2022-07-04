package login.contoller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dao.LoginDAO_RE;
import login.dto.MemberDTO_RE;

@WebServlet("/Login_re")
public class Login_re extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private LoginDAO_RE dao;
	
    public Login_re() {
        super();
        dao = new LoginDAO_RE();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDTO_RE dto = new MemberDTO_RE();
		dto.setMid(request.getParameter("mid"));
		dto.setMpwd(request.getParameter("mpwd"));
		
		int loginYN = 0;
		RequestDispatcher disp = request.getRequestDispatcher("./ErrMsg");
		
		try {
			loginYN = dao.loginCheck(dto);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error_message", "DBMS 오류<br><br>"
					+ "잠시 후 다시 시도해주세요.");
			disp.forward(request, response);
			return;
		}
			if(loginYN == 0) {
			//	request.
			}
		
	}

}
