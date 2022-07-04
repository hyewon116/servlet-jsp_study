package login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import login.dto.MemberDTO;

public class LoginDAO {
	
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; //8. url/user/비번 정보 입력
	private final String USER = "c##scott";
	private final String PASSWORD = "tiger";
	
	private Connection con; //7. con/psmt/rs 선언
 	private PreparedStatement psmt;
	private ResultSet rs;
	
	public LoginDAO() {//5. 생성자 만들기
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//6. 오라클 드라이버 불러오기 + try/catch
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}//생성자

	public int loginCheck(MemberDTO dto) throws SQLException {//3-1. loginYN에 담을 메소드 생성
		String sql = "select count(mid) cnt from member where mid=? and mpwd=?"; //4.쿼리 정보 변수에 담아놓기. *cnt는 별칭
		int loginYN = 0;
		
		con = DriverManager.getConnection(URL, USER, PASSWORD); //9. url 등 정보 커넥션 + throws (트라이캣치 안함)
		psmt = con.prepareStatement(sql); //10. 쿼리 정보 담은 psmt 객체 생성 (쿼리 수행) prepareStatement = 인수 값(?로 지정해 놓은)을 위한 공간 확보
		psmt.setString( 1, dto.getMid() ); //10-1.dto에 저장된 정보 set.
		psmt.setString( 2, dto.getMpwd() );
		
		rs = psmt.executeQuery(); //11. 결과 count (쿼리 수행)
		rs.next(); //12. before first에서 first로 내려주는 작업
		
		loginYN = rs.getInt("cnt"); //13. 별칭 이용해서 카운트
		
		rs.close(); //14. close
		psmt.close();
		con.close();
		
		return loginYN; //3-1. Login.java의 loginYN에 넘길 정보 
	}//loginCheck

}//class
