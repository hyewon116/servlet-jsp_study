package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Redirect16ErrorPage")
public class Redirect16ErrorPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Redirect16ErrorPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>저장을 실패하였습니다.</h1>");
		out.print("<h1><a href='http://localhost:8080/0624_servlet/svl/13index.html'>홈으로 가기</a></h1>");
		out.close();
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
