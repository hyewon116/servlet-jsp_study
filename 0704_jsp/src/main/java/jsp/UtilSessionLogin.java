package jsp;

import javax.servlet.http.HttpSession;

public class UtilSessionLogin { //로그인 검사
	
	public static boolean isLogin(HttpSession session) {
		boolean loginYN = false;
		String loginID = (String) session.getAttribute("login_id");
		if(loginID != null && loginID.trim().length() > 0) {
			loginYN = true;
		} 
		return loginYN;
	}//isLogin
}//class
