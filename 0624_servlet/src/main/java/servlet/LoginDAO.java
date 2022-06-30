package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	//(con 등 변수 선언은 원래 이자리에(이렇게) 해야 함!)
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "c##scott";
	private final String PASSWORD = "tiger";
	
	private Connection con;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public LoginDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}//생성자
	
	public int idCheck(MemberDTO dto) throws SQLException {//id만 체크 (유효한 아이디인지를 먼저 체크)
		//결과 값이 0 : 아이디가 없다. 
		//결과 값이 1 : 아이디가 있다. 
		
		String sql = "select count(mid) from member where mid = ?";
		int result = 0;
		
		con = DriverManager.getConnection(URL, USER, PASSWORD);
		psmt = con.prepareStatement(sql);
		psmt.setString( 1, dto.getMid() ); //물음표 1개 값 
		rs = psmt.executeQuery();
		
		rs.next(); //ResultSet을 before first에서 first로 한 칸 내리기.
		result = rs.getInt(1);
		
		rs.close();
		psmt.close();
		con.close();
		
		return result;
	}//idCheck
	
	public int loginCheck(MemberDTO dto) throws SQLException {//id과 pwd 체크.(유효한 아이디의 패스워드까지 체크)
		//결과 값이 0 : id는 이미 있으므로, pwd가 잘못됐다.
		//결과 값이 1 : id도 있고, pwd도 정상이다.
		String sql = "select count(mid) from member where mid = ? and mpwd = ?";
		int result = 0;
		
		con = DriverManager.getConnection(URL, USER, PASSWORD);
		psmt = con.prepareStatement(sql);
		psmt.setString( 1, dto.getMid() );
		psmt.setString( 2, dto.getMpwd() );
		rs = psmt.executeQuery();
		
		rs.next();
		result = rs.getInt(1);
		
		rs.close();
		psmt.close();
		con.close();
		
		return result;
	}//loginCheck
}
