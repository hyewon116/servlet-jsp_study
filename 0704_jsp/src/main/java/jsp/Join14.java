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
		int successCount; //try문 안에서 지역변수가 되지 않게 하기 위해 따로 선언함.
		
		try {
			successCount = dao.insertMember(dto); //dto를 만든 이유 -> 이렇게 한 번에 dao에 담기 위해. mid, mpwd.. 하나씩 담기 번거로우니까!
		//3. dao의 insert 수행 중 오류 : exception 처리(RE10.java 참고) + 오류 메시지 출력
		//오류 메세지 출력 : 세션에 오류 메시지를 넣은 후, 오류 페이지 호출 -> 오류 페이지에서 세션 값 출력
		} catch (SQLException e) {
			e.printStackTrace();
			request.getSession().setAttribute("err_msg", "DBMS 오류. <br><br> 잠시 후 다시 시도해주세요.");
			response.sendRedirect("./jsp/14join_err_page.jsp");
			return;
		}
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//4. insert의 결과가 0일 때 : 오류 메시지 출력
		if(successCount < 1) {
			request.getSession().setAttribute("err_msg", "회원 가입 실패. <br><br> 잠시 후 다시 시도해주세요.");
			response.sendRedirect("./jsp/14join_err_page.jsp");
		//5. insert의 결과가 1일 때 : 성공 페이지 로드(0624 프로젝트 join13 참고)
		} else if(successCount == 1) {
			SuccessMsgDTO msgDTO = new SuccessMsgDTO();
			msgDTO.setMessage("회원 가입에 성공하셨습니다.<br><br>");
			msgDTO.setUrl("./15login.jsp");
			msgDTO.setUrlName("로그인 바로가기");
			request.getSession().setAttribute("success_msg_dto", msgDTO);
			response.sendRedirect("./jsp/success_page.jsp");
		}
	}//doPost
}//class
