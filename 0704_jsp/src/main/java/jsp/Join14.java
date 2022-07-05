package jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Join14")
public class Join14 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Join14DAO dao;
    public Join14() {
        super();
        dao = new Join14DAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1. getParameter 수행 : 클라이언트에서 온 데이터를 받는다.
		MemberDTO dto = new MemberDTO();
		dto.setMid( request.getParameter("mid") );
		dto.setMpwd( request.getParameter("mpwd") );
		dto.setTel1( request.getParameter("tel1") );
		dto.setTel2( request.getParameter("tel2") );
		dto.setTel3( request.getParameter("tel3") );
		dto.setEmail1( request.getParameter("email1") );
		dto.setEmail2( request.getParameter("email2") );
		
		//2. dao에 클라이언트에서 온 데이터를 전달 -> dao는 insert 수행 
		int successCount;
		
		try {
			successCount = dao.insertMember(dto);
		//3. dao의 insert 수행 중 오류 : exception 처리(RE10.java 참고) + 오류 메시지 출력
		} catch (SQLException e) {
			e.printStackTrace();
			request.getSession().setAttribute("err_msg", "DBMS 오류 - 잠시 후 다시 시도해주세요.");
			response.sendRedirect("./jsp/14join_err_page.jsp");
			return;
		}
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//4. insert의 결과가 0일 때 : 오류 메시지 출력
		//5. insert의 결과가 1일 때 : 성공 페이지 로드(0624 프로젝트 join13 참고)
		if(successCount > 0) {
			RequestDispatcher disp = request.getRequestDispatcher("./jsp/14Join_result.jsp");
			disp.forward(request, response);
		} else {
			out.print("<h1>회원 가입 실패</h1>");
		}
	}//doPost
}//class
