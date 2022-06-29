package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FreeBoardDAO {

	public FreeBoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //4. 오라클 드라이버 호출 + try catch  (OracleDriver : 오라클에서 제공한 자바와 오라클의 연동이 가능한 프로그램.)
		} catch (ClassNotFoundException e ){
			e.printStackTrace();
		}
	}//3. 생성자 만듦.
	
	private Connection con; //5. Connection, PreparedStatement import + 선언 + 다른 class에서 접근 못하게 private 설정
	private PreparedStatement psmt;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; //6. 연결할 내 컴퓨터 주소, 오라클 아이디/비번 입력
	private final String USER = "c##scott"; 
	private final String PASSWORD = "tiger";
	
	public int insertFreeboard(FreeBoardDTO dto) { //1.매개변수 dto 입력
		int successCount = 0; //2. successCount 생성 (글 횟수 세기 위한)
		String sql = "insert into freeboard(bno, btitle, bwriter, bcnts, bdate) "
				+ "values(mno_seq.nextval, ?, ?, ?, sysdate)"; //9. psmt에 집어넣을 정보 
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD); //7.드라이버매니저 호출
			psmt = con.prepareStatement(sql); //8. sql에 자료를 전송하기 위한 psmt 생성.
			psmt.setString(1, dto.getBtitle()); //10. 각 물음표에 넣을 정보 불러오기(html로 입력될 정보 불러오기)
			psmt.setString(2, dto.getBwriter());
			psmt.setString(3, dto.getBcnts());
			
			successCount = psmt.executeUpdate(); //11. 글쓴 횟수 카운트
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				psmt.close(); //12. close() 
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//finally 
		return successCount; //2. 메소드 호출하면 리턴할 successCount 설정 
	}

	public ArrayList<FreeBoardDTO> selectList() {
		ArrayList<FreeBoardDTO> list = new ArrayList<FreeBoardDTO>();
		String sql = "select bno, btitle, bwriter, bdate from freeboard"
				+ " order by bno desc"; //bno 순으로 정렬!!
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				FreeBoardDTO tmp = new FreeBoardDTO();
				tmp.setBno( rs.getString("bno") );
				tmp.setBtitle( rs.getString("btitle") );
				tmp.setBwriter( rs.getString("bwriter") );
				tmp.setBdate( rs.getString("bdate") );
				list.add(tmp);
			}//while
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				psmt.close();
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}//finally
		
		return list; 
	}//selectList
}
