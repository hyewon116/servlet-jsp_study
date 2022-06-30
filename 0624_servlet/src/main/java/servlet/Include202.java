package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Include202")
public class Include202 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Include202() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("==== start 202 ====");
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>" + request.getParameter("mid") + "</h1>");
		out.print("<h1>" + request.getParameter("mpwd") + "</h1>");
		out.print("<h1>" + request.getParameter("hid") + "</h1>");
		out.close();
		
		System.out.println("==== end 202 ====");
		
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
