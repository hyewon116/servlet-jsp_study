package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SelectEmp11")
public class SelectEmp11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public SelectEmp11() {
        super();
    }
    
    private SelectEmp11DAO dao;
    public void init() throws ServletException {
    	super.init();
    	dao = new SelectEmp11DAO();
    }//init - 최초의 1번만 수행

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.print("<table border = 1><tbody>");
		
		ArrayList<SelectEmp11DTO> list = dao.selectEmp();
		for(int i = 0; i < list.size(); i++) {
			SelectEmp11DTO tmpDTO = list.get(i);
			out.print("<tr>");
			out.print("<td>" + tmpDTO.getEmpno() + "</td>");
			out.print("<td>" + tmpDTO.getEname() + "</td>");
			out.print("<td>" + tmpDTO.getJob() + "</td>");
			out.print("<td>" + tmpDTO.getMgr() + "</td>");
			out.print("<td>" + tmpDTO.getHiredate() + "</td>");
			out.print("<td>" + tmpDTO.getSal() + "</td>");
			out.print("<td>" + tmpDTO.getComm() + "</td>");
			out.print("<td>" + tmpDTO.getDeptno() + "</td>");			
			out.print("<tr>");
		}//for
		
		out.print("</tbody></table>");
		out.close();
		
		//DAO : data access object = db 접속을 담당하는 java class : servlet 아니어도 된다.
		
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}//class
