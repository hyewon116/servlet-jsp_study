package jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MBUpdate18")
public class MBUpdate18 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MB18DAO dao;
    public MBUpdate18() {
        super();
        dao = new MB18DAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String loginID = (String) request.getSession().getAttribute("login_id");
		
		String no = request.getParameter("bno");
		String title = request.getParameter("title");
		String writer = loginID;
		String cnts = request.getParameter("cnts");
		
		int successCount = 0;
		
		successCount = dao.update(no, title, writer, cnts);
		
	}//doPost

}
