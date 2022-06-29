package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Join13DAO {
	public Join13DAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}//constructor
	
	private Connection con;
	private PreparedStatement psmt; //일반 statement와의 차이점 알아보기. psmt는 ?에 값을 넣을 수 있음.
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";  //대문자로 만들기 단축키=ctrl + shift + x
	private final String USER = "c##scott";
	private final String PASSWORD = "tiger";  
	
	public int insertMember(MemberDTO dto) { //메소드
		int successCount = 0;
		String sql = "insert into member(mno, mid, mpwd, "
				+ "tel1, tel2, tel3, email1, email2, mdate) values("
				+ "mno_seq.nextval, ?, ?, ?, ?, ?, ?, ?, sysdate)";
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getMid()); //첫 번째 물음표에 넣을 값
			psmt.setString(2, dto.getMpwd()); //두 번째 물음표에 넣을 값
			psmt.setString(3, dto.getTel1());
			psmt.setString(4, dto.getTel2());
			psmt.setString(5, dto.getTel3());
			psmt.setString(6, dto.getEmail1());
			psmt.setString(7, dto.getEmail2());
			successCount = psmt.executeUpdate(); //insert된 갯수를 담음. 
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				psmt.close();
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}//finally
		return successCount;
	}//insertMember
}//class
