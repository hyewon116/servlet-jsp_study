package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = {"/Config24", "/Config241", "/Config242"}
		, initParams = { 
				@WebInitParam(name="time1", value="breakfast")
				, @WebInitParam(name="time2", value="lunch")
				, @WebInitParam(name="time3", value="dinner") //아래 getInitParameter으로 호출
				
		}
)
//실행 후 웹 창에서 주소 끝부분을 241, 242로 바꿔보면, 콘솔창에 "servlet.Config24"라고 뜸. 
//저 3가지 이름이 모두 Config24를 뜻하는 것.
public class Config24 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Config24() {
        super();
    }
    
	String[] colors = {"pink", "skyblue", "gray"};
	int i = 0;
	
    /*
     * ServletConfig : 서블릿 실행환경의 하나.
     *  - 서블릿을 실행하기 위한 설정 값들을 가지고 있는 개념.
     *  - 예) @WebServlet : ServletConfig에 프로그램 id를 설정하는 역할.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		System.out.println(config.getServletName()); //현재 서블릿 이름 출력: servlet.Config24
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<body bgcolor=" + colors[(i%3)] + "></body>"); //새로고침 할 때마다 배경 색깔 변함.
		i++;
		
		out.print("<h1>" + getInitParameter("time1") + "</h1>");
		out.print("<h1>" + getInitParameter("time2") + "</h1>");
		out.print("<h1>" + getInitParameter("time3") + "</h1>");
		
		out.close();
		
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
