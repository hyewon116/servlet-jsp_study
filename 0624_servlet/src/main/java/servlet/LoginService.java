package servlet;

import java.sql.SQLException;

public class LoginService {
	
	private LoginDAO dao; //4. LoginDAO 불러오기  
	public LoginService() {
		dao = new LoginDAO();//4.
	}// 1. 생성자(constructor) 만들기
	
	public int loginCheck(MemberDTO dto) throws SQLException { //2. 메소드 만들기
		int result = 0; //3. result 변수 선언
		
		result = dao.idCheck(dto);//5. dao의 메소드 불러오기
		if(result != 1) {//id는 한 개만 있어야 하므로(중복 안 됨) = 1이 아니면 id 오류
			return -1;
		}
		result = dao.loginCheck(dto); //5. 
		return result;//0이면 pwd 오류. 1이면 정상 로그인 수행 가능.
	}//loginCheck
}//class
