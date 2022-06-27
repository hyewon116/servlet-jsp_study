package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RE05")
public class RE05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RE05() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=== RE05 : doGet ===");
		String id = request.getParameter("mid"); //request : 유저가 보낸 정보가 담겨 있음 Parameter : name으로 정보를 불러낼 수 있는 메소드 (05re.html에서 지정했던 네임)
		String password = request.getParameter("mpwd");
		String hidden1 = request.getParameter("h1");
		
		System.out.println(request.getParameter("mid"));
		System.out.println(request.getParameter("mpwd"));
		System.out.println(request.getParameter("h1"));
		
		response.setCharacterEncoding("euc-kr");
		PrintWriter out2 = response.getWriter(); //response(내보내는 정보)에 PrintWriter를 쓰겠다.
		out2.print("<h1>클라이언트가 입력한 id를 서버에서 받아서 다시 클라이언트로 보냄 : " + id + "</h1>");
		out2.close();
		/*
		 * doGet 메소드를 호출해주는 객체 : tomcat
		 *  - 클라이언트가 프로그램 id를 톰캣에 전달 
		 *  	-> 톰캣이 프로그램 id를 실행 
		 *        + 클라이언트가 보낸 정보를 HttpServletRequest 객체로 생성해서 프로그램에 전달
		 *        + 클라이언트에게 보낼 html 문서를 넣는 객체 HttpServletResponse 객체도 생성해서 프로그램에 전달         
		 */
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=== RE05 : doPost ===");
		String id2 = request.getParameter("mid");
		String password2 = request.getParameter("mpwd");
		String h12 = request.getParameter("h1"); 
		System.out.println(id2);
		System.out.println(password2);
		System.out.println(h12);
		
		response.setCharacterEncoding("euc-kr"); //한글 설정. 꼭 필요!
		PrintWriter out3 = response.getWriter();
		out3.print("유저가 전송한 id, password, hidden data가 서버에 잘 도착하였습니다.");
		out3.close();
	}//doPost

}
