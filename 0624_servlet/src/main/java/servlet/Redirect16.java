package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Redirect16")
public class Redirect16 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Redirect16() {
        super();
    }
    
    /*response.sendRedirect() : 연결 재설정
     * - 최초에 클라이언트가 요청한 서블릿이 아닌 다른 서블릿을 클라이언트가 호출하도록 유도.
     * - 클라이언트의 요청을 다른 서블릿으로 바꾼 것.
     * - 클라이언트 웹 브라우저에서 일어난다. 
     * - 클라이언트의 화면을 바꿔주고 싶을 때 사용한다.
     * - 예) 게시글 쓰기 성공 후, 게시글 목록으로 이동할 때 사용.
     * - 예) 로그인 성공 후, 메인 페이지로 이동할 때 사용.
     * - 중요!! 
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("./Request07"); 
		//유저는 현재 파일(Redirect16)를 실행했지만, Request07 파일을 실행시킴.
		//현재 파일 역시 유저의 web에는 도달하지만 출력되지 않고, 다시 서버로 돌아와 07 파일을 response함.
		
		PrintWriter out = response.getWriter();
		out.print("<body bgcolor=gray><h1>hello</h1></body>");
		out.close();
	
		System.out.println("16 - get - after redirect...");
		
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
