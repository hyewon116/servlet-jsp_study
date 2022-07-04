package servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookie28")
public class Cookie28 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Cookie28() {
        super();
    }
    /*
     * Cookie : 사용자 웹브라우저에 사용자 관련 정보를 보관하는 방법
     *  - 보안이 취약
     *  - 클라이언트에게 쿠키를 내보낸다 : response.addCookie
     *  ** language마다 생성방식 다름.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie c1 = new Cookie("name", "value"); //cookie import : javax.servlet.http
		System.out.println(c1.getMaxAge()); // 출력 : -1 
		//MaxAge : 쿠키의 유효기간 (생존 시간) 
		// ** -1 = 브라우저 종료시 쿠키 삭제 
		System.out.println(c1.getDomain()); //출력 : null (아직 설정 전이라)
		
		//MaxAge를 늘리고 싶다면
		c1.setMaxAge(60 * 60 * 24);//60초 * 60분 * 24시간 == 하루
		//domain setting
		c1.setDomain( request.getServerName() );
		
		Cookie c2 = new Cookie("cookie_test", "thisiscookietest...");
		Cookie c3 = new Cookie("login_data"
				, URLEncoder.encode("cookie can contain 로그인 data.", "UTF-8") ); //URLEncoder : 공백을 넣을 수 있게 함 
		
		response.addCookie(c1);
		response.addCookie(c2);
		response.addCookie(c3);
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
