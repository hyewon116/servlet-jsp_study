package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * HttpSession : 클라이언트의 서버 접속에 대한 기록을 남기는 객체.
 *  - 웹브라우저 하나당 하나의 세션을 생성
 *  - 서버가 갖는 클라이언트 정보 : ip, port, web browser, web browser version...
 *  - 서버가 갖는 클라이언트 정보를 바탕으로 세션을 만든다.
 *  - 하나의 컴에 엣지, 크롬이 있다면 두 브라우저는 각각의 세션을 갖게 된다.
 *  - 서버에 접속자의 정보를 들고 다닐 수 있는 객체.
 *  - 세션에 어떤 정보를 담을지는 개발자가 정하는 것.  
 */

@WebServlet("/Session25")
public class Session25 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Session25() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); //session 생성 방법 : 중요!!
		System.out.println(session.getId()); //session id를 받는 방법.
		
		session.setAttribute("mid", "apple"); //mid는 apple
		session.setAttribute("admin", "N"); 
		session.setAttribute("mgrade", "gold"); 
		
		FreeBoardDTO dto = new FreeBoardDTO();
		dto.setBtitle("joa");
		dto.setBwriter("banana"); //dto에 정보 담기 
		session.setAttribute("FreeBoardDTO", dto); //dto를 session에 담기?
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("hi"); list.add("hello");
		session.setAttribute("list", list);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("<h1>getId : " + session.getId() + "</h1>"); //session id가 웹 화면에 뜸. -> 새로고침해도 달라지지 않음. (브라우저 옮기면 다른 아이디 = 브라우저별로 세션 따로 부여)
		out.print("<h1>getMaxInactiveInterval : " + session.getMaxInactiveInterval() + "</h1>");
		/*
		 * MaxInactiveInterval : 클라이언트 접속 정보를 얼마나 유지할 것이냐. 
		 * MaxInactiveInterval의 초기값 : 1800초 : 30분 지나면 세션 삭제. 
		 * session.setMaxInactiveInterval(-1); //웹브라우저 종료시, 세션 바로 삭제
		 */
		out.print("<h1>getCreationTime : " + session.getCreationTime() + "</h1>");
		out.print("<h1>getLastAccessedTime : " + session.getLastAccessedTime() + "</h1>"); //초 단위까지 기록
		
		session.setMaxInactiveInterval(60 * 60 * 24); //60초 * 60분 * 24시간 ex)은행 로그인 유지시간은 10분
		out.print("<h1>getMaxInactiveInterval : " + session.getMaxInactiveInterval() + "</h1>");
		out.close();
	
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
