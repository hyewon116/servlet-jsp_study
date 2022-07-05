package jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Join14DAO {
	
	public Join14DAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}//constructor

	private Connection con;
	private PreparedStatement psmt;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "c##scott";
	private final String PASSWORD = "tiger";
			
	public int insertMember(MemberDTO dto) throws SQLException {
		int successCount = 0;
		String sql = "insert into member(mno, mid, mpwd, tel1, tel2, "
				+ "tel3, email1, email2, mdate) values ("
				+ "mno_seq.nextval, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			
		con = DriverManager.getConnection(URL, USER, PASSWORD);
		psmt = con.prepareStatement(sql);
		psmt.setString(1, dto.getMid());
		psmt.setString(2, dto.getMpwd());
		psmt.setString(3, dto.getTel1());
		psmt.setString(4, dto.getTel2());
		psmt.setString(5, dto.getTel3());
		psmt.setString(6, dto.getEmail1());
		psmt.setString(7, dto.getEmail2());
		successCount = psmt.executeUpdate();
		
		psmt.close();
		con.close();
		
		return successCount;
	}//insertMember
}//class
