package jsp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ExeSearch09")
public class ExeSearch09 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ExeSearch09DAO dao;
	
    public ExeSearch09() {
        super();
        dao = new ExeSearch09DAO();
    }//constructor

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("ename");
		//search의 기본은 like 검색. ex) ename like '%S%'; = ename에 S가 들어가는 모든 사람.
		//-> 결과 값이 list로 올 수 있다. 
		ArrayList<EmpDTO> list = null; 
        
		try {
			list = dao.nameSearch(name);
		} catch (SQLException e) {
			e.printStackTrace();
			request.getSession().setAttribute("err_msg", 
					"DBMS 오류입니다. <br><br> 잠시 후 다시 시도해주세요.");
			response.sendRedirect("./jsp/09err_msg.jsp");
			return;
		}
		
		request.setAttribute("list", list);
		RequestDispatcher disp 
		= request.getRequestDispatcher("./jsp/09result_search.jsp");
		disp.forward(request, response);
		
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
