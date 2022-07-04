package servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookie282Get")
public class Cookie282Get extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Cookie282Get() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		Cookie[] cookieArr = request.getCookies(); 
		for(Cookie coo : cookieArr) {
			System.out.println(coo.getName() + " : " 
					+ URLDecoder.decode(coo.getValue(), "UTF-8") ); //URLDecoder : 한글 나오게 해줌. (28에서 encode한 거 다시 decode)
			System.out.println(coo.getMaxAge() + " : " + coo.getDomain());
			System.out.println("======================================");
		}
	}//doGet
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
