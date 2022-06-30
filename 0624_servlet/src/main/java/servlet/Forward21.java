package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Forward21")
public class Forward21 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Forward21() {
        super();
    }
    /* RequestDispatcher.forward
     *  - 다른 서블릿에게 프로그램의 흐름을 넘기는 표현
     *  - 현재 예제에서 21의 결과는 클라이언트에게 보이지 않고, 211의 결과만이 클라이언트에게 보인다.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==== start Forward21 ====");
		
		RequestDispatcher disp = request.getRequestDispatcher("./Forward211");
		disp.forward(request, response);
		
		PrintWriter out = response.getWriter();
		out.print("<body bgcolor=red></body>");
		out.close();
		
		System.out.println("==== end Forward21 ====");
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
