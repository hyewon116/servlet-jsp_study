package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Refresh17")
public class Refresh17 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Refresh17() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("17 - doGet - start");
		//refresh = 새로고침
		//3초 후(3;), 네이버로 이동.
		response.addHeader("refresh", "3;url=https://www.naver.com");
		//http 프로토콜의 헤더에 화면 전환할 url을 포함시키는 방법. 
		//response.addHeader("refresh", "2;url=Request07"); //실습 페이지로 이동하는 것도 할 수 있음.
		System.out.println("17 - doGet - end");
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
