package jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login15DAO {
	
	public Login15DAO () {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}//constructor (리턴 타입 없음) 
	
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
	private final String USER = "c##scott";
	private final String PASSWORD = "tiger";
	
	private Connection con;
	private PreparedStatement psmt;
	private ResultSet rs;
	private String sql;
	
	public int loginCheck(String id, String pwd) throws SQLException {	
		
		int loginYN = 0;
		
		con = DriverManager.getConnection(URL, USER, PASSWORD);
		
		sql = "select count(mno) cnt from member where mid=? and mpwd=?";
		psmt = con.prepareStatement(sql);
		psmt.setString(1, id); //물음표에 메소드 인자로 받은 값을 대입
		psmt.setString(2, pwd);
		rs = psmt.executeQuery();
		rs.next(); //before first에서 first로 내려주는 작업
		
		loginYN = rs.getInt("cnt");
		
		rs.close();
		psmt.close();
		con.close();
		
		return loginYN;
	}//loginCheck

}//class
