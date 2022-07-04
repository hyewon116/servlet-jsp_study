package login.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ErrMsg_RE")
public class ErrMsg_RE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ErrMsg_RE() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("<h1>" + request.getAttribute("error_message") + "</h1>");
		out.print("<a href='./svl/27login.html'>로그인 바로가기</a>");
				
		out.close();
	}//doGet


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
