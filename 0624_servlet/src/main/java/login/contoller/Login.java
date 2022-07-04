package login.contoller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.dao.LoginDAO;
import login.dto.MemberDTO;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginDAO dao; //2. import 해주기 + private 달기
     
    public Login() {
        super();
        dao = new LoginDAO(); //2-1
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO dto = new MemberDTO(); //1.dto 파일 호출 (클라이언트가 보낸 정보 받기 - dto 파일 이용)
		dto.setMid(request.getParameter("mid")); //1-1. => 클라이언트가 보낸 아이디와 패스워드 정보 dto에 담기
		dto.setMpwd(request.getParameter("mpwd")); 
		
		int loginYN = 0;
		RequestDispatcher disp = request.getRequestDispatcher("./ErrMsg");//ErrMsg라는 서블릿에게 넘기기 16. ErrMsg 서블릿 만들기
		//RequestDispatcher.forward : 다른 서블릿에게 프로그램의 흐름을 넘기는 표현
		
		try {
			loginYN = dao.loginCheck(dto); //3. id/pwd가 등록된 dto를 dao에 넘겨주고, 체크된 정보를 받겠다. 
											//-> id,pwd가 모두 올바르면 loginYN은 1이 된다.
											// 3-1. dao의 loginCheck 메소드 만들러 고!
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error_message", "DBMS 오류<br><br>" 
					+ "잠시 후 다시 시도해주세요."); //16. 
			disp.forward(request, response);
			return;
		}
		
		//15.loginYN 정보에 따른 메시지 만들기
		if(loginYN == 0) {//login 불가능
			request.setAttribute("error_message", "로그인 실패<br><br>"
					+ "아이디 또는 패스워드를 확인하세요."); //setAttribute("name","value")
			disp.forward(request, response);
		} else if (loginYN == 1) {//login 가능
			//로그인 성공 표시를 HttpSession에 남긴다.
			HttpSession session = request.getSession();
			session.setAttribute("lid", dto.getMid()); //("name", 내용)
			response.sendRedirect("./LoginComplete"); // 17.LoginComplete 서블릿 만들기
		}
		
	}//doPost

}
