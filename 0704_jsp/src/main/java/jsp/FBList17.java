package jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FBList17") //pid와 class명 동일하게 설정했지만, 원래는 달라도 됨.
public class FBList17 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private FB17DAO dao;
    public FBList17() {
        super();
        dao = new FB17DAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd"); //name=cmd 인 파라미터를 불러옴.
		if(cmd == null) cmd = "list"; //cmd 값이 없으면 list로 설정해라.
		
		if(cmd.equals("uform")) { //업데이트 수행 (17fb_detail.jsp에서 삭제 버튼 눌렀을 때)
			String no = request.getParameter("no");
			BoardDTO dto = null;
			try { 
				dto = dao.detail(no);
			} catch(SQLException e) {
				e.printStackTrace();
				UtilMessage.setSessionMsg(request.getSession()
										, "DBMS 오류"
										, request.getContextPath() + "/FBList17?cmd=list"
										, "게시판 목록으로 바로가기");
				response.sendRedirect(request.getContextPath() + "/jsp/fail_page.jsp");
				return;
			}
			request.setAttribute("free_board_detail", dto);
			request.getRequestDispatcher("/jsp/17fb_update.jsp").forward(request, response);
			
		} else if(cmd.equals("delete")) { //글 삭제 수행 (17fb_detail.jsp에서 삭제 버튼 눌렀을 때)
			String no = request.getParameter("no");
			int successCount = 0;
			
			try { 
				successCount = dao.delete(no); //dao의 delete 메소드로 이동(no를 안고) -> 리턴 값이 있다면 삭제.
			} catch (SQLException e) {
				e.printStackTrace();
				UtilMessage.setSessionMsg(request.getSession()
										, "DBMS 오류"
										, request.getContextPath() + "/FBList17?cmd=list"
										, "게시판 목록으로 바로가기");
				response.sendRedirect(request.getContextPath() + "/jsp/fail_page.jsp");
				return;
			}
			if ( successCount == 0 ) { //글 삭제 실패 
				UtilMessage.setSessionMsg(request.getSession()
										, "게시글 삭제에 실패하였습니다."
										, request.getContextPath() + "/FBList17?cmd=list"
										, "게시판 목록으로 바로가기");
				response.sendRedirect(request.getContextPath() + "/jsp/fail_page.jsp");
			} else if ( successCount == 1 ) { //글 삭제 성공(executeupdate가 됐으므로 count + 1 됨)
				//<script> 태그로 alert 띄우기. (원리는 모름..)
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();

				out.println("<script>alert("+request.getParameter("no")+"+'번 글이 삭제되었습니다.');location.href='./FBList17?cmd=list';</script>");  
				out.flush();
			//	response.sendRedirect(request.getContextPath() + "/FBList17?cmd=list");
			}
			
		} else if(cmd.equals("detail")){ //글 제목 클릭 수행
			
			String no = request.getParameter("no");
			BoardDTO dto = null;
			try {
				dto = dao.detail(no); //dao의 detail 메소드로 이동(no를 안고) -> dto 한 건 리턴.(1건이라 Arraylist 필요x) 
			} catch (SQLException e) {//DB 오류가 발생했을 때
				e.printStackTrace();
				UtilMessage.setSessionMsg(request.getSession()
											, "DBMS 오류" 
											, request.getContextPath() + "/FBList17?cmd=list"
											, "게시판 목록으로 바로가기");
				response.sendRedirect(request.getContextPath() + "/jsp/fail_page.jsp");
				return;
			}
			request.setAttribute("free_board_detail", dto);
			RequestDispatcher disp 
				= request.getRequestDispatcher("./jsp/17fb_detail.jsp");
			disp.forward(request, response);
			
		} else if (cmd.equals("list") ) { //list 
			ArrayList<BoardDTO> list = null;	
			try {
				list = dao.list();
			} catch (SQLException e) {
				e.printStackTrace(); //개발자의 에러 수정을 위해 콘솔 출력
				UtilMessage.setSessionMsg(request.getSession()
										, "DBMS 오류."
										, request.getContextPath() + "jsp/main.jsp"
										, "메인으로 바로가기");
				response.sendRedirect(request.getContextPath() + "/jsp/fail_page.jsp");
				
				return;
			}//catch
			
			request.setAttribute("free_board_list", list);
			RequestDispatcher disp = request.getRequestDispatcher("./jsp/17fb_list.jsp");
			disp.forward(request, response); //위 주소로 이동하되, request, response 정보를 모두 들고 이동해라.
		}
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//글쓰기는 doPost에서 수행. (post로 받음)
		
		request.setCharacterEncoding("UTF-8");//한글 설정
		
		//0. cmd에 따라서 분기한다.
		String cmd = request.getParameter("cmd");
		if(cmd.equals("write")) {
			//1. BoardDTO에 request.getParameter - 3개 (title, write, cnts) 담는다
			BoardDTO dto = new BoardDTO();
			dto.setBtitle(request.getParameter("title")); //글쓰기 란에 쓴 내용들을 dto에 담음. (제목, 작성자, 타이틀..) ->다건이므로 dto에 담는 게 편함.
			dto.setBwriter(request.getParameter("writer"));
			dto.setBcnts(request.getParameter("cnts"));
			
			//2. int successCount = dao.write(dto);
			int successCount = 0; //try문 안에서 지역변수가 되는 걸 방지하기 위해 따로 선언
			try {
				successCount = dao.write(dto); //dto에 담은 내용을 dao의 write 메소드로 보냄. + DBMS insert의 성공 건수 받아옴.
			} catch (SQLException e) {
				e.printStackTrace();
				//3. exception 처리 -> 메시지 처리
				UtilMessage.setSessionMsg(request.getSession()
										, "DBMS 오류"
										, request.getContextPath() + "/jsp/main.jsp"
										, "메인으로 바로가기");
				// -> UtilMessage라는 Utility class 만들어서 간단하게 오류 메시지 설정. 
				response.sendRedirect("./jsp/fail_page.jsp");
				return;
			}
			
			//4. successCount == 0 처리 -> 메시지 처리
			if( successCount == 0 ) { //보통 DBMS 에러에서 걸러지지만, 만에 하나라도 생길 오류를 위해.
				UtilMessage.setSessionMsg(request.getSession()
											, "게시판 글쓰기가 실패하였습니다."
											, request.getContextPath() + "/FBList17"
											, "게시판 목록으로 바로가기");
				response.sendRedirect(request.getContextPath() + "/jsp/fail_page.jsp");//=> ("./jsp/fail_page.jsp");
				
			//5. successCount == 1 처리 -> list 호출
			} else if ( successCount == 1 ) {
				response.sendRedirect(request.getContextPath() + "/FBList17?cmd=list"); //=>("./FBList17?cmd=list"); //실행 시점이 jsp 패키지 내부 
				// => 글 작성 성공하면 다시 리스트로 돌아감. FBList17가 다시 시작.(doGet 메소드 실행)
			}
		} else if (cmd.equals("update") ) {
			//** dto 없이 해보기!!
			String no = request.getParameter("no");
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String cnts = request.getParameter("cnts");
			int successCount = 0;
			try {
				successCount = dao.update(no, title, writer, cnts); //dto 없으니 일일이 담아야 함.
			} catch (SQLException e) {
				e.printStackTrace();
				UtilMessage.setSessionMsg(request.getSession() 
											, "DBMS 오류" 
											, request.getContextPath() + "/FBList17?cmd=list"
											, "게시판 목록으로 바로가기");
				response.sendRedirect(request.getContextPath() + "/jsp/fail_page.jsp");
				return;
			} 
			if ( successCount == 0 ) { //업데이트 실패
				UtilMessage.setSessionMsg(request.getSession() 
										, "게시글 수정을 실패하였습니다." 
										, request.getContextPath() + "/FBList17?cmd=list"
										, "게시판 목록으로 바로가기");
				response.sendRedirect(request.getContextPath() + "/jsp/fail_page.jsp");
			} else if ( successCount == 1 ) { //업데이트 성공
				response.sendRedirect("./FBList17?cmd=list"); 
				//글 수정 성공하면 목록으로 돌아가기.				
			}
		}
	}//doPost
}//class
