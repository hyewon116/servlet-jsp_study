package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Forward211")
public class Forward211 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Forward211() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==== start Forward211 ====");
		
		PrintWriter out = response.getWriter();
		out.print("<body bgcolor=gray></body>");
		out.close();
		
		System.out.println("==== end Forward211 ====");
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
