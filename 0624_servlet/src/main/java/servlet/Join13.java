package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Join13")
public class Join13 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Join13() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response); //get 방식의 요청이 들어오면 doPost(하단)으로 가라.
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDTO dto = new MemberDTO();
		dto.setMid( request.getParameter("mid") );
		dto.setMpwd( request.getParameter("mpwd") );
		dto.setTel1( request.getParameter("te1l") );
		dto.setTel2( request.getParameter("tel2") );
		dto.setTel3( request.getParameter("tel3") );
		dto.setEmail1( request.getParameter("email1") );
		dto.setEmail2( request.getParameter("email2") );
		
		Join13DAO dao = new Join13DAO();
		int successCount = dao.insertMember(dto);
		
		response.setCharacterEncoding("euc-kr");
		PrintWriter out = response.getWriter();
		if(successCount > 0) {
			out.print("<h1>회원 가입 성공</h1>");
		} else {
			out.print("<h1>회원 가입 실패</h1>");
		}
		out.close();
	}//doPost

}
