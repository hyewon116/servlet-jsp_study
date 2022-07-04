package login.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginComplete")
public class LoginComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginComplete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(); //18. 세션 만들기
		String loginID = (String) session.getAttribute("lid");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html charset=UTF-8");
		PrintWriter out = response.getWriter();

		//19. 로그인 여부에 따른 출력
		if(loginID == null || loginID.equals("")) {//로그인 안 된 사람.
			out.print("<h1>로그인 해주세요.</h1>");
			out.print("<a href='./svl/27login.html'>로그인 바로가기</a>");
		} else {//로그인 된 사람.
			response.addHeader("refresh"
					, "5;url=http://localhost:8080/0624_servlet/svl/13index.html");
			out.print("<h1>" + loginID + "님 환영합니다.</h1>");
		} 
		out.close();
		
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
