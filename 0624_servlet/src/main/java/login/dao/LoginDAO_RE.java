package login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import login.dto.MemberDTO_RE;

public class LoginDAO_RE {
	
	private final String URL ="jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER ="c##scott";
	private final String PASSWORD ="tiger";
	
	private Connection con; 
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public LoginDAO_RE() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}//constructor
	
	public int loginCheck(MemberDTO_RE dto) throws SQLException {
		String sql = "select count(mid) cnt from member where mid=? and mpwd=?";
		int loginYN = 0;
		
		con = DriverManager.getConnection(URL, USER, PASSWORD);
		psmt = con.prepareStatement(sql);
		psmt.setString(1, dto.getMid() );
		psmt.setString(2, dto.getMpwd() );
		
		rs = psmt.executeQuery();
		rs.next();
		
		loginYN = rs.getInt("cnt");
		
		rs.close();
		psmt.close();
		con.close();
		
		return loginYN;
	}

}

