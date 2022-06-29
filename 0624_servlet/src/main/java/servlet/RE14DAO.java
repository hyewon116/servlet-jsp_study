package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RE14DAO {

	public RE14DAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//OracleDriver : 오라클에서 제공한 자바와 오라클의 연동이 가능한 프로그램.
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}//생성자(constructor)
	
	Connection con;
	PreparedStatement psmt; 
	//statement = connect를 이용해 sql 명령을 실행하는 객체 (sql 명령어를 사용할 수 있게 됨)
	//현장에선 preparedstatement 사용. ?에 값을 넣을 수 있음.
	final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
	final String USER = "c##scott";
	final String PASSWORD = "tiger"; 
	//final = 변수의 상수화(한번 값을 대입하면, 다시는 값을 바꾸지 못한다. 선언할 때 한번만 값을 대입할 수 있음) 
	//-> url 등은 누군가 함부로 변경하면 안 되기 때문.

	public int insertMember(MemberDTO dto) { //리턴 타입이 int인 메소드 생성. 매개변수는 dto.
		int successCount = 0;
		
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD); 
			//DriverManager = oracle에서 제공한 자바와 오라클의 연동이 가능한 프로그램
			//로드된 드라이버를 통해서 Connection을 활성화해주는 객체
			String sql = "insert into member(mno, mid, mpwd, "
					+ "tel1, tel2, tel3, email1, email2, mdate) "
					+ "values(mno_seq.nextval, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getMid() ); //psmt와 setString은 세트. 항상 같이 씀. 1 = 첫 번째 물음표
			psmt.setString(2, dto.getMpwd() ); // 2 = 두 번째 물음표.
			psmt.setString(3, dto.getTel1() );
			psmt.setString(4, dto.getTel2() );
			psmt.setString(5, dto.getTel3() );
			psmt.setString(6, dto.getEmail1() );
			psmt.setString(7, dto.getEmail2() );
			
			successCount = psmt.executeUpdate();
			
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
		return successCount; //리턴 값이 없으면 에러. 
	}//insertMember
}
