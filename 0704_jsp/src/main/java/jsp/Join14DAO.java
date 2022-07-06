package jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Join14DAO {
	
	public Join14DAO() {
		//1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}//constructor

	private Connection con;
	private PreparedStatement psmt;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";  //1521 : 오라클 listener의 포트번호, XE는 Oracle database client의 고유한 service name이다. 디폴트로 XE를 사용한다.
	private final String USER = "c##scott";
	private final String PASSWORD = "tiger";
			
	public int insertMember(MemberDTO dto) throws SQLException {
		int successCount = 0;
		
		//2. 커넥션 연결
		con = DriverManager.getConnection(URL, USER, PASSWORD);
		//3. sql 전송
		String sql = "insert into member(mno, mid, mpwd, tel1, tel2, "
				+ "tel3, email1, email2, mdate) values ("
				+ "mno_seq.nextval, ?, ?, ?, ?, ?, ?, ?, sysdate)";
		
		psmt = con.prepareStatement(sql);
		psmt.setString(1, dto.getMid());
		psmt.setString(2, dto.getMpwd());
		psmt.setString(3, dto.getTel1());
		psmt.setString(4, dto.getTel2());
		psmt.setString(5, dto.getTel3());
		psmt.setString(6, dto.getEmail1());
		psmt.setString(7, dto.getEmail2());
		
		//4. 결과 확인(select -> resultset, insert/update/delete -> int)
		successCount = psmt.executeUpdate();
		//★select -> executeQuery(), insert/update/delete -> executeUpdate()
		//5. close
		psmt.close();
		con.close();
		
		return successCount;
	}//insertMember
}//class
