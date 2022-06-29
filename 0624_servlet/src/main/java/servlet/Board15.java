package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Board15")
public class Board15 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	
	FreeBoardDAO dao;   //빨간 줄에 마우스 대고 create 파일
    public Board15() {
        super();
        dao = new FreeBoardDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		if(cmd.equals("list")) {
			ArrayList<FreeBoardDTO> list = dao.selectList(); //dao에 selectList 메소드를 만들어, 목록을 받아와서 ArrayList에 담기.  
			// => FreeBoardDTO를 가진 ArrayList
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");//한글 설정

			PrintWriter out = response.getWriter();  
			
			out.print("<table border=1><tbody>");
			for (int i = 0; i < list.size(); i++) {
				out.print("<tr>");
				FreeBoardDTO tmpDTO = list.get(i);
				out.print("<td>" + tmpDTO.getBno() + "</td>");
				out.print("<td>" + tmpDTO.getBtitle() + "</td>");
				out.print("<td>" + tmpDTO.getBwriter() + "</td>");
				out.print("<td>" + tmpDTO.getBdate() + "</td>");
				out.print("</tr>");
			}//for
			out.print("</table></tbody>");
			out.close();
		} else if(cmd.equals("detail")) {
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	
		request.setCharacterEncoding("UTF-8");
		
		String cmd = request.getParameter("cmd");
		if(cmd.equals("reg")) { //reg면, 제목/작성자/내용을 전달받아야 함. so, DTO파일 생성.
			FreeBoardDTO dto = new FreeBoardDTO(); //빨간 줄 뜨면 마우스 갖다대고 자동으로 class 생성
			dto.setBtitle( request.getParameter("title") );
			dto.setBwriter( request.getParameter("writer") );
			dto.setBcnts( request.getParameter("cnts") );
			
			int successCount = dao.insertFreeboard(dto); //FreeBoardDAO class에 만든 insert~~ 메소드 가져와서 글 갯수 count.
			
			response.setCharacterEncoding("euc-kr"); //한글 설정 
			
			PrintWriter out = response.getWriter(); //웹 화면에 내보낼(response) 정보를 printwriter를 써서 내보낼 거야.
			successCount = 0;//에러 테스트용
			if (successCount > 0) { //글쓰기 정보가 1건 이상 들어오면 (=글 1개)
				//out.print("<h1>글쓰기 성공</h1>");
				response.sendRedirect("./Board15?cmd=list");
			} else {
				//out.print("<h1>글쓰기 실패 - 서버 로그를 확인해주세요. </h1>");
				response.sendRedirect("./Redirect16ErrorPage");
			}
			out.close();
		}//자유 게시판 등록
	}//doPost

}//class












