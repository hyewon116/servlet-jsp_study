package login.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ErrMsg") //에러 메시지 출력 전용 서블릿
public class ErrMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ErrMsg() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8"); //17. 한글 입력 설정 
		response.setContentType("text/html charset=UTF-8");
		
		PrintWriter out = response.getWriter(); //18.response(응답)보낼 writer 불러오기
		out.print("<h1>" + request.getAttribute("error_message") + "</h1>"); //19. 아까 설정한 네임으로 메시지 설정
		out.print("<a href='./svl/27login.html'>로그인 바로가기</a>"); //20.로그인 바로가기 만들기
		
		out.close();
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
