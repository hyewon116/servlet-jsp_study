package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Location18")
public class Location18 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public Location18() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("18 - doGet - start");
		
		PrintWriter out = response.getWriter();
		
		out.print("<body><script>");
		//out.print("location.href='https://www.naver.com';");
		out.print("location.href='./Request07';");
		out.print("</script></body>");
		
		out.close();
		System.out.println("18 - doGet - end");
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
