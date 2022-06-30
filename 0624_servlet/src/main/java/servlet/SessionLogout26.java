package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionLogout26")
public class SessionLogout26 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionLogout26() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(); //세션 받아와서 생성
		session.invalidate();//invalidate() = 모든 세션 삭제 //logout
		System.out.println("==== session.invalidate complete ====");
		
		response.sendRedirect("./svl/13index.html"); //sendRedirect()=단순 화면 전환.
		//response.sendRedirect("http://localhost:8080/0624_servlet/svl/13.index.html"); ->이렇게 쳐도 됨.(위와 같은 거)
		
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
