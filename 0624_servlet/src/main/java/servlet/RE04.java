package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RE04") // RE04 = program id
// @ : annotation, @WebServlet : program id를 등록하는 표현 
public class RE04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RE04() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("<h1><font color=red>Hello World!</font></h1>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}//class

/*
 * 서블릿 프로그램 하나마다 프로그램 id가 있어야 한다.
 * 
 */

