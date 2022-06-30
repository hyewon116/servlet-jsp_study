package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Forward221")
public class Forward221 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Forward221() {
        super();
    }
    //disp.forward : forward된 서블릿과 request, response를 공유한다.
   
    /*
     * include / forward / sendRedirect의 차이점 
     * - sendRedirect는 request, response를 공유하지 않는다. location이나 refresh와 비슷함.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("==== start 221 ====");
		System.out.println( "mid : " + request.getParameter("mid") );
		System.out.println( "mpwd : " + request.getParameter("mpwd") );
		System.out.println( "hid : " + request.getParameter("hid") );
		
		RequestDispatcher disp = request.getRequestDispatcher("./Forward222");
		disp.forward(request, response);
		
		System.out.println("==== end 221 ====");
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
