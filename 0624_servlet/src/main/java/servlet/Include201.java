package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Include201")
public class Include201 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Include201() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("==== start 201 ====");
		System.out.println("mid : " + request.getParameter("mid"));
		System.out.println("mpwd : " + request.getParameter("mpwd"));
		System.out.println("hid : " + request.getParameter("hid"));
		
		RequestDispatcher disp = request.getRequestDispatcher("./Include202"); //이 문장이 쓰인 부분에 202 파일 내용이 붙여넣기 됨.
		disp.include(request, response);
		//disp.include는 request와 response를 공유한다.
		//out.print("<hi>This is message from 201. </h1>"); = 수행x -> 202에서 out.close()됐으므로. (202 파일의 마지막에서 두번째 줄)
		//out.close();
		
		System.out.println("==== end 201 ====");
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}










